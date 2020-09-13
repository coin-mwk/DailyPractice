package fitz.dao;

import fitz.pojo.User;

public interface UserDao {
	
	User selectUserById(int id);
	
	int deleteById(int id);
	
	int addUser(User user);
	
	int updateUser(User user);

}
