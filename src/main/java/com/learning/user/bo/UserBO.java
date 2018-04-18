package com.learning.user.bo;

import java.util.List;

import com.learning.user.model.User;

public interface UserBO {
public User saveUser(User user) throws Exception;
public List<User> searchUser(User user) throws Exception;
public boolean deleteUserByUserID(User user) throws Exception;
}
