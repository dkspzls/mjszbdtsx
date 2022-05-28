package com.gok.smartpark.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.config.Layui;
import com.gok.smartpark.sys.config.PageUtils;
import com.gok.smartpark.sys.entity.BillRule;
import com.gok.smartpark.sys.entity.Vehicle;
import com.gok.smartpark.sys.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequestMapping("/vehicle")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping("/page")
    @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
    @ResponseBody
    public LinkedHashMap<String ,Object> pageData(int page,int limit){
        return vehicleService.select(page,limit);
    }

    /**
     * 条件分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/pageListVehicleCondition")
    @ResponseBody
    public Layui pageListUserCondition(int page, int limit, Vehicle vehicle){
        Page<Vehicle> userPage = vehicleService.pageListverCondition(page, limit, vehicle);
        PageUtils pageUtils = new PageUtils(userPage.getRecords(),(int)userPage.getTotal(),
                (int)userPage.getPages(),
                (int)userPage.getCurrent());
        return Layui.data(pageUtils.getTotalCount(),pageUtils.getList());
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object,Object> insertBill(Vehicle vehicle){
        Map map = new HashMap();
        int i = vehicleService.insertVer(vehicle);
        if (i == 1){
            map.put("code",0);
            map.put("data","添加成功");
            return map;
        }else {
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/load")
    public Map<String ,Object> loadBillById(Integer vehicleId){
        Map map = new HashMap();
        Vehicle vehicle = vehicleService.loadVerById(vehicleId);
        map.put("code" , 0) ;
        map.put("data" , vehicle);
        return map;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String ,Object> updateVerById(Vehicle vehicle){
        Map map = new HashMap();
        int i = vehicleService.updateVerById(vehicle);
        if (i == 1){
            map.put("code" , 0) ;
            map.put("data","更新成功");
            return map;
        }else {
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/delete")
    public Map<String ,Object> deleteId(Integer vehicleId){
        Map map = new HashMap();
        int i = vehicleService.deleteVer(vehicleId);
        if (i == 1){
            map.put("code" , 0) ;
            map.put("data" , "删除成功");
            return map;
        }else {
            return null;
        }

    }
}
