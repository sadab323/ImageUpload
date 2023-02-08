package com.sa.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sa.model.Address;
import com.sa.model.User;
import com.sa.repo.UserRepo;
import com.sa.vo.AddressVO;
import com.sa.vo.UserVO;

@RestController
public class UserController {
	
	@Autowired
	UserRepo userRepo;
	
	
	@PostMapping(value="/saveUser",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public String saveUser(@RequestParam MultipartFile image,@RequestPart UserVO user,@RequestPart AddressVO address) {
		User users=new User();
		Address add=new Address();
		
		String path=image.getOriginalFilename();
		
		File f=new File("D:\\image\\",path);
		try {
			image.transferTo(f);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		users.setName(user.getName());
		users.setPhotoUrl(f.getAbsolutePath());
		add.setCityName(address.getCityName());
		add.setPinCode(address.getPinCode());
		users.setAddr(add);
		userRepo.save(users);
		
		return "User Details save";
	}

}
