package com.capstone.shopforhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.service.IUserService;
import com.capstone.shopforhome.vo.request.LoginForm;

@RestController
@RequestMapping(value="user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping(value="register")
	public String registerUser(@RequestBody UserDTO userDTO) {
		
		return userService.registerUser(userDTO);
		
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody LoginForm login) {
		return userService.loginUser(login);
	}
	
	@GetMapping("/logout")
	public String logoutUser(@RequestParam String email) {
		System.out.println("logout : "+IUserService.map.get(email));
		return userService.logoutUser(email);
	}
	
	@GetMapping("/getusers")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@DeleteMapping("/deleteUser/{email}")
	public void deleteProducts(@PathVariable String email) {
		
		userService.removeUser(email);
	}
	
	
	

}
