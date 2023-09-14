package com.github.mimiknight.panda.rest.standard;

import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.response.HealthCheckResponse;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

public class ApiStandard {

    @Tag(name = "健康检查模块前端控制器")
    public interface Health {

        @Operation(summary = "健康检查接口", description = "查看项目运行状态")
        HealthCheckResponse check() throws Exception;
    }

    @Tag(name = "Article模块前端控制器")
    public interface Article {

        @Operation(summary = "发表文章接口", description = "普通用户发表文章")
        SaveArticleResponse publishArticle(SaveArticleRequest request) throws Exception;

        @Operation(summary = "查询文章接口", description = "根据文章主键批量查询文章")
        QueryArticleResponse queryArticleById(QueryArticleRequest request) throws Exception;

        @Operation(summary = "文章图片上传接口", description = "批量上传文章图片接口")
        UploadArticleImageResponse batchUploadArticleImage(List<MultipartFile> files) throws Exception;

        @Operation(summary = "文章图片下载接口", description = "文章图片下载接口")
        StreamingResponseBody downloadArticleImage(DownloadArticleImageRequest request) throws Exception;

    }
}
