package com.aifen.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aifen.dao.SysMgrUserMapper;
import com.aifen.model.SysMgrUser;
import com.aifen.model.vo.SysMgrUserVo;
import com.aifen.service.ISysMgrUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统用户表 服务实现类
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-03-31
 */
@Service
public class SysMgrUserServiceImpl extends ServiceImpl<SysMgrUserMapper, SysMgrUser> implements ISysMgrUserService {

    @Override
    public PageInfo<SysMgrUser> list(SysMgrUserVo vo) {
        //如果需要传递对象 xml查询
        Map<String, Object> params = BeanUtil.beanToMap(vo);
        PageHelper.startPage(vo.getPageIndex(), vo.getPageSize());
        List<SysMgrUser> list=baseMapper.selectList(new QueryWrapper<>());
        PageInfo<SysMgrUser> pageLists = new PageInfo<>(list);
        return pageLists;
    }
}
