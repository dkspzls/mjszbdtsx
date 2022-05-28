package com.gok.smartpark.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_bill_rule")
public class BillRule {

    @TableId(value = "bill_rule_id", type = IdType.AUTO)
    private Integer billRuleId ;
    private String yearMoney ;
    private String monthMoney ;
    private String firstMoney ;
    private String periodMoney ;
}

