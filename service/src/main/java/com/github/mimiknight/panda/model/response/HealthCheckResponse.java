package com.github.mimiknight.panda.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康检查响应参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Setter
@Getter
public class HealthCheckResponse implements EcologyResponse {

    @JsonProperty(value = "service_name" , index = 1)
    private String serviceName;

    @JsonProperty(value = "run_status" , index = 2)
    private String runStatus;
}
