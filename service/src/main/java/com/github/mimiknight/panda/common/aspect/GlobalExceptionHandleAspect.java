package com.github.mimiknight.panda.common.aspect;

import com.github.mimiknight.kuca.simple.aspect.BaseGlobalExceptionHandle;
import com.github.mimiknight.kuca.simple.error.tip.ErrorFieldTip;
import com.github.mimiknight.kuca.simple.error.tip.ErrorTip;
import com.github.mimiknight.kuca.simple.response.ExceptionResponse;
import com.github.mimiknight.kuca.validation.action.KucaConstraintHelper;
import com.github.mimiknight.kuca.validation.model.AnnotationParamValidErrorTip;
import com.github.mimiknight.panda.common.error.et.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.function.Supplier;

/**
 * 全局异常处理切面
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandleAspect extends BaseGlobalExceptionHandle {

    private ResponseEntity<ExceptionResponse> buildDefaultExceptionResponse() {
        int statusCode = ErrorType.SYSTEM_EXCEPTION.getStatusCode();
        String errorType = ErrorType.SYSTEM_EXCEPTION.getName();
        String errorCode = "1022555";
        String message = "The service exception.";
        ErrorTip errorTip = ErrorTip.build(message);

        ExceptionResponse response = ExceptionResponse.builder()
                .statusCode(statusCode)
                .errorCode(errorCode)
                .errorType(errorType)
                .data(errorTip).build();

        return ResponseEntity.status(statusCode)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

    private ResponseEntity<ExceptionResponse> handle(Supplier<ResponseEntity<ExceptionResponse>> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) { // 若全局异常处理切面中的代码逻辑引发异常，则作出该默认提示
            log.error("Handle GlobalExceptionHandleAspect Exception,message = {}", e.getMessage());
            return buildDefaultExceptionResponse();
        }
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
        Supplier<ResponseEntity<ExceptionResponse>> supplier = () -> {
            return null;
        };
        return handle(supplier);
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
        Supplier<ResponseEntity<ExceptionResponse>> supplier = () -> {
            return null;
        };
        return handle(supplier);
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
        Supplier<ResponseEntity<ExceptionResponse>> supplier = () -> {
            return null;
        };
        return handle(supplier);
    }

    /**
     * 注解参数校验异常
     * <p>
     * 400
     *
     * @param e 异常类型 {@link MethodArgumentNotValidException}
     * @return {@link ResponseEntity}<{@link ExceptionResponse}>
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handle(MethodArgumentNotValidException e) {

        Supplier<ResponseEntity<ExceptionResponse>> supplier = () -> {
            // 注解校验错误提示信息对象
            AnnotationParamValidErrorTip tip = KucaConstraintHelper.createAnnotationParamValidErrorTip(e);
            // 状态码
            int statusCode = ErrorType.PARAM_VALID_FAILED.getStatusCode();
            // 错误类型
            String errorTypeName = ErrorType.PARAM_VALID_FAILED.getName();
            // 错误码
            String errorCode = tip.getErrorCode();
            // 被校验字段名称
            String fieldName = tip.getFieldName();
            // 校验提示信息
            String message = tip.getMessage();
            // 字段错误提示对象
            ErrorFieldTip errorFieldTip = ErrorFieldTip.build(fieldName, message);

            ExceptionResponse body = ExceptionResponse.builder()
                    .statusCode(statusCode)
                    .errorCode(errorCode)
                    .errorType(errorTypeName)
                    .data(errorFieldTip)
                    .build();

            return ResponseEntity.status(statusCode)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(body);
        };
        return handle(supplier);
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
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
        return null;
    }

}
