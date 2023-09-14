package com.github.mimiknight.panda.common.error.er;

import com.github.mimiknight.kuca.simple.error.standard.ErrorTipErrorReturn;
import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import com.github.mimiknight.kuca.simple.error.tip.ErrorTip;
import com.github.mimiknight.panda.common.error.et.ErrorType;

/**
 * 公共错误返回对象
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-14 23:47:48
 */
public enum CommonER implements ErrorTipErrorReturn {

    ;

    //********************************************************************************************************//
    private final String errorCode;
    private final ErrorType errorType;
    private final ErrorTip message;

    /**
     * @param errorCode 错误码
     * @param errorType 错误类型
     * @param tip       错误提示信息
     */
    CommonER(String errorCode, ErrorType errorType, String tip) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.message = ErrorTip.build(tip);
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
