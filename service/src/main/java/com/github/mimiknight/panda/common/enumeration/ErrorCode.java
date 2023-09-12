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

    //************************************系统异常*************************************//
    String SYSTEM_CODE_001 = "99-000-001";
    String SYSTEM_CODE_002 = "99-000-002";
    String SYSTEM_CODE_003 = "99-000-003";

    //********************************注解参数校验异常***********************************//
    String ANNOTATION_VALID_CODE_001 = "98-000-001";
    String ANNOTATION_VALID_CODE_002 = "98-000-002";
    String ANNOTATION_VALID_CODE_003 = "98-000-003";

    //********************************手动参数校验异常***********************************//
    String MANUAL_VALID_CODE_001 = "97-000-001";
    String MANUAL_VALID_CODE_002 = "97-000-002";

    //************************************业务异常*************************************//
    String SERVICE_CODE_001 = "96-000-001";
    String SERVICE_CODE_002 = "96-000-002";
    String SERVICE_CODE_003 = "96-000-003";

    //************************************调用第三方接口异常******************************//
    String CALL_API_CODE_001 = "95-000-001";
    String CALL_API_CODE_002 = "95-000-002";

    //************************************SQL异常**************************************//
    String SQL_CODE_001 = "94-000-001";
    String SQL_CODE_002 = "94-000-002";


}