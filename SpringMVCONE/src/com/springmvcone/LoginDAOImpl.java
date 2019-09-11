package com.springmvcone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	
	@Autowired
	JdbcTemplate template ;

	@Override
	public boolean findUser(String login, String password) {
		// TODO Auto-generated method stub
		System.out.println("in");
		String Query = "select  * from users where name = ?";
		
		Object[] param = {login};
		
		List<User> users = template.query(Query,param, new BeanPropertyRowMapper<User>(User.class) );
		
		System.out.println();
		boolean exists = false;
		if(!users.isEmpty()) {
			
			for(User user: users) {
				if(user.getPassword().equals(password)) {
					exists = true;
				}
			}
		}
		
		if(exists) {
			return true;
		}
		else
		{
			return false;
		}
		
		
		
		
	}

}
