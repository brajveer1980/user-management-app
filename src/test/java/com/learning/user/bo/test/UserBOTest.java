package com.learning.user.bo.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.learning.user.bo.UserBO;
import com.learning.user.bo.UserBOImpl;
import com.learning.user.model.User;

public class UserBOTest {
	
	@Test
	public void testSaveUser() throws Exception{
		User testUser=new User();
		testUser.setUserId("TestUserewr1234");
		testUser.setUserFirstName("Test User 123");
		testUser.setUserLastName("Test User ABC");
		testUser.setUserEmail("Test User ABC");
		UserBO userBO=new UserBOImpl();
		userBO.deleteUserByUserID(testUser);
		User user=userBO.saveUser(testUser);
		assertTrue(user.equals(testUser));
	}
	
	@Test
	public void testSearchUser() throws Exception{
		User testUser=new User();
		testUser.setUserId("Test");
		testUser.setUserFirstName("Test User 123");
		UserBO userBO=new UserBOImpl();
		assertTrue(userBO.searchUser(testUser)!=null);
	}
}
