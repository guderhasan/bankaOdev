package com.banka.odev.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banka.odev.dto.login.LoginRequest;
import com.banka.odev.dto.login.LoginResponse;
import com.banka.odev.dto.user.UserRegisterRequestDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;
import com.banka.odev.dto.user.UserResponseDto;
import com.banka.odev.services.impl.jwt.JwtService;
import com.banka.odev.services.user.IUserRegisterService;
import com.banka.odev.services.user.IUserSearchService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

//Localde React testleri için yazıldı
@CrossOrigin(origins = "http://localhost:3000")

@RequiredArgsConstructor
@RestController
@RequestMapping("api/users")
public class UserController {

	
	private final IUserRegisterService registerService;
	private final IUserSearchService searchService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


	@PostMapping(path = "/register")
	public ResponseEntity<UserRegisterResponseDto> register(UserRegisterRequestDto userRegister) {
		
		return ResponseEntity.ok(registerService.register(userRegister));
	}
	
	 @PostMapping("/login")
	    public LoginResponse login(@Valid @RequestBody LoginRequest login) {
	       
	        Authentication auth = authenticationManager
	                .authenticate(
	                        new UsernamePasswordAuthenticationToken(
	                                login.getUsername(),
	                                login.getPassword()
	                        )
	                );
	       
	        String token = jwtService.generateToken((UserDetails) auth.getPrincipal());
	        
	        return new LoginResponse(token);
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
