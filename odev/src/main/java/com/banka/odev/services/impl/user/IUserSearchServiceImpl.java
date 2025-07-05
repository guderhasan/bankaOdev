package com.banka.odev.services.impl.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.user.UserResponseDto;
import com.banka.odev.entities.User;
import com.banka.odev.repository.UserRepository;
import com.banka.odev.services.user.IUserSearchService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IUserSearchServiceImpl implements IUserSearchService{

	  private final UserRepository repository;
	  private final  ModelMapper modelMapper;
	
	  @Override
		public List<UserResponseDto> findAll() {
			// TODO Auto-generated method stub
			List<User> users =  repository.findAll();
			
			return
			 users.stream()
	        .map(c -> modelMapper.map(c, UserResponseDto.class))
	        .collect(Collectors.toList());
		}

	@Override
	public UserResponseDto findById(UUID id) {
		// TODO Auto-generated method stub
		Optional<User> account =  repository.findById(id);
		return modelMapper.map(account, UserResponseDto.class);
	}

}
