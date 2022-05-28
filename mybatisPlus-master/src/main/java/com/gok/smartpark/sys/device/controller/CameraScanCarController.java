package com.gok.smartpark.sys.device.controller;


import com.alibaba.fastjson.JSON;
//import com.gok.smartpark.device.view.CameraResponseView;
import com.gok.smartpark.sys.device.view.CameraResponseView;
import com.gok.smartpark.sys.entity.ParkOrder;
import com.gok.smartpark.sys.mapper.IParkoderMapper;
//import com.gok.smartpark.sys.mapper.IParkoderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ParkAPI")
public class CameraScanCarController {

    @Autowired
    IParkoderMapper parkOrderMapper;

    @ResponseBody
    @RequestMapping("/sendScanCar")
    public Map<Object,Object> sendScanCar(HttpServletRequest request,ParkOrder parkOrder) throws IOException {
        Map map = new HashMap() ;

        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
        String line = null;
        StringBuilder jsonStr = new StringBuilder();
        while ((line = br.readLine()) != null) {
            jsonStr.append(line);
        }
        System.out.println("jsonStr:" + jsonStr);

        String cameraResponse = jsonStr.toString() ;
        System.out.println("=====上行:车牌识别===date:" + new Date());
        System.out.println("cameraResponse:" + cameraResponse);
        CameraResponseView cameraResponseView = JSON.parseObject(cameraResponse , CameraResponseView.class) ;

        System.out.println("cameraResponseView:" + cameraResponseView);

        parkOrder.setInTime(String.valueOf(new Date()));
        parkOrder.setLicense(cameraResponseView.getLicense());


        parkOrderMapper.insert(parkOrder);

//        CameraResponse cameraResponse2 =  new CameraResponse("接收成功",100,0,"");
//        String jsonStrResult = JSON.toJSONString(cameraResponse2)

        System.out.println("添加数据成功!");

        map.put("info","接收成功");
        map.put("resultCode",100);
        map.put("type",0);
        map.put("data","");

        return map;
    }





}
