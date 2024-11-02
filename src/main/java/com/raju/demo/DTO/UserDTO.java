package com.raju.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDTO {

	private Long Id;
	private String ownerName;
	
	@NotNull(message="Owner Email is Mandatory")
	@NotEmpty(message="Ownerr Email can not be Empty")
	@Size(min=1,max=50,message="Owner Email should be between 1 to 50 charecters in length")
	private String ownerEmail;
	private String phone;
	@NotNull(message="password can not be Null")
	@NotEmpty(message="password can not be Empty")
	private String password;
	
}
