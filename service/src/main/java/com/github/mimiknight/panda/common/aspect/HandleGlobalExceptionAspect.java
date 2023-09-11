package com.github.mimiknight.panda.common.aspect;

import com.github.mimiknight.panda.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 全局异常处理切面
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
@Component
@RestControllerAdvice
public class HandleGlobalExceptionAspect {

    /**
     * 默认异常处理
     * <p>
     * 500
     *
     * @param e 异常类型 {@link Throwable}
     * @return {@link ExceptionResponse}<{@link ?}>
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    public ExceptionResponse handle(Throwable e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0000")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 默认异常处理
     * <p>
     * 500
     *
     * @param e 异常类型 {@link Exception}
     * @return {@link ExceptionResponse}<{@link ?}>
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ExceptionResponse handle(Exception e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0000")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 不支持 HTTP 媒体类型异常
     * <p>
     * 500
     *
     * @param e 异常类型 {@link HttpMediaTypeNotSupportedException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ExceptionResponse handle(HttpMediaTypeNotSupportedException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0000")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * HTTP 消息不可读异常
     * <p>
     * 500
     *
     * @param e 异常类型 {@link HttpMessageNotReadableException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ExceptionResponse handle(HttpMessageNotReadableException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0000")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 缺失Servlet请求参数异常
     * <p>
     * 400
     *
     * @param e {@link MissingServletRequestParameterException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ExceptionResponse handle(MissingServletRequestParameterException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0001")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 缺失请求头异常
     * <p>
     * 400
     *
     * @param e {@link MissingRequestHeaderException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ExceptionResponse handle(MissingRequestHeaderException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0002")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 缺失Servlet请求组件异常
     * <p>
     * 400
     *
     * @param e {@link MissingServletRequestPartException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestPartException.class)
    public ExceptionResponse handle(MissingServletRequestPartException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0002")
                .errorType("System Exception")
                .data("Default Exception").build();
    }


    /**
     * 参数类型不匹配异常
     * <p>
     * 400
     *
     * @param e {@link MethodArgumentTypeMismatchException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ExceptionResponse handle(MethodArgumentTypeMismatchException e) {
        return ExceptionResponse.builder()
                .errorCode("101.F0002")
                .errorType("System Exception")
                .data("Default Exception").build();
    }

}
