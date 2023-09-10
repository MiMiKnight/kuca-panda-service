package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyHandleController;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.request.UploadArticleImageRequest;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import com.github.mimiknight.panda.rest.standard.ApiStandard;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

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
public class ArticleController extends EcologyHandleController implements ApiStandard.Article {

    @Operation(summary = "发表文章接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/publish-article", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<SaveArticleResponse> publishArticle(@RequestBody SaveArticleRequest request) throws Exception {
        return handle(request);
    }

    @Operation(summary = "查询文章接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/query-article", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<QueryArticleResponse> queryArticleById(@RequestBody QueryArticleRequest request) throws Exception {
        return handle(request);
    }

    @Operation(summary = "文章图片上传接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/upload-article-image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<UploadArticleImageResponse> batchUploadArticleImage(@RequestPart("images") List<MultipartFile> files) throws Exception {
        UploadArticleImageRequest request = UploadArticleImageRequest.builder().files(files).build();
        return handle(request);
    }

    @Operation(summary = "文章图片下载接口")
    @PostMapping(value = "/user/v1/download-article-image", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.IMAGE_JPEG_VALUE)
    @Override
    public ResponseEntity<StreamingResponseBody> downloadArticleImage(@RequestBody DownloadArticleImageRequest request) throws Exception {
        return handle(request);
    }

}
