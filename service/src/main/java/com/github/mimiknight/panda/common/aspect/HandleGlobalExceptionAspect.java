package com.github.mimiknight.panda.common.aspect;

import com.github.mimiknight.panda.common.enumeration.ErrorReturn;
import com.github.mimiknight.panda.common.enumeration.ErrorType;
import com.github.mimiknight.panda.common.exception.BusinessException;
import com.github.mimiknight.panda.common.exception.ParamValidException;
import com.github.mimiknight.panda.model.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 全局异常处理切面
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
@ControllerAdvice
public class HandleGlobalExceptionAspect {

    /**
     * 注解校验参数异常
     */

    /**
     * 手动校验参数异常
     *
     * @param e 异常类型 {@link ParamValidException}
     * @return {@link ExceptionResponse}<{@link ?}>
     */
    @ExceptionHandler(value = ParamValidException.class)
    public ResponseEntity<ExceptionResponse> handle(ParamValidException e) {
        // TODO 待完善
        return null;
    }

    /**
     * 自定义业务异常
     *
     * @param e 异常类型 {@link BusinessException}
     * @return {@link ExceptionResponse}<{@link ?}>
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ExceptionResponse> handle(BusinessException e) {
        return build(e.getErrorReturn());
    }

    /**
     * 系统致命异常处理
     * <p>
     * 500
     *
     * @param e 异常类型 {@link Throwable}
     * @return {@link ExceptionResponse}<{@link ?}>
     */
    @ExceptionHandler(value = Throwable.class)
    public ResponseEntity<ExceptionResponse> handle(Throwable e) {
        return build(ErrorReturn.SYSTEM_FATAL_ERROR);
    }

    /**
     * 系统非运行时异常处理
     * <p>
     * 500
     *
     * @param e 异常类型 {@link Exception}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ExceptionResponse> handle(Exception e) {
        return build(ErrorReturn.SYSTEM_NON_RUNTIME_ERROR);
    }

    /**
     * 系统运行时异常处理
     * <p>
     * 500
     *
     * @param e 异常类型 {@link Exception}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handle(RuntimeException e) {
        return build(ErrorReturn.SYSTEM_RUNTIME_ERROR);
    }

    /**
     * 不支持 HTTP 媒体类型异常
     * <p>
     * 500
     *
     * @param e 异常类型 {@link HttpMediaTypeNotSupportedException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handle(HttpMediaTypeNotSupportedException e) {
        return build(ErrorReturn.SYSTEM_FATAL_ERROR);
    }

    /**
     * HTTP 消息不可读异常
     * <p>
     * 500
     *
     * @param e 异常类型 {@link HttpMessageNotReadableException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handle(HttpMessageNotReadableException e) {
        // TODO 待完善
        return null;
    }

    /**
     * http 消息不可写异常
     * <p>
     * 500
     *
     * @param e 异常类型 {@link HttpMessageNotWritableException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = HttpMessageNotWritableException.class)
    public ResponseEntity<ExceptionResponse> handle(HttpMessageNotWritableException e) {
        // TODO 待完善
        return null;
    }

    /**
     * 缺失Servlet请求参数异常
     * <p>
     * 400
     *
     * @param e {@link MissingServletRequestParameterException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<ExceptionResponse> handle(MissingServletRequestParameterException e) {
        return build(ErrorReturn.MISSING_SERVLET_REQUEST_PARAMETER_ERROR);
    }

    /**
     * 缺失请求头异常
     * <p>
     * 400
     *
     * @param e {@link MissingRequestHeaderException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = MissingRequestHeaderException.class)
    public ResponseEntity<ExceptionResponse> handle(MissingRequestHeaderException e) {
        return build(ErrorReturn.MISSING_REQUEST_HEADER_ERROR);
    }

    /**
     * 缺失Servlet请求组件异常
     * <p>
     * 400
     *
     * @param e {@link MissingServletRequestPartException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = MissingServletRequestPartException.class)
    public ResponseEntity<ExceptionResponse> handle(MissingServletRequestPartException e) {
        return build(ErrorReturn.MISSING_SERVLET_REQUEST_PART_ERROR);
    }

    /**
     * 参数类型不匹配异常
     * <p>
     * 400
     *
     * @param e {@link MethodArgumentTypeMismatchException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionResponse> handle(MethodArgumentTypeMismatchException e) {
        return build(ErrorReturn.METHOD_ARGUMENT_TYPE_MISMATCH_ERROR);
    }

    /**
     * 未找到处理程序异常
     * <p>
     * 404
     *
     * @param e {@link NoHandlerFoundException}
     * @return {@link ExceptionResponse}
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public ResponseEntity<ExceptionResponse> handle(NoHandlerFoundException e) {
        return build(ErrorReturn.NO_HANDLER_FOUND_ERROR);
    }

    /**
     * 不支持 HTTP 请求方法异常
     * <p>
     * 405
     *
     * @param e {@link HttpRequestMethodNotSupportedException}
     * @return {@link ExceptionResponse}
     */
    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handle(HttpRequestMethodNotSupportedException e) {
        return build(ErrorReturn.HTTP_REQUEST_METHOD_NOT_SUPPORTED_ERROR);
    }

    /**
     * 构建响应
     *
     * @param eReturn 错误返回对象
     * @return {@link ResponseEntity}<{@link ExceptionResponse}>
     */
    private ResponseEntity<ExceptionResponse> build(ErrorReturn eReturn) {
        ExceptionResponse body = buildExceptionResponse(eReturn);
        return ResponseEntity.status(eReturn.getErrorType().getStatusCode())
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    private ExceptionResponse buildExceptionResponse(ErrorReturn eReturn) {
        ErrorType errorType = eReturn.getErrorType();
        String errorTypeName = errorType.getName();
        int statusCode = errorType.getStatusCode();
        return ExceptionResponse.builder()
                .statusCode(statusCode)
                .errorCode(eReturn.getErrorCode())
                .errorType(errorTypeName)
                .data(eReturn.getMessage()).build();
    }
}
