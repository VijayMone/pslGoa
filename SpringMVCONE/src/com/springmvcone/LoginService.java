package com.springmvcone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginService {
	@Autowired
	LoginDAO l1;
	public boolean check(String login,String password) {
		if(l1.findUser(login, password)){
			return true;
		}
		else
			return false;
	}

}
