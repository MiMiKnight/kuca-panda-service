package com.github.mimiknight.panda.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.request.EcologyRequest;
import com.github.mimiknight.kuca.validation.annotation.validation.KucaMax;
import com.github.mimiknight.kuca.validation.annotation.validation.KucaMin;
import com.github.mimiknight.kuca.validation.annotation.validation.KucaNotBlank;
import com.github.mimiknight.kuca.validation.annotation.validation.KucaNotEmpty;
import com.github.mimiknight.kuca.validation.annotation.validation.KucaNotNull;
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

    @KucaNotEmpty(errorCode = "1001001")
    @JsonProperty(value = "article_ids")
    private List<@KucaNotBlank(errorCode = "1001005") String> articleIds;

    @KucaNotNull(errorCode = "1001002")
    @KucaMin(min = 1, errorCode = "1001003")
    @KucaMax(max = 200, errorCode = "1001004")
    @JsonProperty(value = "age")
    private Integer age;

}
