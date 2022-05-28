package com.gok.smartpark.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sys_vehicle")
public class Vehicle {
    @TableId(value = "vehicle_id", type = IdType.AUTO)
    private Integer vehicleId ;
    private String carNumber ;
    private String ownerName ;
    private String ownerMobile ;
    private String ownerAddr ;
    private String plateColor ;
    private String packageType;
    private String dateEffective;
    private String dateClose;
}
