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
 * @since 2019-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysMgrUserVo extends BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    /**
     * 用户姓名
     */
    private String userRealname;

    /**
     * 登陆用户名
     */
    private String userLoginname;

    /**
     * 登陆密码
     */
    private String userPassword;

    /**
     * 用户状态0 - 禁用
1 - 启用
     */
    private String userStatus;

    /**
     * 用户工号
     */
    private String userEmpno;

    /**
     * 用户联系方式
     */
    private String userCellphone;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 0 - 总裁办
1 - 技术部
2 - 运营部
3 - 财务部
4 - 市场部
5 - 行政部
6 - 人事部
     */
    private String userDept;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 修改人
     */
    private Long updateUser;


}
