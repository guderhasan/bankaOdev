package com.banka.odev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banka.odev.dto.UserRegisterRequestDto;
import com.banka.odev.dto.UserRegisterResponseDto;
import com.banka.odev.services.IRegisterService;


@RestController
@RequestMapping("api/users")
public class UserController {

	
	@Autowired
	private IRegisterService registerService;

	@PostMapping(path = "/register")
	public ResponseEntity<UserRegisterResponseDto> register(UserRegisterRequestDto userRegister) {
		
		return ResponseEntity.ok(registerService.register(userRegister));
	}
	
}
