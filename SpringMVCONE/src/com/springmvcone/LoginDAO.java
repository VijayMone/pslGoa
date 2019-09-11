package com.springmvcone;

import org.springframework.stereotype.Repository;


public interface LoginDAO {
	
	boolean findUser(String login,String password);

}
