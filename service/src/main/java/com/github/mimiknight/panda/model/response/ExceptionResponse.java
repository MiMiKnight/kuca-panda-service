package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ExceptionResponse implements EcologyResponse {

    /**
     * 错误码
     */
    @JsonProperty(value = "error_code")
    private String errorCode;

    /**
     * 错误类型
     */
    @JsonProperty(value = "error_type")
    private String errorType;

    /**
     * 数据
     */
    @JsonProperty(value = "data")
    private Object data;

}
