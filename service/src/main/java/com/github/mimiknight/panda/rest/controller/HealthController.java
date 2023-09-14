package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyHandleController;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.HealthCheckRequest;
import com.github.mimiknight.panda.model.response.HealthCheckResponse;
import com.github.mimiknight.panda.rest.standard.ApiStandard;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查前端控制器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(path = ApiPath.Module.HEALTH)
public class HealthController extends EcologyHandleController implements ApiStandard.Health {

    @GetMapping(path = "/servlet/v1/check", produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public HealthCheckResponse check() throws Exception {
        return handle(new HealthCheckRequest());
    }

}
