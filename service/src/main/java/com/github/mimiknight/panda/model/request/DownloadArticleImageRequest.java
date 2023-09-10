package com.github.mimiknight.panda.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.mimiknight.kuca.ecology.model.request.EcologyRequest;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 文章图片下载接口请求参数
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Getter
@Setter
public class DownloadArticleImageRequest implements EcologyRequest {

    @JsonProperty(value = "image_ids")
    private List<String> imageIds;

}
