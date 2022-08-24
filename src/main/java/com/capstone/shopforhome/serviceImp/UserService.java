package com.capstone.shopforhome.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.shopforhome.dto.UserDTO;
import com.capstone.shopforhome.entity.User;
import com.capstone.shopforhome.repository.UserRepository;
import com.capstone.shopforhome.service.IUserService;
import com.capstone.shopforhome.vo.request.LoginForm;



public class UserService implements IUserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public String registerUser(UserDTO userDTO) {
		if(userRepository.existsById(userDTO.getEmail())) {
			return "User already exists";
		}
		else {
			//converting UserDTO to User(Entity)
			User u = new User();
			u.setName(userDTO.getName());
			u.setEmail(userDTO.getEmail());
			u.setAddress(userDTO.getAddress());
			u.setPassword(userDTO.getPassword());
			u.setContactNumber(userDTO.getContactNumber());
			u.setRole(userDTO.getRole());
			
			userRepository.save(u);
			return "Registered Successfully";
		}
	}

	@Override
	public String loginUser(LoginForm login) {
		String email = login.getEmail();
		if(userRepository.existsById(login.getEmail())) {
			User cu = userRepository.getReferenceById(login.getEmail());
			if(cu.getPassword().equals(login.getPassword())) {
				if(map.get(email)==null) {
					map.put(email, userRepository.getReferenceById(email));
					System.out.println("map : "+map);
					System.out.println(userRepository.getReferenceById(email));
				}
					
				
				return "Logged In Successfully";
			}
			else {
				return "Invalid Password";
			}
		}
		else {
			return "Invalid Email";
		}
		
		
	}
	@Override
	public String logoutUser(String email) {

		if (map.get(email) != null) {
			map.remove(email);
			System.out.println("map : "+map);
			return "Logout Success";
		} else {
			return "Please Login First";
		}

	}
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public User update(User user) {
		String email = user.getEmail();
		User oldUser = userRepository.getReferenceById(email);
		oldUser.setName(user.getName());
		oldUser.setEmail(user.getEmail());
		oldUser.setAddress(user.getAddress());
		oldUser.setPassword(user.getPassword());
		oldUser.setRole(user.getRole());
		oldUser.setContactNumber(user.getContactNumber());
		return userRepository.save(oldUser);
	}

	@Override
	public void removeUser(String email) {
		User user =userRepository.getReferenceById(email);
		if (user == null)
			userRepository.delete(user);
		
	}
	

}
