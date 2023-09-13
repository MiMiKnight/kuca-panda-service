package com.github.mimiknight.panda.common.error.er;

import com.github.mimiknight.kuca.simple.error.standard.ErrorTipErrorReturn;
import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import com.github.mimiknight.kuca.simple.error.tip.ErrorTip;
import com.github.mimiknight.panda.common.error.et.ErrorType;

public enum ParamValidER implements ErrorTipErrorReturn {
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
    private final ErrorTip message;

    /**
     * 错误返回
     *
     * @param errorCode 错误代码
     * @param message   错误提示消息
     */
    ParamValidER(String errorCode, ErrorTip message) {
        this.errorCode = errorCode;
        this.errorType = ErrorType.PARAM_VALID_FAILED;
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
    public ErrorTip getMessage() {
        return message;
    }
}
