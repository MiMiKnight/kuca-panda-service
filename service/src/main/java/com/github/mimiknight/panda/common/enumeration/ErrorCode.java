package com.github.mimiknight.panda.common.enumeration;

/**
 * 错误码
 * <p>
 * 格式：
 * <p>
 * AAA.BBB-CCC-DDDD
 * <p>
 * AAA：项目标识
 * <p>
 * BB：错误类型
 * <p>
 * CCC：错误序列
 * <p>
 * DDDD：错误码
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-05-02 15:42:51
 */
public interface ErrorCode {
    String SUCCESS_CODE = "00-000-000";

    //************************************系统异常*************************************//
    String SYSTEM_CODE_001 = "99-001-001";
    String SYSTEM_CODE_002 = "99-001-002";
    String SYSTEM_CODE_003 = "99-001-003";

    //*********************************资源未找到异常************************************//
    String NOT_FOUND_CODE_001 = "99-001-001";
    //*********************************方法不支持异常***********************************//
    String METHOD_NOT_ALLOWED_CODE_001 = "99-001-001";

    //********************************注解参数校验异常***********************************//
    String ANNOTATION_VALID_CODE_001 = "98-001-001";
    String ANNOTATION_VALID_CODE_002 = "98-001-002";
    String ANNOTATION_VALID_CODE_003 = "98-001-003";

    //********************************手动参数校验异常***********************************//
    String MANUAL_VALID_CODE_001 = "97-001-001";
    String MANUAL_VALID_CODE_002 = "97-001-002";
    String MANUAL_VALID_CODE_003 = "97-001-003";
    String MANUAL_VALID_CODE_004 = "97-001-004";

    //************************************业务异常*************************************//
    String BUSINESS_CODE_001 = "96-001-001";
    String BUSINESS_CODE_002 = "96-001-002";
    String BUSINESS_CODE_003 = "96-001-003";

    //************************************调用第三方接口异常******************************//
    String CALL_API_CODE_001 = "95-001-001";
    String CALL_API_CODE_002 = "95-001-002";

    //************************************SQL异常**************************************//
    String SQL_CODE_001 = "94-001-001";
    String SQL_CODE_002 = "94-001-002";


}