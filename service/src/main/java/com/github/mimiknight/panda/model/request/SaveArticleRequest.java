package com.github.mimiknight.panda.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.request.EcologyRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * 保存文章内容请求参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Getter
@Setter
public class SaveArticleRequest implements EcologyRequest {

    /**
     * 文章标题
     */
    @JsonProperty(value = "title")
    private String title;

    /**
     * 文章内容
     */
    @JsonProperty(value = "article")
    private String article;
}
