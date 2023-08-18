package com.github.mimiknight.panda.rest.handler.health;

import com.github.mimiknight.kuca.ecology.core.EcologyRequestHandler;
import com.github.mimiknight.panda.model.request.HealthCheckRequest;
import com.github.mimiknight.panda.model.response.HealthCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 健康检查处理器类
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-09 00:14:27
 */
@Slf4j
@Component
public class HealthCheckHandler implements EcologyRequestHandler<HealthCheckRequest, HealthCheckResponse> {

    @Value("${spring.application.name}")
    private String serviceName;

    @Autowired
    private ApplicationContext appContext;

    @Override
    public void handle(HealthCheckRequest request, HealthCheckResponse response) throws Exception {
        log.info("health check");
        response.setServiceName(serviceName);
    }

}
