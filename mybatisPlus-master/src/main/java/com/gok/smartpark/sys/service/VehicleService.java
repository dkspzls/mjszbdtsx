package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.BillRule;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.entity.Vehicle;
import com.gok.smartpark.sys.mapper.IVehicelMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class VehicleService {
    @Autowired
    IVehicelMapper iVehicelMapper;


    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<Vehicle> queryWrapper=new QueryWrapper<Vehicle>();
        Page<Vehicle> pages=new Page<Vehicle>(page,limit);
        IPage<Vehicle> iPage=iVehicelMapper.selectPage(pages, queryWrapper);
        List<Vehicle> list=iPage.getRecords();
        long count=iPage.getTotal();
        LinkedHashMap<String, Object>linkedHashMap=new LinkedHashMap<String, Object>();
        linkedHashMap.put("code", 0);
        linkedHashMap.put("msg", "");
        linkedHashMap.put("count", count);
        linkedHashMap.put("data", list);
        return linkedHashMap;
    }

    /**
     * 分页条件查询
     * @param page
     * @param limit
     * @return
     */
    public Page<Vehicle> pageListverCondition(int page, int limit, Vehicle vehicle){
        //创建Page对象
        Page<Vehicle> VerPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer VerId = vehicle.getVehicleId();
        String VerCar= vehicle.getCarNumber();
        String VerOwner = vehicle.getOwnerName();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(VerId!=null){
            wrapper.eq("vehicle_id",VerId);
        }
        if(!StringUtils.isEmpty(VerCar)){
            wrapper.eq("car_number",VerCar);
        }
        if(!StringUtils.isEmpty(VerOwner)){
            wrapper.eq("owner_name",VerOwner);
        }
        //调用mybatis plus分页方法进行查询
        iVehicelMapper.selectPage(VerPage, wrapper);

        return VerPage;
    }

    public  int insertVer(Vehicle Ver){
        return iVehicelMapper.insert(Ver);
    }

    public int deleteVer(Integer vehicleId){
        return iVehicelMapper.deleteById(vehicleId);
    }

    public Vehicle loadVerById(Integer vehicleId){
        return iVehicelMapper.selectById(vehicleId);
    }
    public int updateVerById(Vehicle vehicle){
        return  iVehicelMapper.updateById(vehicle);
    }
}
