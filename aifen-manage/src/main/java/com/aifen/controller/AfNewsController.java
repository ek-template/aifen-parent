package com.aifen.controller;

import com.aifen.aspect.LogUtil;
import com.aifen.enumerator.ConstantInterface;
import com.aifen.model.AfNews;
import com.aifen.response.BaseResponse;
import com.aifen.service.IAfNewsService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ylshi@ronglian.com
 * @Date: 2019/6/2 16:23
 * @Description:
 */
@RestController
@RequestMapping(value = {"/news"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
@Slf4j
public class AfNewsController {

    @Autowired
    private IAfNewsService newsService;

    /**
     * 新增 或者修改
     * @param news 包含ID 则修改
     * @return
     */
    @PostMapping("save")
    public BaseResponse save(@RequestBody AfNews news){
        boolean save = newsService.saveOrUpdate(news);
        if(save == true){
            return BaseResponse.success();
        }
        return BaseResponse.error("新增失败");
    }

    @GetMapping("page/{pageIndex}")
    public BaseResponse page(@PathVariable("pageIndex") Integer pageIndex){

        Page<AfNews> page = new Page<>(pageIndex, ConstantInterface.Enum.PageConfig.PAGE_SIZE.getPageSize());
        IPage<AfNews> content = newsService.page(page);

        return BaseResponse.success(content);
    }

    @DeleteMapping("delete")
    public BaseResponse delete(Integer id){
        boolean remove = newsService.removeById(id);
        return BaseResponse.success(remove);
    }


}
