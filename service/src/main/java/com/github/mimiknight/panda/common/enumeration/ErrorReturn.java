package com.github.mimiknight.panda.common.enumeration;

import com.github.mimiknight.panda.common.tip.ErrorFieldTip;
import com.github.mimiknight.panda.common.tip.ErrorTip;
import lombok.Getter;

/**
 * 错误信息类
 * <p>
 * 每个错误信息类有且仅被允许使用一次，以保持错误码的唯一性（需要用户自己注意，系统无法扫描检查）
 * <p>
 * 项目启动时会扫描检测错误码，如果错误码存在重复定义则项目会启动失败并抛出异常
 * <p>
 * 格式：
 * <p>
 * HD.AAABBBB
 * <p>
 * AAA：项目编号
 * <p>
 * BBBB：异常编码
 * <p>
 * 错误提示类 {@link  ErrorTip}
 * <p>
 * 字段错误提示类 {@link  ErrorFieldTip}
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-10 18:46:29
 */
@Getter
public enum ErrorReturn {

    //************************************系统异常*************************************//
    SYSTEM_FATAL_ERROR(ErrorCode.SYSTEM_CODE_001, ErrorType.SYSTEM_EXCEPTION, "System fatal exception."),
    SYSTEM_NON_RUNTIME_ERROR(ErrorCode.SYSTEM_CODE_002, ErrorType.SYSTEM_EXCEPTION, "System non-runtime exception."),
    SYSTEM_RUNTIME_ERROR(ErrorCode.SYSTEM_CODE_003, ErrorType.SYSTEM_EXCEPTION, "System runtime exception."),

    //*********************************资源未找到异常************************************//

    //********************************手动参数校验异常***********************************//

    //************************************业务异常*************************************//

    /**
     * 获取锁失败
     */
    GET_LOCK_FAILED(ErrorCode.SERVICE_CODE_001, "Failed to get the lock.");

    //**********************************调用接口异常************************************//

    //********************************************************************************************************//

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
    ErrorReturn(String errorCode, ErrorType errorType, String message) {
        this.errorCode = errorCode;
        this.errorType = errorType;
        this.message = message;
    }

    /**
     * 错误返回
     *
     * @param errorCode 错误代码
     * @param message   错误提示消息
     */
    ErrorReturn(String errorCode, String message) {
        this(errorCode, ErrorType.SERVICE_EXCEPTION, message);
    }
}