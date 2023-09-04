package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.service.standard.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 保存内容处理器类
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-09 20:32:18
 */
@Component
public class SaveArticleHandler implements EcologyRequestHandler<SaveArticleRequest, SaveArticleResponse> {

    @Autowired
    private ArticleService articleService;

    @Override
    public void handle(SaveArticleRequest request, SaveArticleResponse response) throws Exception {
        String title = request.getTitle();
        String article = request.getArticle();
        articleService.save(title, article);
    }
}
