package com.github.mimiknight.panda.rest.standard;

import com.github.mimiknight.kuca.ecology.model.response.SuccessResponse;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.request.SaveArticleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.List;

public class ApiStandard {

    /**
     * 健康检查模块
     */
    public interface Health {

        ResponseEntity<SuccessResponse> check() throws Exception;
    }

    /**
     * Article模块
     */
    public interface Article {

        ResponseEntity<SuccessResponse> publishArticle(SaveArticleRequest request) throws Exception;

        ResponseEntity<SuccessResponse> batchUploadArticleImage(List<MultipartFile> files) throws Exception;

        ResponseEntity<StreamingResponseBody> downloadArticleImage(DownloadArticleImageRequest request) throws Exception;

    }
}
