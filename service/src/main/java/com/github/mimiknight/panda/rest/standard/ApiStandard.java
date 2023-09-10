package com.github.mimiknight.panda.rest.standard;

import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.QueryArticleRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import com.github.mimiknight.panda.model.response.HealthCheckResponse;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import com.github.mimiknight.panda.model.response.SaveArticleResponse;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

public class ApiStandard {

    /**
     * 健康检查模块
     */
    public interface Health {

        ResponseEntity<HealthCheckResponse> check() throws Exception;
    }

    /**
     * Article模块
     */
    public interface Article {

        ResponseEntity<SaveArticleResponse> publishArticle(SaveArticleRequest request) throws Exception;

        ResponseEntity<QueryArticleResponse> queryArticleById(QueryArticleRequest request) throws Exception;

        ResponseEntity<UploadArticleImageResponse> batchUploadArticleImage(List<MultipartFile> files) throws Exception;

        ResponseEntity<StreamingResponseBody> downloadArticleImage(DownloadArticleImageRequest request) throws Exception;

    }
}
