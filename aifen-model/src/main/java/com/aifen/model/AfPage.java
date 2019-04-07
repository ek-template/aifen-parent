package com.aifen.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AfPage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 文章标题
     */
    private String pageTitle;

    /**
     * 状态0 - 禁用1 - 启用
     */
    private String pageStatus;

    /**
     * 文章状态：1新闻；2页面
     */
    private String pageType;

    /**
     * 页面内容
     */
    private String pageContent;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
