package com.github.mimiknight.panda.common.error.et;

import com.github.mimiknight.kuca.simple.error.standard.IErrorType;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 错误类型
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-10 07:47:36
 */
@Getter
public enum ErrorType implements IErrorType {

    /**
     * 参数校验异常
     * <p>
     * 400
     */
    PARAM_VALID_FAILED("Parameter Validate Failed", HttpStatus.BAD_REQUEST),

    /**
     * 资源未找到异常
     * <p>
     * 404
     */
    RESOURCE_NOT_FOUND("404 Not Found", HttpStatus.NOT_FOUND),

    /**
     * 请求方法不允许异常
     * <p>
     * 405
     */
    METHOD_NOT_ALLOWED("Method Not Allowed", HttpStatus.METHOD_NOT_ALLOWED),

    /**
     * 客户端异常
     * <p>
     * 406
     */
    CLIENT_EXCEPTION("Client Exception", HttpStatus.NOT_ACCEPTABLE),

    /**
     * 系统异常
     * <p>
     * 500
     */
    SYSTEM_EXCEPTION("System Exception", HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * 服务端异常
     * <p>
     * 500
     */
    SERVER_EXCEPTION("Server Exception", HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * 业务异常
     * <p>
     * 500
     */
    BUSINESS_EXCEPTION("Business Exception", HttpStatus.INTERNAL_SERVER_ERROR),

    /**
     * 调用接口异常
     * <p>
     * 501
     */
    CALL_API_EXCEPTION("Call API Exception", HttpStatus.NOT_IMPLEMENTED),

    /**
     * SQL异常
     * <p>
     * 502
     */
    SQL_EXCEPTION("SQL Exception", HttpStatus.BAD_GATEWAY),

    /**
     * 数据库异常
     * <p>
     * 503
     */
    DATABASE_EXCEPTION("Database Exception", HttpStatus.SERVICE_UNAVAILABLE);

    //********************************************************************************************************//

    /**
     * 异常类型名称
     */
    private final String name;

    /**
     * HTTP状态码
     */
    private final int statusCode;

    /**
     * 构造方法
     *
     * @param name           异常类型名称
     * @param httpStatusCode HTTP状态码
     */
    ErrorType(String name, int httpStatusCode) {
        this.name = name;
        this.statusCode = httpStatusCode;
    }

    /**
     * 构造方法
     *
     * @param name       异常类型名称
     * @param httpStatus HTTP状态码 {@link HttpStatus}
     */
    ErrorType(String name, HttpStatus httpStatus) {
        this(name, httpStatus.value());
    }
}
