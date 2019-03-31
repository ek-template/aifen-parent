package com.aifen.service;

import com.aifen.model.SysMgrUser;
import com.aifen.model.vo.SysMgrUserVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 * 系统用户表 服务类
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-03-31
 */
public interface ISysMgrUserService extends IService<SysMgrUser> {

    /**
     * <pre>
     * 查询用户基本列表
     * 文档详见: http://showdoc.qierkang.org/web/#/9?page_id=417 访问密码：666666
     * </pre>
     */
    PageInfo<SysMgrUser> list(SysMgrUserVo vo);
}
