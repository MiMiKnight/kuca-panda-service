package com.github.mimiknight.panda.common.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

/**
 * 性别枚举
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-10-22 17:51:11
 */
@Getter
public enum ArticleAuditStatusEnum {

    /**
     * 审核未通过
     */
    NOT_PASSED(0, "not passed"),

    /**
     * 审核通过
     */
    PASSED(1, "passed"),

    /**
     * 审核中
     */
    UNDER_AUDIT(2, "under audit");

    private final Integer code;

    @JsonValue
    private final String type;

    ArticleAuditStatusEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }
}
