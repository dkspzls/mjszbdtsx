package com.gok.smartpark.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_payment")
public class PayMent {
    @TableId(value = "payment_id", type = IdType.AUTO)
    private Integer paymentId ;
    private String carNumber ;
    private String payCode ;
    private String parkOrder ;
    private String packageType ;
    private String status ;
    private String payDate;
    private String payType;
    private String remark;

}
