package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.mapper.IParkoderMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ParkorderService {

    @Autowired
    IParkoderMapper parkoderMapper;

    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<ParkOrder>queryWrapper=new QueryWrapper<ParkOrder>();
        Page<ParkOrder> pages=new Page<ParkOrder>(page,limit);
        IPage<ParkOrder> iPage=parkoderMapper.selectPage(pages, queryWrapper);
        List<ParkOrder> list=iPage.getRecords();
        long count=iPage.getTotal();
        LinkedHashMap<String, Object>linkedHashMap=new LinkedHashMap<String, Object>();
        linkedHashMap.put("code", 0);
        linkedHashMap.put("msg", "");
        linkedHashMap.put("count", count);
        linkedHashMap.put("data", list);
        return linkedHashMap;
    }

    public Page<ParkOrder> pageListUserCondition(int page, int limit, ParkOrder parkOrder) {
        //创建Page对象
        Page<ParkOrder> userPage = new Page<>(page, limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer parkOrderId = parkOrder.getParkOrderId();
        String parkOrderrCode = parkOrder.getOrderCode();
        String parkOrderlicense = parkOrder.getLicense();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if (parkOrderId != null) {
            wrapper.eq("park_order_id", parkOrderId);
        }
        if (!StringUtils.isEmpty(parkOrderrCode)) {
            wrapper.eq("order_code", parkOrderrCode);
        }
        if (!StringUtils.isEmpty(parkOrderlicense)) {
            wrapper.eq("license", parkOrderlicense);
        }
        //调用mybatis plus分页方法进行查询
        parkoderMapper.selectPage(userPage, wrapper);

        return userPage;
    }

    /**
     * 删除
     * @param
     * @return
     */
    public int deleteByUserId(Integer parkOrderId){

        return parkoderMapper.deleteById(parkOrderId);
    }

    /**
     * 添加
     * @param parkOrder
     * @return
     */
    public int insertUser(ParkOrder parkOrder){
        return parkoderMapper.insert(parkOrder);
    }

    /**
     * 编辑时显示的数据
     * @param parkOrderId
     * @return
     */
    public ParkOrder loadUserById(Integer parkOrderId){

        return parkoderMapper.selectById(parkOrderId);
    }

    /**
     * 更新用户信息
     * @param parkOrder
     * @return
     */
    public int updateUserById(ParkOrder parkOrder){

        return parkoderMapper.updateById(parkOrder);
    }


}
