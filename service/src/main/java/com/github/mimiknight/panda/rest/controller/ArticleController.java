package com.github.mimiknight.panda.rest.controller;

import com.github.mimiknight.kuca.ecology.core.EcologyHandleController;
import com.github.mimiknight.kuca.ecology.model.response.SuccessResponse;
import com.github.mimiknight.panda.common.constant.ApiPath;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.request.UploadArticleImageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
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

import java.io.InputStream;
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
public class ArticleController extends EcologyHandleController {

    @Operation(summary = "发表文章接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/publish-article", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public SuccessResponse publishArticle(@RequestBody SaveArticleRequest request) throws Exception {
        return handle(request);
    }

    @Operation(summary = "文章图片上传接口")
    @ResponseBody
    @PostMapping(value = "/user/v1/upload-article-image", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public SuccessResponse batchUploadArticleImage(@RequestPart("images") List<MultipartFile> files) throws Exception {
        UploadArticleImageRequest request = new UploadArticleImageRequest();
        return handle(request);
    }

    @Operation(summary = "文章图片下载接口")
    @PostMapping(value = "/user/v1/download-article-image", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<StreamingResponseBody> downloadArticleImage(@RequestBody DownloadArticleImageRequest request) throws Exception {
        String filePath = "F:/opt/cloud/resource/images/cat.jpg";
        FileSystemResource file = new FileSystemResource(filePath);
        if (!file.exists()) {
            throw new RuntimeException("请您输入正确的文件ID");
        }
        InputStream inputStream = file.getInputStream();
        StreamingResponseBody responseBody = outputStream -> {
            int numberOfBytesToWrite;
            byte[] data = new byte[1024];
            while ((numberOfBytesToWrite = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, numberOfBytesToWrite);
            }
            inputStream.close();
        };

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", String.format("attachment; filename=%s", file.getFilename()));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(responseBody);
    }

}
