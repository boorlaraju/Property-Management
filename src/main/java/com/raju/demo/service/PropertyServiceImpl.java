package com.raju.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raju.demo.DTO.PropertyDTO;
import com.raju.demo.Entity.PropertyEntity;
import com.raju.demo.converter.PropertyConverter;
import com.raju.demo.repository.PropertyRepository;


@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	PropertyRepository propertyRepository ;
	
	
	
	@Autowired
	private PropertyConverter  propertyConverter;
	
	@Override
	public PropertyDTO saveProperty( PropertyDTO propertyDTO )
	{
		PropertyEntity pe = propertyConverter.ConvertDTOtoEntity(propertyDTO);
		pe = propertyRepository.save(pe);
		propertyDTO= propertyConverter.ConvertEntityToDTO(pe);
		return propertyDTO;
	}
	
	@Override
	public List<PropertyDTO> getAllProperties()
	{
		List<PropertyEntity> listofprops=propertyRepository.findAll();
		List<PropertyDTO> list= new ArrayList<>();
		for(PropertyEntity pe : listofprops)
		{
			PropertyDTO dto = propertyConverter.ConvertEntityToDTO(pe);
			list.add(dto);
		}
		return list;
	}
	
	@Override
	public PropertyDTO updateProperty(PropertyDTO propertyDTO ,Long Id)
	{
		Optional<PropertyEntity> optEn=  propertyRepository.findById(Id);
		
		PropertyDTO dto=null;
		if(optEn.isPresent())
		{
			PropertyEntity pe= optEn.get();
			pe.setTitle(propertyDTO.getTitle());
			pe.setDescription(propertyDTO.getDescription());
			pe.setAddress(propertyDTO.getAddress());
			
			pe.setPrice(propertyDTO.getPrice());
			
			dto=propertyConverter.ConvertEntityToDTO(pe);
			propertyRepository.save(pe);
		}
		
		return dto;
		
	}
	@Override
	public PropertyDTO updateDescription( PropertyDTO propertyDTO,Long Id)
	{
		Optional<PropertyEntity>optEn = propertyRepository.findById(Id);
		PropertyDTO dto=null;
		if(optEn.isPresent())
		{
			PropertyEntity pe=optEn.get();
			pe.setDescription(propertyDTO.getDescription());
			dto=propertyConverter.ConvertEntityToDTO(pe);
			propertyRepository.save(pe);
			
		}
		return dto;
	}
	
	@Override
	public PropertyDTO updatePrice( PropertyDTO propertyDTO,Long Id)
	{
		Optional<PropertyEntity>optEn = propertyRepository.findById(Id);
		PropertyDTO dto=null;
		if(optEn.isPresent())
		{
			PropertyEntity pe=optEn.get();
			pe.setPrice(propertyDTO.getPrice());
			dto=propertyConverter.ConvertEntityToDTO(pe);
			propertyRepository.save(pe);
			
		}
		return dto;
	}
	
	@Override
	public void deleteProperty(Long PropertyId) {
		
		propertyRepository.deleteById(PropertyId);
	}
	
	
	

}
