package com.gok.smartpark.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gok.smartpark.sys.config.Layui;
import com.gok.smartpark.sys.config.PageUtils;
import com.gok.smartpark.sys.entity.User;
import com.gok.smartpark.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 演示 并没有实际接口使用
     *
     * @return
     * @ResponseBody json格式 给前端
     */
    @RequestMapping("/list")
    @ResponseBody
    public Map<User, Object> list() {
        HashMap map = new HashMap();
        map.put("code", 0);
        map.put("data", userService.userList());
        return map;
    }

    //页面list
    @RequestMapping("/page")
    @CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
    @ResponseBody
    public LinkedHashMap<String, Object> pageData(int page, int limit) {

        return userService.select(page, limit);
    }


    /**
     * 条件分页查询
     *
     * @param page
     * @param limit
     * @param user
     * @return
     */
    @RequestMapping("/pageListUserCondition")
    @ResponseBody
    public Layui pageListUserCondition(int page, int limit, User user) {
        Page<User> userPage = userService.pageListUserCondition(page, limit, user);
        PageUtils pageUtils = new PageUtils(userPage.getRecords(), (int) userPage.getTotal(),
                (int) userPage.getPages(),
                (int) userPage.getCurrent());
        return Layui.data(pageUtils.getTotalCount(), pageUtils.getList());
    }

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public Map<Object, Object> deleteByUserId(Integer userId) {
        Map map = new HashMap();
        int i = userService.deleteByUserId(userId);
        if (i == 1) {
            map.put("code", 0);
            map.put("data", "删除成功");
            return map;
        } else {
            return null;
        }

    }

    @ResponseBody
    @RequestMapping("/insert")
    public Map<Object, Object> insertUser(User user) {
        Map map = new HashMap();
        int i = userService.insertUser(user);
        if (i == 1) {
            map.put("code", 0);
            map.put("data", "添加成功");
            return map;
        } else {
            return null;
        }

    }

    /**
     * 编辑显示——通过用户id查询用户信息
     *
     * @param userId
     * @return
     */
    @ResponseBody
    @RequestMapping("/load")
    public Map<String, Object> loadUserById(Integer userId) {
        Map map = new HashMap();
        User user = userService.loadUserById(userId);
        map.put("code", 0);
        map.put("data", user);
        return map;
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public Map<String, Object> updateUserById(User user) {
        Map map = new HashMap();
        int i = userService.updateUserById(user);
        if (i == 1) {
            map.put("code", 0);
            map.put("data", "更新成功");
            return map;
        } else {
            return null;
        }

    }


    @ResponseBody
    @RequestMapping("/login")
    public Map<String,Object> login(User user){
        return userService.login(user);
    }

    @ResponseBody
    @RequestMapping("/reg")
    public Map<String, Object> reg(User user) {
        Map map = new HashMap();
        userService.insertUser(user);
        map.put("code", 0);
        map.put("data","注册成功");
        return map;
    }
}
