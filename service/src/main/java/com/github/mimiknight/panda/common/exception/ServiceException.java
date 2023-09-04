package com.github.mimiknight.panda.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 自定义业务异常
 * <p>
 * 状态码 400：请求参数校验未通过异常
 * <p>
 * 状态码 500：服务异常
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-10 19:04:16
 */
@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -6162198998783603161L;

    /**
     * HTTP 状态码
     */
    private final int statusCode;

    /**
     * 错误码
     */
    private final String errorCode;

    /**
     * 错误消息
     */
    private final String message;

    /**
     * @param statusCode HTTP 状态码
     * @param errorCode  错误码
     * @param message    错误消息
     */
    public ServiceException(int statusCode, String errorCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    /**
     * @param httpStatus HTTP 状态码
     * @param errorCode  错误码
     * @param message    错误消息
     */
    public ServiceException(HttpStatus httpStatus, String errorCode, String message) {
        this(httpStatus.value(), errorCode, message);
    }

    /**
     * 默认状态码：500
     *
     * @param errorCode 错误码
     * @param message   错误消息
     */
    public ServiceException(String errorCode, String message) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, message);
    }

    /**
     * @param statusCode HTTP 状态码
     * @param errorCode  错误码
     * @param message    错误消息
     * @param cause      异常原因
     */
    public ServiceException(int statusCode, String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.message = message;
    }

    /**
     * @param httpStatus HTTP 状态码
     * @param errorCode  错误码
     * @param message    错误消息
     * @param cause      异常原因
     */
    public ServiceException(HttpStatus httpStatus, String errorCode, String message, Throwable cause) {
        this(httpStatus.value(), errorCode, message, cause);
    }

    /**
     * 默认状态码：500
     *
     * @param errorCode 错误码
     * @param message   错误消息
     * @param cause     异常原因
     */
    public ServiceException(String errorCode, String message, Throwable cause) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, errorCode, message, cause);
    }

}
