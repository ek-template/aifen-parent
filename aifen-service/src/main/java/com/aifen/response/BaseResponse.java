/*
 * Copyright (c) 2019-2019 http://www.aifen.org
 * http://www.aifen.org PROPRIETARY/CONFIDENTIAL.
 * All rights reserved.
 * author qierkang xyqierkang@163.com
 *
 */
package com.aifen.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title BaseResponse
 * @Author     qierkang xyqierkang@163.com
 * @Date       Created in 2019-03-31 13:06
 * @Description [ 统一返回 ]
 */
@Data
public class BaseResponse implements Serializable {

    /**
     * @Fields serialVersionUID : TODO[ 用一句话描述这个变量表示什么 ]
     */
    private static final long serialVersionUID = 7431264204510322466L;


    public static final String SUCCESS_CODE = "000000"; // 请求成功code

    public static final String SUCCESS_CODE_MSG = "操作成功";//请求成功mes

    public static final String ERROR_CODE = "999999";//系统错误 code

    public static final String ERROR_CODE_MSG = "系统错误";//系统错误 mes

    public static final String ERROR_REQ_FAIL_CODE = "999998";//请求失败 code

    public static final String ERROR_REQ_FAIL_MSG = "请求失败";//请求失败 mes

    public static final String ERROR_PDP_CODE = "999997";//业务抛出异常 code

    public static final String ERROR_PDP_CODE_MSG = "业务抛出异常";//业务抛出异常 mes

    public static final String ERROR_NO_PERM_CODE = "000001";

    public static final String ERROR_NO_PERM_CODE_MSG = "无权限访问";

    public static final String ERROR_NO_TOKEN_CODE = "000002";

    public static final String ERROR_NO_TOKEN_MSG = "登录失效！请重新登录";

    /**
     * 未知异常
     */
    public static final int UNKNOWN_EXCEPTION = -99;
    /**
     * @Fields code : TODO[响应编码 ]
     */
    private Object code;
    /**
     * @Fields message : TODO[响应信息 ]
     */
    private Object message;
    /**
     * 返回的数据
     */
    private Object data;


    /**
     * 无参构造函数
     */
    public BaseResponse() {
        super();
    }

    public BaseResponse(Object code, Object message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 成功返回
     *
     * @param message
     *
     * @return
     */
    //    public static BaseResponse success(String message) {
    //        return new BaseResponse(SUCCESS_CODE, message);
    //    }
    public BaseResponse(Object code, Object message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回
     *
     * @param message
     *
     * @return
     */
    //    public static BaseResponse success(String message) {
    //        return new BaseResponse(SUCCESS_CODE, message);
    //    }
    public BaseResponse(Object code, Object message, Object status, String reqSysCode) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     * 成功返回
     *
     * @param data
     *
     * @return
     */
    public static BaseResponse success(Object data) {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_CODE_MSG, data);
    }

    /**
     * 成功返回
     *
     * @param
     *
     * @return
     */
    public static BaseResponse success() {
        return new BaseResponse(SUCCESS_CODE, SUCCESS_CODE_MSG);
    }

    /**
     * 成功返回
     *
     * @param message
     *
     * @return
     */
    public static BaseResponse success(String message, Object data) {
        return new BaseResponse(SUCCESS_CODE, message, data);
    }

    /***
     * 失败返回
     * @param message
     * @return
     */
    public static BaseResponse error(String message, Object vo) {
        return new BaseResponse(ERROR_CODE, message, vo);
    }

    public static BaseResponse error() {
        return new BaseResponse(ERROR_CODE, ERROR_CODE_MSG);
    }

    public static BaseResponse errorNoPerm() {
        return new BaseResponse(ERROR_NO_PERM_CODE, ERROR_NO_PERM_CODE_MSG);

    }public static BaseResponse errorNoToken() {
        return new BaseResponse(ERROR_NO_TOKEN_CODE, ERROR_NO_TOKEN_MSG);
    }

    public static BaseResponse error(String message) {
        return new BaseResponse(ERROR_CODE, message);
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
