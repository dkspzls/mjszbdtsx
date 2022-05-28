package com.gok.smartpark.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.config.Layui;
import com.gok.smartpark.sys.config.PageUtils;
import com.gok.smartpark.sys.entity.BillRule;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequestMapping("/billRule")
public class BillController {
    @Autowired
    BillService billService;

    @RequestMapping("/page")
    @CrossOrigin(allowedHeaders = "*",allowCredentials = "true")
    @ResponseBody
    public LinkedHashMap<String,Object> pageData(int page, int limit){
        return billService.select(page,limit);
    }

    /**
     * 条件分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/pageListBillRuleCondition")
    @ResponseBody
    public Layui pageListUserCondition(int page, int limit, BillRule billRule){
        Page<BillRule> userPage = billService.pageListUserCondition(page, limit, billRule);
        PageUtils pageUtils = new PageUtils(userPage.getRecords(),(int)userPage.getTotal(),
                (int)userPage.getPages(),
                (int)userPage.getCurrent());
        return Layui.data(pageUtils.getTotalCount(),pageUtils.getList());
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object,Object> insertBill(BillRule billRule){
        Map map = new HashMap();
        int i = billService.insertBill(billRule);
        if (i==1){
            map.put("code",0);
            map.put("data","添加成功");
            return map;
        }else{
            map.put("code",1);
            return map;
        }

    }

    @ResponseBody
    @RequestMapping("/load")
    public Map<String ,Object> loadBillById(Integer billRuleId){
        Map map = new HashMap();
        BillRule billRule = billService.loadBillById(billRuleId);
        map.put("code" , 0) ;
        map.put("data" , billRule);
        return map;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String ,Object> updateBillById(BillRule billRule){
        Map map = new HashMap();
        int i = billService.updateBillById(billRule);
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
    public Map<String ,Object> deleteId(Integer billRuleId){
        Map map = new HashMap();
        int i = billService.deleteBillId(billRuleId);
        if (i==1){
            map.put("code" , 0) ;
            map.put("data" , "删除成功");
            return map;
        }else{
            return null;
        }

    }

}
