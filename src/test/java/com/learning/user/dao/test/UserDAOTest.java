package com.learning.user.dao.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.learning.user.dao.UserDAO;
import com.learning.user.dao.UserDAOImpl;
import com.learning.user.model.User;

public class UserDAOTest {
	
	@Test
	public void testCreateUser(){
		User testUser=new User();
		testUser.setUserId("TestUser1234343fd65");
		testUser.setUserFirstName("Test User 123");
		testUser.setUserLastName("Test User ABC");
		testUser.setUserEmail("Test User ABC");
		UserDAO userDAO=new UserDAOImpl();
		userDAO.deleteUserbyUserId(testUser);
		assertTrue(userDAO.createUser(testUser));
	}
	@Test
	public void testSearchUser(){
		User testUser=new User();
		testUser.setUserId("TestUser");
		testUser.setUserFirstName("Test");
		UserDAO userDAO=new UserDAOImpl();
		assertTrue(userDAO.searchUser(testUser)!=null);
	}
}
