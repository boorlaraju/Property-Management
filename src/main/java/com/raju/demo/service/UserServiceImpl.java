package com.raju.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raju.demo.DTO.UserDTO;
import com.raju.demo.Entity.UserEntity;
import com.raju.demo.converter.UserConverter;
import com.raju.demo.exception.BusinessException;
import com.raju.demo.exception.ErrorModel;
import com.raju.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UserConverter userConverter;
	
	@Override
	public UserDTO register (UserDTO userDTO)
	{
		Optional<UserEntity> optUser=userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
		
		if(optUser.isPresent())
		{
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("EMAIL_ALREDY_EXISTS");
			errorModel.setMessage("the Email with which you are trying to register alredy exists");
			errorModelList.add(errorModel);
			
			throw new BusinessException(errorModelList);
		}
		
		UserEntity userEntity =  userConverter.convertDTOtoEntity(userDTO);
		userEntity = userRepository.save(userEntity);
		userDTO = userConverter.convertEntitytoDTO(userEntity);
		return userDTO;
		
	}
	
	@Override
	public UserDTO login(String email,String password)
	{
		UserDTO userDTO = null;
		Optional<UserEntity> optionalUserEntity= userRepository.findByOwnerEmailAndPassword(email, password);
		if(optionalUserEntity.isPresent())
		{
			userDTO=userConverter.convertEntitytoDTO(optionalUserEntity.get());
		}else
		{
			List<ErrorModel> errorModelList = new ArrayList<>();
			ErrorModel errorModel = new ErrorModel();
			errorModel.setCode("INVALID LOGIN");
			errorModel.setMessage("Incorrect Email or Password");
			errorModelList.add(errorModel);
			
			throw new BusinessException(errorModelList);
			
			
		}
		return userDTO;
	}

}
