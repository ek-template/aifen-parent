/*
 * Copyright (c) 2019-2019 http://www.aifen.org
 * http://www.aifen.org PROPRIETARY/CONFIDENTIAL.
 * All rights reserved.
 * author qierkang xyqierkang@163.com
 *
 */
package com.aifen.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统配置 前端控制器
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-04-07
 */
@RestController
@RequestMapping(value = {"/sys/mgr/config"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
@Slf4j
public class AfConfigController {

}
