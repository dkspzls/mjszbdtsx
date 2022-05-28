package com.gok.smartpark.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_park_order")
public class ParkOrder {
    @TableId(value = "park_order_id", type = IdType.AUTO)
    private Integer parkOrderId ;
    private String orderCode ;//编号
    private String license ;//车牌号
    private String packageType ;//期限
    private String inTime ;//开始时间
    private String  outTime ;//结束时间
    private Integer money;//金额
    private String status;//状态
}
