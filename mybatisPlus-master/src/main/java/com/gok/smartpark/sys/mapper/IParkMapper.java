package com.gok.smartpark.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gok.smartpark.sys.entity.ParkOrder;
import org.springframework.stereotype.Component;

@Component
public interface IParkMapper extends BaseMapper<ParkOrder> {
}
