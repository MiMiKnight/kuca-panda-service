package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页响应抽象类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-20 16:23:13
 */
@Data
public abstract class PaginationResponse<T> implements EcologyResponse {

    /**
     * 总记录数
     */
    @JsonProperty(value = "total", index = 1)
    private Long total;

    /**
     * 当前页码
     */
    @JsonProperty(value = "page_index", index = 2)
    private Long pageIndex;

    /**
     * 每页记录数
     */
    @JsonProperty(value = "page_size", index = 3)
    private Long pageSize;

    /**
     * 结果集
     */
    @JsonProperty(value = "results", index = 4)
    private List<T> results = Collections.emptyList();

}