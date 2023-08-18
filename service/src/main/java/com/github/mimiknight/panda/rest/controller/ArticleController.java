package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyRequestHandleAdapter;
import com.github.mimiknight.kuca.ecology.model.response.SuccessResponse;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Article模块前端控制器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Tag(name = "Article模块前端控制器")
@Validated
@RestController
@RequestMapping(path = ApiPath.Module.ARTICLE, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ArticleController extends EcologyRequestHandleAdapter {

    @Operation(summary = "保存article接口")
    @PostMapping(value = "/user/v1/save")
    public SuccessResponse v1(@RequestBody SaveArticleRequest request) throws Exception {
        return handle(request);
    }

}
