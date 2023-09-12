package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionResponse implements EcologyResponse {

    /**
     * HTTP 状态码
     */
    @JsonProperty(value = "status_code", index = 1)
    private int statusCode;

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code", index = 2)
    private String errorCode;

    /**
     * 错误类型
     */
    @JsonProperty(value = "error_type", index = 3)
    private String errorType;

    /**
     * 数据
     */
    @JsonProperty(value = "data", index = 4)
    private Object data;

}
