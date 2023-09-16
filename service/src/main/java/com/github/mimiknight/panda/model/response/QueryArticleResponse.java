package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import com.github.mimiknight.panda.model.response.respvo.QueryArticleRespVo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 保存文章响应参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Getter
@Setter
public class QueryArticleResponse implements EcologyResponse {

    @JsonProperty(value = "articles")
    private List<QueryArticleRespVo> queryArticleRespVos;
}
