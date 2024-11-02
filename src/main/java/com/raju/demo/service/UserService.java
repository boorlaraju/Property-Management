package com.raju.demo.service;

import com.raju.demo.DTO.UserDTO;

public interface UserService {
	
	UserDTO register (UserDTO userDTO);
	UserDTO login ( String email,String password);
	
	

}
