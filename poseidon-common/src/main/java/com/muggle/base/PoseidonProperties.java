package com.muggle.base;

public interface PoseidonProperties {
    String SUCCESS_CODE = "200";
    //    系统异常
    String ERROR_CODE = "500";
    //    请求太过频繁状态码
    String TOO_NUMBER_REQUEST = "5001";
    //    提交数据未通过校验
    String COMMIT_DATA_ERROR = "5002";
    //   请求方式错误
    String NOT_SUPPORT_METHOD = "5003";
    //    黑名单
    String BLACK_LIST_USER = "5004";
    // 参数为空
    String NULL_DATA_ERROR="5005";

    String NORMAL_EXCEPTION_CODE="5006";
}
