package com.banka.odev.services.impl.user;

import java.time.LocalDateTime;
import java.util.Base64;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.banka.odev.dto.user.UserRegisterRequestDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;
import com.banka.odev.entities.User;
import com.banka.odev.repository.UserRepository;
import com.banka.odev.services.user.IUserRegisterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements IUserRegisterService{
	
	
    private final UserRepository repository;
	private final  ModelMapper modelMapper;

	@Override
	public UserRegisterResponseDto register(UserRegisterRequestDto userRegister) {
        
		// Temel bir password şifreleyici kullanıldı
		userRegister.setPassword(Base64.getEncoder().encodeToString(userRegister.getPassword().getBytes()));
		User user = modelMapper.map(userRegister, User.class);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());

		repository.save(user);
		
		User userResult =  repository.findByEmail(userRegister.getEmail());
	
		return modelMapper.map(userResult, UserRegisterResponseDto.class);
                 
	}

}
