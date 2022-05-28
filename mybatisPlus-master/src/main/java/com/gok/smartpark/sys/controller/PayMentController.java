package com.gok.smartpark.sys.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.config.Layui;
import com.gok.smartpark.sys.config.PageUtils;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.entity.PayMent;
import com.gok.smartpark.sys.service.PayMentService;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Component
@RequestMapping("/payment")
public class PayMentController {
    @Autowired
    PayMentService payMentService;

    @RequestMapping("/page")
    @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
    @ResponseBody
    public LinkedHashMap<String,Object> pageData(int page,int limit){
        return payMentService.select(page,limit);
    }


    /**
     * 条件分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/pageListVehicleCondition")
    @ResponseBody
    public Layui pageListPayCondition(int page, int limit, PayMent payMent){
        Page<PayMent> payPage = payMentService.pageListPayCondition(page, limit, payMent);
        PageUtils pageUtils = new PageUtils(payPage.getRecords(),(int)payPage.getTotal(),
                (int)payPage.getPages(),
                (int)payPage.getCurrent());
        return Layui.data(pageUtils.getTotalCount(),pageUtils.getList());
    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object,Object> insertPay(PayMent payMent){
        Map map = new HashMap();
        int i = payMentService.insertPay(payMent);
        if (i == 1){
            map.put("code",0);
            map.put("data","添加成功");
            return map;
        }else{
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/load")
    public Map<String ,Object> loadBillById(Integer paymentId){
        Map map = new HashMap();
        PayMent payMent = payMentService.loadPayById(paymentId);
        map.put("code" , 0) ;
        map.put("data" , payMent);
        return map;
    }

    @ResponseBody
    @RequestMapping("/update")
    public Map<String ,Object> updateVerById(PayMent payMent){
        Map map = new HashMap();
        int i = payMentService.updatePayById(payMent);
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
    public Map<String ,Object> deleteId(Integer paymentId){
        Map map = new HashMap();
        int i = payMentService.deletePay(paymentId);
        if (i ==1 ){
            map.put("code" , 0) ;
            map.put("data" , "删除成功");
            return map;
        }else {
            return null;
        }

    }
}
