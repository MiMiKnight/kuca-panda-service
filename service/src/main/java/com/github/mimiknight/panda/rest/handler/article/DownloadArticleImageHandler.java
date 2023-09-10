package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DownloadArticleImageHandler implements EcologyRequestHandler<DownloadArticleImageRequest, UploadArticleImageResponse> {

    @Override
    public void handle(DownloadArticleImageRequest request, UploadArticleImageResponse response) throws Exception {
        log.info("download-article-image");
    }
}
