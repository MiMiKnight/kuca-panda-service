package com.github.mimiknight.panda.rest.standard;

import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.response.HealthCheckResponse;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

public class ApiStandard {

    /**
     * 健康检查模块
     */
    public interface Health {

        HealthCheckResponse check() throws Exception;
    }

    /**
     * Article模块
     */
    public interface Article {

        SaveArticleResponse publishArticle(SaveArticleRequest request) throws Exception;

        QueryArticleResponse queryArticleById(QueryArticleRequest request) throws Exception;

        UploadArticleImageResponse batchUploadArticleImage(List<MultipartFile> files) throws Exception;

        StreamingResponseBody downloadArticleImage(DownloadArticleImageRequest request) throws Exception;

    }
}
