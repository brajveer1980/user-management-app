package com.learning.user.bo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.learning.user.dao.UserDAO;
import com.learning.user.dao.UserDAOImpl;
import com.learning.user.model.User;

public class UserBOImpl implements UserBO{

	@Override
	public User saveUser(User user) throws Exception {
		UserDAO userDAO=new UserDAOImpl();
		if(userDAO.createUser(user)){
			return user;	
		}else {
			throw new Exception("Error Creating User");
		}
			
	}

	@Override
	public boolean deleteUserByUserID(User user) throws Exception {
		UserDAO userDAO=new UserDAOImpl();
		return userDAO.deleteUserbyUserId(user);
	}
	@Override
	public List<User> searchUser(User user) throws Exception {
		UserDAO userDAO=new UserDAOImpl();
		if(StringUtils.isNotEmpty(user.getUserId()) || StringUtils.isNotEmpty(user.getUserFirstName()) ||  StringUtils.isNotEmpty(user.getUserLastName())
				||  StringUtils.isNotEmpty(user.getUserEmail()) ||  StringUtils.isNotEmpty(user.getUserPassword())){
			return userDAO.searchUser(user);
		}else{
			return null;
		}
		
	
			
	}


}
