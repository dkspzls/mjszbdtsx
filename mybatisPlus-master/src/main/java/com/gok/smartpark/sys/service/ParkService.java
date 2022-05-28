package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.entity.Vehicle;
import com.gok.smartpark.sys.mapper.IParkMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ParkService {
    @Autowired
    IParkMapper parkMapper;

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<ParkOrder>queryWrapper=new QueryWrapper<ParkOrder>();
        Page<ParkOrder> pages=new Page<ParkOrder>(page,limit);
        IPage<ParkOrder> iPage=parkMapper.selectPage(pages, queryWrapper);
        List<ParkOrder> list=iPage.getRecords();
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
    public Page<ParkOrder> pageListverCondition(int page, int limit, ParkOrder parkOrder){
        //创建Page对象
        Page<ParkOrder> ParkPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer parkId = parkOrder.getParkOrderId();
        String parkcode= parkOrder.getOrderCode();
        String parkLi = parkOrder.getLicense();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(parkId!=null){
            wrapper.eq("park_order_id",parkId);
        }
        if(!StringUtils.isEmpty(parkcode)){
            wrapper.eq("order_code",parkcode);
        }
        if(!StringUtils.isEmpty(parkLi)){
            wrapper.eq("license",parkLi);
        }
        //调用mybatis plus分页方法进行查询
        parkMapper.selectPage(ParkPage, wrapper);

        return ParkPage;
    }

    public  int insertPark(ParkOrder par){
        return parkMapper.insert(par);
    }

    public int deletepark(Integer parkOrderId){
        return parkMapper.deleteById(parkOrderId);
    }

    public ParkOrder loadparkById(Integer parkOrderId){
        return parkMapper.selectById(parkOrderId);
    }
    public int updateParkById(ParkOrder parkOrder){
        return  parkMapper.updateById(parkOrder);
    }


}
