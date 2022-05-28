package com.gok.smartpark.sys.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 日期： @JsonFormat(pattern="yyyy/MM/dd HH:mm") 写头顶
 */
@Data
@TableName("sys_user")
public class User {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId ;
    private String code ;//编号
    private String password ;//密码
    private String name ;//姓名
    private String mobile ;//手机号
    private String remark ;//备注
}

