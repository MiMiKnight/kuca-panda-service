package com.github.mimiknight.panda.model.request;

import com.github.mimiknight.kuca.ecology.model.request.EcologyRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 上传文章图片接口请求参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Builder
@Getter
@Setter
public class UploadArticleImageRequest implements EcologyRequest {

    private List<MultipartFile> files;

}
