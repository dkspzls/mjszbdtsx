package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.BillRule;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.mapper.IBillRuleMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BillRuleService {

    @Autowired
    IBillRuleMapper billRuleMapper;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<BillRule>queryWrapper=new QueryWrapper<BillRule>();
        Page<BillRule> pages=new Page<BillRule>(page,limit);
        IPage<BillRule> iPage=billRuleMapper.selectPage(pages, queryWrapper);
        List<BillRule> list=iPage.getRecords();
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
     * @param billRule
     * @return
     */
    public Page<BillRule> pageListUserCondition(int page, int limit, BillRule billRule){
        Page<BillRule> userPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer billRuleId = billRule.getBillRuleId();
        String yearMoney= billRule.getYearMoney();
        String monthMoney = billRule.getMonthMoney();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(billRuleId!=null){
            wrapper.eq("bill_rule_id",billRuleId);
        }
        if(!StringUtils.isEmpty(yearMoney)){
            wrapper.eq("year_money",yearMoney);
        }
        if(!StringUtils.isEmpty(monthMoney)){
            wrapper.eq("month_money",monthMoney);
        }
        //调用mybatis plus分页方法进行查询
        billRuleMapper.selectPage(userPage, wrapper);

        return userPage;

    }


    /**
     * 删除
     * @param
     * @return
     */
    public int deleteByUserId(Integer billRuleId){

        return billRuleMapper.deleteById(billRuleId);
    }

    /**
     * 添加
     * @param billRule
     * @return
     */
    public int insertUser(BillRule billRule){
        return billRuleMapper.insert(billRule);
    }

    /**
     * 编辑时显示的数据
     * @param billRuleId
     * @return
     */
    public BillRule loadUserById(Integer billRuleId){

        return billRuleMapper.selectById(billRuleId);
    }

    /**
     * 更新用户信息
     * @param billRule
     * @return
     */
    public int updateUserById(BillRule billRule){

        return billRuleMapper.updateById(billRule);
    }


}
