package com.github.mimiknight.panda.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.request.EcologyRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 查询文章请求参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Getter
@Setter
public class QueryArticleRequest implements EcologyRequest {

    /**
     * 文章主键集合
     */
    @JsonProperty(value = "article_ids")
    private List<String> articleIds;

}
