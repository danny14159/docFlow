
package com.work.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.work.bean.User;
import com.work.mapper.BasicDao;
import com.work.mapper.UserDao;
import com.work.security.Coder;

@Controller
@RequestMapping("/user")
public class UserController extends BasicController<User>{
	
	@Resource
	private UserDao UserDao;
	
	public static final String PREFIX="user/";

	@Override
	protected String getPrefix() {
		return PREFIX;
	}

	@Override
	protected BasicDao<User> getDao() {
		return UserDao;
	}

	@Override
	public Object insert(User obj) {
		try {
			Map<String, Object> key = Coder.initKey();
			obj.setPrivateKey(Coder.getPrivateKey(key));
			obj.setPublicKey(Coder.getPublicKey(key));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.insert(obj);
	}

}
    