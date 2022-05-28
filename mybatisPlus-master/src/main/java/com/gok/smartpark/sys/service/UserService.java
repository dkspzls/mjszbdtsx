package com.gok.smartpark.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.mapper.IUserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    IUserMapper userMapper;
    //演示
    public List<User> userList(){
        QueryWrapper ew = new QueryWrapper();
        return userMapper.selectList(ew);
    }

    /**
     * 分页查询
     * @param page
     * @param limit
     * @return
     */
    public LinkedHashMap<String,Object> select(int page, int limit){
        QueryWrapper<User>queryWrapper=new QueryWrapper<User>();
        Page<User> pages=new Page<User>(page,limit);
        IPage<User> iPage=userMapper.selectPage(pages, queryWrapper);
        List<User> list=iPage.getRecords();
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
     * @param user
     * @return
     */
    public Page<User> pageListUserCondition(int page, int limit, User user){
        //创建Page对象
        Page<User> userPage = new Page<>(page,limit);
        //构建条件
        QueryWrapper wrapper = new QueryWrapper<>();

        //获取传入User的条件是否为空
        Integer userId = user.getUserId();
        String userCode= user.getCode();
        String userPwd = user.getPassword();

        //多条件组合查询
        //判断条件值是否为空,如果不为空拼接条件
        if(userId!=null){
            wrapper.eq("user_id",userId);
        }
        if(!StringUtils.isEmpty(userCode)){
            wrapper.eq("code",userCode);
        }
        if(!StringUtils.isEmpty(userPwd)){
            wrapper.eq("password",userPwd);
        }
        //调用mybatis plus分页方法进行查询
        userMapper.selectPage(userPage, wrapper);

        return userPage;

    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteByUserId(Integer id){

        return userMapper.deleteById(id);
    }

    /**
     * 添加
     * @param user
     * @return
     */
    public int insertUser(User user){
        return userMapper.insert(user);
    }

    /**
     * 编辑时显示的数据
     * @param id
     * @return
     */
    public User loadUserById(Integer id){

        return userMapper.selectById(id);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUserById(User user){

        return userMapper.updateById(user);
    }


    public Map<String,Object> login(User user){
        Map<String,Object> map = new HashMap<>();
        QueryWrapper selectQuery=new QueryWrapper();
        selectQuery.eq("name",user.getName());
        User user1 = userMapper.selectOne(selectQuery);
        if (! user1.getPassword().equals(user.getPassword())){
            map.put("code",1);
            return map;
        }
        map.put("code",0);
        return map;
    }

    public int reg(User user){
        return userMapper.insert(user);
    }
}
