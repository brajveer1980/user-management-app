package com.learning.user.dao;

import java.util.List;

import com.learning.user.model.User;

public interface UserDAO {
public boolean createUser(User user);
public User updateUser(User user);
public List<User> searchUser(User user);
public boolean deleteUserbyUserId(User user);
public boolean deleteUserbyId(User user);
}
