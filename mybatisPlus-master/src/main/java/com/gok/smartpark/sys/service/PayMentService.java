package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.entity.PayMent;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.mapper.IPayMentMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PayMentService {
    @Autowired
    IPayMentMapper iPayMentMapper;


    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<PayMent> queryWrapper=new QueryWrapper<PayMent>();
        Page<PayMent> pages=new Page<PayMent>(page,limit);
        IPage<PayMent> iPage=iPayMentMapper.selectPage(pages, queryWrapper);
        List<PayMent> list=iPage.getRecords();
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
    public Page<PayMent> pageListPayCondition(int page, int limit, PayMent payMent){
        //创建Page对象
        Page<PayMent> PayPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer payId = payMent.getPaymentId();
        String payCar= payMent.getCarNumber();
        String payCode = payMent.getPayCode();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(payId!=null){
            wrapper.eq("payment_id",payId);
        }
        if(!StringUtils.isEmpty(payCar)){
            wrapper.eq("car_number",payCar);
        }
        if(!StringUtils.isEmpty(payCode)){
            wrapper.eq("pay_code",payCode);
        }
        //调用mybatis plus分页方法进行查询
        iPayMentMapper.selectPage(PayPage, wrapper);

        return PayPage;
    }

    public  int insertPay(PayMent payMent){
        return iPayMentMapper.insert(payMent);
    }

    public int deletePay(Integer paymentId){
        return iPayMentMapper.deleteById(paymentId);
    }

    public PayMent loadPayById(Integer paymentId){
        return iPayMentMapper.selectById(paymentId);
    }
    public int updatePayById(PayMent payMent){
        return  iPayMentMapper.updateById(payMent);
    }

}
