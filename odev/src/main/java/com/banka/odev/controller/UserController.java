package com.banka.odev.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banka.odev.dto.user.UserRegisterRequestDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;
import com.banka.odev.dto.user.UserResponseDto;
import com.banka.odev.services.user.IUserRegisterService;
import com.banka.odev.services.user.IUserSearchService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

	
	private final IUserRegisterService registerService;
	private final IUserSearchService searchService;

	@PostMapping(path = "/register")
	public ResponseEntity<UserRegisterResponseDto> register(UserRegisterRequestDto userRegister) {
		
		return ResponseEntity.ok(registerService.register(userRegister));
	}
	
	@GetMapping(path = "search/findAll")
	public ResponseEntity<List<UserResponseDto>> findAll() {
		
		return ResponseEntity.ok(searchService.findAll());
	}
	
	@GetMapping(path = "search/findById")
	public ResponseEntity<UserResponseDto> findById(UUID id) {
		
		return ResponseEntity.ok(searchService.findById(id));
	}
	
}
