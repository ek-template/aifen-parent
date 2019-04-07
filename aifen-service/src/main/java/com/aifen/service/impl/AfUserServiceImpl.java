package com.aifen.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.aifen.dao.AfUserMapper;
import com.aifen.model.AfUser;
import com.aifen.model.vo.AfUserVo;
import com.aifen.service.IAfUserService;
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
 * @since 2019-04-07
 */
@Service
public class AfUserServiceImpl extends ServiceImpl<AfUserMapper, AfUser> implements IAfUserService {


    @Override
    public PageInfo<AfUser> list(AfUserVo vo) {
        //如果需要传递对象 xml查询
        Map<String, Object> params = BeanUtil.beanToMap(vo);
        PageHelper.startPage(vo.getPageIndex(), vo.getPageSize());
        List<AfUser> list=baseMapper.selectList(new QueryWrapper<>());
        PageInfo<AfUser> pageLists = new PageInfo<>(list);
        return pageLists;
    }
}
