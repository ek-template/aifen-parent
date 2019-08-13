package com.aifen.service.impl;

import com.aifen.dao.AfNewsMapper;
import com.aifen.model.AfNews;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: ylshi@ronglian.com
 * @Date: 2019/6/2 16:21
 * @Description: 活动、新闻
 */
@Service
public class IAfNewsServiceImpl extends ServiceImpl<AfNewsMapper,AfNews> implements com.aifen.service.IAfNewsService {
}


