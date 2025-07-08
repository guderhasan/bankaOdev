package com.banka.odev.services.impl.user;

import java.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.user.UserRegisterRequestDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;
import com.banka.odev.entities.User;
import com.banka.odev.repository.RoleRepository;
import com.banka.odev.repository.UserRepository;
import com.banka.odev.services.user.IUserRegisterService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserRegisterServiceImpl implements IUserRegisterService{
	
	
    private final UserRepository repository;
    private final RoleRepository roleRepository;
	private final  ModelMapper modelMapper;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserRegisterResponseDto register(UserRegisterRequestDto userRegister) {
        
	
		User user = modelMapper.map(userRegister, User.class);
		user.setPassword(passwordEncoder.encode(userRegister.getPassword()));
		user.addRole(roleRepository.findByName("USER").get());
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());

		repository.save(user);
		
		User userResult =  repository.findByEmail(userRegister.getEmail());
	
		return modelMapper.map(userResult, UserRegisterResponseDto.class);
                 
	}

}
