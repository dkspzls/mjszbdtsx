package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.BillRule;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.mapper.IBillMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class BillService {
    @Autowired
    IBillMapper iBillMapper;

    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<BillRule> queryWrapper=new QueryWrapper<BillRule>();
        Page<BillRule> pages=new Page<BillRule>(page,limit);
        IPage<BillRule> iPage=iBillMapper.selectPage(pages,queryWrapper);
        List<BillRule> list=iPage.getRecords();
        long count=iPage.getTotal();
        LinkedHashMap<String, Object>linkedHashMap=new LinkedHashMap<String,Object>();
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
    public Page<BillRule> pageListUserCondition(int page, int limit, BillRule billRule){
        //创建Page对象
        Page<BillRule> billPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer BillId = billRule.getBillRuleId();
        String BillYear= billRule.getYearMoney();
        String BillMonth = billRule.getMonthMoney();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(BillId!=null){
            wrapper.eq("bill_rule_id",BillId);
        }
        if(!StringUtils.isEmpty(BillYear)){
            wrapper.eq("year_money",BillYear);
        }
        if(!StringUtils.isEmpty(BillMonth)){
            wrapper.eq("month_money",BillMonth);
        }
        //调用mybatis plus分页方法进行查询
        iBillMapper.selectPage(billPage, wrapper);

        return billPage;
    }

    public  int insertBill(BillRule billRule){
        return iBillMapper.insert(billRule);
    }

    public int deleteBillId(Integer billRuleId){
        return iBillMapper.deleteById(billRuleId);
    }

    public BillRule loadBillById(Integer billRuleId){
        return iBillMapper.selectById(billRuleId);
    }

    public int updateBillById(BillRule billRule){
        return  iBillMapper.updateById(billRule);
    }


}
