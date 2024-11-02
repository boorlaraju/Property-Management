package com.raju.demo.converter;

import org.springframework.stereotype.Component;

import com.raju.demo.DTO.UserDTO;
import com.raju.demo.Entity.UserEntity;

@Component
public class UserConverter {
	
	public UserEntity convertDTOtoEntity(UserDTO userDTO)
	{
		UserEntity userEntity = new UserEntity();
		userEntity.setOwnerEmail(userDTO.getOwnerEmail());
		userEntity.setOwnerName(userDTO.getOwnerName());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setPhone(userDTO.getPhone());
		
		return userEntity;
		
		
		
	}
	
	public UserDTO convertEntitytoDTO(UserEntity userEntity )
	{
		UserDTO userDTO = new UserDTO();
		userDTO.setOwnerEmail(userEntity.getOwnerEmail());
		userDTO.setOwnerName(userEntity.getOwnerName());
		
		userDTO.setPhone(userEntity.getPhone());
		userDTO.setId(userEntity.getId());
		
		return userDTO;
		
		
		
	}

}
