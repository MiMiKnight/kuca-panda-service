package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.panda.model.request.UploadArticleImageRequest;
import com.github.mimiknight.panda.model.response.UploadArticleImageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UploadArticleImageHandler implements EcologyRequestHandler<UploadArticleImageRequest, UploadArticleImageResponse> {

    @Override
    public void handle(UploadArticleImageRequest request, UploadArticleImageResponse response) throws Exception {
        log.info("upload-article-image");
    }
}
