package com.gok.smartpark.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.config.Layui;
import com.gok.smartpark.sys.config.PageUtils;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.entity.Vehicle;
import com.gok.smartpark.sys.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequestMapping("/parkOrder")
public class ParkController {
    @Autowired
    ParkService parkService;

    @RequestMapping("/page")
    @CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
    @ResponseBody
    public LinkedHashMap<String,Object> pageData(int page,int limit){
        return parkService.select(page,limit);

    }

    /**
     * 条件分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/pageListVehicleCondition")
    @ResponseBody
    public Layui pageListUserCondition(int page, int limit, ParkOrder parkOrder){
        Page<ParkOrder> parkPage = parkService.pageListverCondition(page, limit, parkOrder);
        PageUtils pageUtils = new PageUtils(parkPage.getRecords(),(int)parkPage.getTotal(),
                (int)parkPage.getPages(),
                (int)parkPage.getCurrent());
        return Layui.data(pageUtils.getTotalCount(),pageUtils.getList());
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object,Object> insertBill(ParkOrder parkOrder){
        Map map = new HashMap();
        int i = parkService.insertPark(parkOrder);
        if (i==1){
            map.put("code",0);
            map.put("data","添加成功");
            return map;
        }else{
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/load")
    public Map<String ,Object> loadBillById(Integer parkOrderId){
        Map map = new HashMap();
        ParkOrder parkOrder = parkService.loadparkById(parkOrderId);
        map.put("code" , 0) ;
        map.put("data" , parkOrder);
        return map;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String ,Object> updateVerById(ParkOrder parkOrder){
        Map map = new HashMap();
        int i = parkService.updateParkById(parkOrder);
        if (i==1){
            map.put("code" , 0) ;
            map.put("data","更新成功");
            return map;
        }else{
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/delete")
    public Map<String ,Object> deleteId(Integer parkOrderId){
        Map map = new HashMap();
        int i = parkService.deletepark(parkOrderId);
        if (i==1){
            map.put("code" , 0) ;
            map.put("data" , "删除成功");
            return map;
        }else{
            return null;
        }

    }

}
