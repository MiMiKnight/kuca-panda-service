package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-12 08:03:34
 */
@Builder
@Setter
@Getter
public final class ReturnResponse<D extends EcologyResponse> implements EcologyResponse {

    /**
     * HTTP 响应码
     */
    @JsonProperty(value = "status_code", index = 1)
    private int statusCode;

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code", index = 2)
    private String errorCode;

    /**
     * 数据
     */
    @JsonProperty(value = "data", index = 3)
    private D data;
}
