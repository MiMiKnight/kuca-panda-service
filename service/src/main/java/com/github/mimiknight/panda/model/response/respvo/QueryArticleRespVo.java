package com.github.mimiknight.panda.model.response.respvo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class QueryArticleRespVo {

    /**
     * 文章主键
     */
    @JsonProperty(value = "id", index = 1)
    private String id;

    /**
     * 文章标题
     */
    @JsonProperty(value = "title", index = 2)
    private String title;

    /**
     * 文章内容
     */
    @JsonProperty(value = "content", index = 3)
    private String content;

    /**
     * 文章创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS XXX", timezone = "GMT")
    @JsonProperty(value = "created_time", index = 4)
    private ZonedDateTime createdTime;
    /**
     * 文章更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS XXX", timezone = "GMT")
    @JsonProperty(value = "updated_time", index = 5)
    private ZonedDateTime updatedTime;

}
