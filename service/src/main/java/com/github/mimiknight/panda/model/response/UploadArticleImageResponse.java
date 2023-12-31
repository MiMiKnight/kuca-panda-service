package com.github.mimiknight.panda.model.response;

import com.github.mimiknight.kuca.ecology.model.response.EcologyResponse;
import lombok.Getter;
import lombok.Setter;

/**
 * 上传文章图片接口响应参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Getter
@Setter
public class UploadArticleImageResponse implements EcologyResponse {

    private String tip = "success";

}
