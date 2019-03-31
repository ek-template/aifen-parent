/*
 * Copyright (c) 2019-2019 http://www.aifen.org
 * http://www.aifen.org PROPRIETARY/CONFIDENTIAL.
 * All rights reserved.
 * author qierkang xyqierkang@163.com
 *
 */
package com.aifen.controller;


import com.aifen.aspect.LogUtil;
import com.aifen.model.SysMgrUser;
import com.aifen.model.vo.SysMgrUserVo;
import com.aifen.response.BaseResponse;
import com.aifen.service.ISysMgrUserService;
import com.aifen.service.impl.SysMgrUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-03-31
 */
@RestController
@RequestMapping(value = {"/sys/mgr/user"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
@Slf4j
public class SysMgrUserController {

    @Autowired
    private ISysMgrUserService sysMgrUserService;

    @GetMapping("list")
    @ResponseBody
    public BaseResponse list(SysMgrUserVo vo) throws Exception {
        String logMes = "查询用户基本数据";
        try {
            LogUtil.pushLog(logMes, Thread.currentThread().getStackTrace()[1].getMethodName(), vo.toString(), vo.getToken());
            return BaseResponse.success(sysMgrUserService.list(vo));
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.pushErrorLog(logMes, Thread.currentThread().getStackTrace()[1].getMethodName(), vo.toString(), vo.getToken(), e.getMessage());
            return BaseResponse.error(e.getMessage());
        }
    }

//    @PostMapping("detail")
//    @ResponseBody
//    public BaseResponse detail(@RequestBody OrderBaseinfoVo vo) throws Exception {
//        String logMes = "信审全量查询订单详情";
//        try {
//            LogUtil.pushLog(logMes, Thread.currentThread().getStackTrace()[1].getMethodName(), vo.toString(), vo.getToken());
//            return BaseResponse.success(manageOrderBaseinfoService.selectCdtOrderDetail(vo.getOrderId()));
//        } catch (Exception e) {
//            e.printStackTrace();
//            LogUtil.pushErrorLog(logMes, Thread.currentThread().getStackTrace()[1].getMethodName(), vo.toString(), vo.getToken(), e.getMessage());
//            return BaseResponse.error(e.getMessage());
//        }
//    }
}
