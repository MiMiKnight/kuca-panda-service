package com.github.mimiknight.panda.rest.handler.article;

import com.github.mimiknight.kuca.ecology.handler.EcologyRequestHandler;
import com.github.mimiknight.kuca.ecology.model.response.StreamingResponse;
import com.github.mimiknight.panda.model.request.DownloadArticleImageRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;

@Slf4j
@Component
public class DownloadArticleImageHandler implements EcologyRequestHandler<DownloadArticleImageRequest, StreamingResponse> {

    @Autowired
    private HttpServletResponse servletResponse;

    @Override
    public void handle(DownloadArticleImageRequest request, StreamingResponse response) throws Exception {
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

        // 设置响应头
        servletResponse.setHeader(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
        servletResponse.setHeader(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=%s", file.getFilename()));
        servletResponse.setHeader(HttpHeaders.PRAGMA, "no-cache");
        servletResponse.setHeader(HttpHeaders.EXPIRES, "0");

        response.setBody(body);

    }
}
