package com.iinur.cat.model;

import com.iinur.cat.data.UserinfoDao;
import com.iinur.cat.data.bean.Userinfo;

public class UserinfoModel {

	public boolean registration(String name){
		boolean flag = false;
		UserinfoDao udao = new UserinfoDao();
		Userinfo u = udao.get(name);
		if(u == null){
			udao.insert(name);
			flag = true;
		}
		return flag;
	}
}
