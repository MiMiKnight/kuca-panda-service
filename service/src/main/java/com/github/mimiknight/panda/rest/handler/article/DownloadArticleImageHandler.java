package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.kuca.ecology.model.response.StreamFileResponse;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
public class DownloadArticleImageHandler implements EcologyRequestHandler<DownloadArticleImageRequest, StreamFileResponse> {

    @Override
    public void handle(DownloadArticleImageRequest request, StreamFileResponse response) throws Exception {
        log.info("download-article-image");
        List<String> imageIds = request.getImageIds();

        String filePath = "F:/opt/cloud/resource/images/cat.jpg";
        FileSystemResource file = new FileSystemResource(filePath);
        if (!file.exists()) {
            throw new RuntimeException("请您输入正确的文件ID");
        }
        InputStream inputStream = file.getInputStream();
        StreamingResponseBody body = outputStream -> {
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

        response.setHeader(headers);
        response.setMediaType(MediaType.IMAGE_JPEG);
        response.setBody(body);

    }
}
