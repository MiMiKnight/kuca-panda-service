package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyHandleController;
import com.github.mimiknight.kuca.ecology.model.response.SuccessResponse;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.request.UploadArticleImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Article模块前端控制器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Tag(name = "Article模块前端控制器")
@Validated
@Controller
@RequestMapping(path = ApiPath.Module.ARTICLE)
public class ArticleController extends EcologyHandleController {

    @Operation(summary = "发表文章接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/publish-article", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public SuccessResponse publishArticle(@RequestBody SaveArticleRequest request) throws Exception {
        return handle(request);
    }

    @Operation(summary = "单张上传文章图片接口")
    @PostMapping(value = "/user/v1/upload-article-image")
    public SuccessResponse uploadArticleImage(@RequestBody MultipartFile image) throws Exception {
        UploadArticleImageRequest request = new UploadArticleImageRequest();
        return handle(request);
    }

    @Operation(summary = "文章图片下载接口")
    @PostMapping(value = "/user/v1/download-article-image")
    public SuccessResponse downloadArticleImage(@RequestBody MultipartFile image) throws Exception {
        DownloadArticleImageRequest request = new DownloadArticleImageRequest();
        return handle(request);
    }

}
