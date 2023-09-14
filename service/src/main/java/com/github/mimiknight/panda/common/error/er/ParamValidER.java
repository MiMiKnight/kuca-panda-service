package com.github.mimiknight.panda.common.error.er;

import com.github.mimiknight.kuca.simple.error.standard.ErrorTipErrorReturn;
import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import com.github.mimiknight.kuca.simple.error.tip.ErrorFieldTip;
import com.github.mimiknight.kuca.simple.error.tip.ErrorTip;
import com.github.mimiknight.panda.common.error.ec.ParamValidEC;
import com.github.mimiknight.panda.common.error.et.ErrorType;

/**
 * 参数校验错误返回对象
 * <p>
 * 项目内手动校验参数返回对象
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-14 23:47:48
 */
public enum ParamValidER implements ErrorTipErrorReturn {
    AGE_VALID_FAILED(ParamValidEC.CODE_001, "age", "age valid failed.");

    //********************************************************************************************************//

    private final String errorCode;
    private final ErrorType errorType;
    private final ErrorTip message;

    /**
     * @param errorCode 错误码
     * @param field     字段名称
     * @param tip       提示信息
     */
    ParamValidER(String errorCode, String field, String tip) {
        this.errorCode = errorCode;
        this.errorType = ErrorType.PARAM_VALID_FAILED;
        this.message = ErrorFieldTip.build(field, tip);
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
