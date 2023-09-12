package com.github.mimiknight.panda.common.exception;

import com.github.mimiknight.panda.common.enumeration.ErrorReturn;
import lombok.Getter;

/**
 * 自定义业务异常
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-03-10 19:04:16
 */
@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = -6162198998783603161L;

    private final ErrorReturn errorReturn;


    public ServiceException(ErrorReturn errorReturn) {
        super(errorReturn.getErrorCode() + "::" + errorReturn.getMessage());
        this.errorReturn = errorReturn;
    }

    public ServiceException(ErrorReturn errorReturn, Throwable cause) {
        super(errorReturn.getErrorCode() + "::" + errorReturn.getMessage(), cause);
        this.errorReturn = errorReturn;
    }

}
