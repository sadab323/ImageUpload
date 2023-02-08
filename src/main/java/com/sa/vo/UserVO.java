package com.sa.vo;

import com.sa.model.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {
	
	private String  name;
	
	private String photoUrl;
	private Address addr;

}
