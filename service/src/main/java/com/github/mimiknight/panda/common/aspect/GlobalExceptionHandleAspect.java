package com.github.mimiknight.panda.common.aspect;

import com.github.mimiknight.kuca.simple.aspect.BaseGlobalExceptionHandle;
import com.github.mimiknight.kuca.simple.error.standard.ErrorFieldTipErrorReturn;
import com.github.mimiknight.kuca.simple.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 全局异常处理切面
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-09-10 09:32:54
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandleAspect extends BaseGlobalExceptionHandle {

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
        return null;
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
        return null;
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
        return null;
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
    public ResponseEntity<ExceptionResponse> handle(MethodArgumentNotValidException e) throws NoSuchFieldException {
        String message = e.getMessage();
        MethodParameter parameter = e.getParameter();
        Throwable cause = e.getCause();
        BindingResult bindingResult = e.getBindingResult();
        int errorCount = e.getErrorCount();
        List<ObjectError> allErrors = e.getAllErrors();
        FieldError fieldError = e.getFieldError();
        int fieldErrorCount = e.getFieldErrorCount();


        // 被校验对象Class
        Class<?> parameterType = parameter.getParameterType();

        // 字段名称
        String fieldName = fieldError.getField();

        // 校验注解名称
        String code = fieldError.getCode();

        // 反射获取校验字段
        Field field = parameterType.getDeclaredField(fieldName);

        Annotation[] declaredAnnotations = field.getDeclaredAnnotations();

        // 错误提示信息
        String defaultMessage = fieldError.getDefaultMessage();
        return null;
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
