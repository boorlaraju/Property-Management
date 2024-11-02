package com.raju.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raju.demo.DTO.UserDTO;
import com.raju.demo.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> register (@RequestBody @Valid UserDTO userDTO)
	{
		userDTO = userService.register(userDTO);
		ResponseEntity<UserDTO> responceEntity = new ResponseEntity<>(userDTO,HttpStatus.CREATED);
		return responceEntity;
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login (@RequestBody @Valid UserDTO userDTO)
	{
		userDTO = userService.login(userDTO.getOwnerEmail(),userDTO.getPassword());
		ResponseEntity<UserDTO> responceEntity = new ResponseEntity<>(userDTO,HttpStatus.OK);
		return responceEntity;
	}
	
	
	
	
}