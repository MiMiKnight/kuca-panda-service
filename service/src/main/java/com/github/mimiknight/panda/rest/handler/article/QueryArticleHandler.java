package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.kuca.ecology.model.response.NormalResponse;
import com.github.mimiknight.panda.mapstruct.CommonMapStruct;
import com.github.mimiknight.panda.model.entity.ArticleEntity;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.response.ArticleVO;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.service.standard.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 查询文章处理器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 15:32:27
 */
@Slf4j
@Component
public class QueryArticleHandler implements EcologyRequestHandler<QueryArticleRequest, NormalResponse<QueryArticleResponse>> {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommonMapStruct commonMapStruct;

    @Override
    public void handle(QueryArticleRequest request, NormalResponse<QueryArticleResponse> response) throws Exception {
        log.info("QueryArticleHandler");
        List<String> articleIds = request.getArticleIds();
        List<ArticleEntity> articleEntityList = articleService.queryArticleById(articleIds);

        List<ArticleVO> list = commonMapStruct.convert(articleEntityList);

        QueryArticleResponse body = new QueryArticleResponse();
        body.setArticleVOS(list);

        response.setMediaType(MediaType.APPLICATION_JSON);
        response.setBody(body);
    }
}
