package com.gok.smartpark.sys.config;

import java.util.HashMap;
import java.util.List;

public class Layui extends HashMap<String, Object>{
	//分页
	public static Layui data(Integer count,List<?> data){
		  Layui r = new Layui();
		  r.put("code", 0);
		  r.put("msg", "");
		  r.put("count", count);
		  r.put("data", data);
		  return r;
		 }
	//更新
	public static Layui updateLayui(int updateNum){
		  Layui r = new Layui();
		  if(updateNum<0) {
			  r.put("code", 1);
		  }
		  r.put("code", 0);
		  return r;
		 }

	public static Layui getObject(Object object) {
		Layui layui = new Layui();
		if(null==object) {
			layui.put("code", 1);
		}else {
			layui.put("code", 0);
			layui.put("data", object);
		}
		return layui;
	}

	public static Layui check(Boolean flag) {
		Layui layui = new Layui();
		if(!flag) {
			layui.put("code", 1);
			layui.put("msg", "手机格式不对,请输入正确的格式手机");
		}
		return layui;
	}

}
