package com.raju.demo.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raju.demo.DTO.PropertyDTO;
import com.raju.demo.Entity.PropertyEntity;

@Component
public class PropertyConverter {
	
	
	
	public PropertyEntity ConvertDTOtoEntity(PropertyDTO  propertyDTO )
	{
		PropertyEntity pe= new PropertyEntity();
		pe.setTitle(propertyDTO.getTitle());
		pe.setDescription(propertyDTO.getDescription());
		pe.setAddress(propertyDTO.getAddress());
		
		pe.setPrice(propertyDTO.getPrice());
		
		
		return pe;
		
		
	}
	
	public PropertyDTO ConvertEntityToDTO(PropertyEntity propertyEntity)
	{
		PropertyDTO pe = new PropertyDTO();
		pe.setTitle(propertyEntity.getTitle());
		pe.setDescription(propertyEntity.getDescription());
		pe.setAddress(propertyEntity.getAddress());
		
		pe.setPrice(propertyEntity.getPrice());
		
		return pe;
	}

}
