package com.raju.demo.service;

import java.util.List;

import com.raju.demo.DTO.PropertyDTO;

public interface PropertyService {
	
	public PropertyDTO saveProperty(PropertyDTO propertyDTO );
	public List<PropertyDTO> getAllProperties();
	public PropertyDTO updateProperty(PropertyDTO propertyDTO,Long Id);
	public PropertyDTO updateDescription( PropertyDTO propertyDTO,Long Id);
	public PropertyDTO updatePrice( PropertyDTO propertyDTO,Long Id);
	public void deleteProperty(Long PropertyId);
	

}
