package com.raju.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.raju.demo.DTO.PropertyDTO;
import com.raju.demo.service.PropertyService;

@RestController
@RequestMapping("api/v1/")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@PostMapping("/properties")
	ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO )
	{
		
		propertyDTO=propertyService.saveProperty(propertyDTO );
		ResponseEntity<PropertyDTO> responceEntity= new ResponseEntity<>(propertyDTO,HttpStatus.CREATED);
		return responceEntity;
	}
	
	
	@GetMapping("properties")
	ResponseEntity<List<PropertyDTO>> getAllproperties()
	{
		List<PropertyDTO> list= propertyService.getAllProperties();
		ResponseEntity<List<PropertyDTO>> responceEntity= new ResponseEntity<>(list,HttpStatus.OK);
		return responceEntity;
	}
	
	@PutMapping("properties/{Id}")
	ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertDTO,@PathVariable Long Id)
	{
		PropertyDTO dto = propertyService.updateProperty(propertDTO, Id);
		ResponseEntity<PropertyDTO> responceEntity= new ResponseEntity<>(dto,HttpStatus.OK);
		return responceEntity;
	}
	
	@PatchMapping("/properties/update-description/{propertyId}")
	public ResponseEntity<PropertyDTO>  updateDescription(@RequestBody PropertyDTO propertyDTO ,@PathVariable Long propertyId)
	{
		PropertyDTO dto= propertyService.updateDescription(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> responceEntity= new ResponseEntity<>(dto,HttpStatus.OK);
		return responceEntity;
	}
	
	@PatchMapping("/properties/update-price/{propertyId}")
	public ResponseEntity<PropertyDTO>  updateprice(@RequestBody PropertyDTO propertyDTO ,@PathVariable Long propertyId)
	{
		PropertyDTO dto= propertyService.updatePrice(propertyDTO, propertyId);
		ResponseEntity<PropertyDTO> responceEntity= new ResponseEntity<>(dto,HttpStatus.OK);
		return responceEntity;
	}
	
	@DeleteMapping("/properties/delete/{propertyId}")
	public ResponseEntity deleteProperty(@PathVariable Long propertyId)
	{
		propertyService.deleteProperty(propertyId);
		ResponseEntity<Void> responceEntity= new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
		return responceEntity;
		
	}
	
	
	
	

}
