package com.aifen.model.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BaseVO {

    private Integer pageIndex = 1;

    private Integer pageSize = 10;

    private String beginDate;

    private String endDate;

    private String token;

}
