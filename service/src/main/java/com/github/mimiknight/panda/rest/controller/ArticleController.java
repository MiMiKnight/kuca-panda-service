package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyHandleController;
import com.github.mimiknight.kuca.ecology.model.response.StreamingResponse;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.request.UploadArticleImageRequest;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import com.github.mimiknight.panda.rest.standard.ApiStandard;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

/**
 * Article模块前端控制器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Validated
@RestController
@ResponseStatus(HttpStatus.OK)
@RequestMapping(path = ApiPath.Module.ARTICLE)
public class ArticleController extends EcologyHandleController implements ApiStandard.Article {

    @PostMapping(value = "/user/v1/publish-article", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public SaveArticleResponse publishArticle(@Validated @RequestBody SaveArticleRequest request) throws Exception {
        return handle(request);
    }

    @PostMapping(value = "/user/v1/query-article", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public QueryArticleResponse queryArticleById(@Validated @RequestBody QueryArticleRequest request) throws Exception {
        return handle(request);
    }

    @PostMapping(value = "/user/v1/upload-article-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public UploadArticleImageResponse batchUploadArticleImage(@RequestPart("images") List<MultipartFile> files) throws Exception {
        UploadArticleImageRequest request = UploadArticleImageRequest.builder().files(files).build();
        return handle(request);
    }

    @PostMapping(value = "/user/v1/download-article-image", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.IMAGE_JPEG_VALUE)
    @Override
    public StreamingResponseBody downloadArticleImage(@RequestBody DownloadArticleImageRequest request) throws Exception {
        return handleAndGetBody(request, StreamingResponse.class);
    }

}
