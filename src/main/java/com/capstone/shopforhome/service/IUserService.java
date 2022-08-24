package com.capstone.shopforhome.service;

import java.util.HashMap;
import java.util.List;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.vo.request.LoginForm;

public interface IUserService {
public static HashMap<String, User> map = new HashMap<>();
	
	public String registerUser(UserDTO userDTO);
	public String loginUser(LoginForm login);
	public String logoutUser(String email);
	void removeUser(String email);
	User update(User user);
	List<User> getAllUsers();
}
