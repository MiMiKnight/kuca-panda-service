package com.github.mimiknight.panda.common.aspect;

import com.github.mimiknight.panda.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
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
     * 缺失Servlet请求参数异常
     * <p>
     * 400
     *
     * @param e MissingServletRequestParameterException
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
     * 缺失Servlet请求组件异常
     * <p>
     * 400
     *
     * @param e MissingServletRequestPartException
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
     * @param e MethodArgumentTypeMismatchException
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
