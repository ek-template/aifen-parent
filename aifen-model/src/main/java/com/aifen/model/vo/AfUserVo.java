package com.aifen.model.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统用户表
 * </p>
 *
 * @author qierkang xyqierkang@163.com
 * @since 2019-04-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AfUserVo extends BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 登陆用户名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String userPwd;

    /**
     * 用户状态0 - 禁用 1 - 启用
     */
    private String userStatus;

    /**
     * 用户联系方式
     */
    private String userPhone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 0 - 管理员
1 - 运营人员
     */
    private String userDept;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
