package com.github.mimiknight.panda.common.error.er;

import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import com.github.mimiknight.kuca.simple.error.standard.StringErrorReturn;
import com.github.mimiknight.panda.common.error.et.ErrorType;

public enum CommonER implements StringErrorReturn {

    ;

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误类型
     */
    private final ErrorType errorType;


    /**
     * 错误提示消息
     */
    private final String message;

    /**
     * 错误返回
     *
     * @param errorCode 错误代码
     * @param errorType 错误类型
     * @param message   错误提示消息
     */
    CommonER(String errorCode, ErrorType errorType, String message) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.message = message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public IErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
