package com.github.mimiknight.panda.common.tip;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 错误提示类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Data
public class ErrorTip {

    @JsonProperty(value = "tip")
    private String tip;

    /**
     * 空参构造
     */
    ErrorTip() {
    }

    /**
     * 有参构造
     */
    ErrorTip(String tip) {
        this.tip = tip;
    }

    /**
     * 构建ErrorTip
     *
     * @param tip 提示信息
     * @return {@link ErrorTip}
     */
    public static ErrorTip build(String tip) {
        return new ErrorTip(tip);
    }

}
