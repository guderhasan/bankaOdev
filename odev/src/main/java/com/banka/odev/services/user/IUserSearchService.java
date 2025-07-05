package com.banka.odev.services.user;

import java.util.List;
import java.util.UUID;

import com.banka.odev.dto.user.UserResponseDto;

public interface IUserSearchService {
	public List<UserResponseDto> findAll() ;
	public UserResponseDto findById(UUID id) ;
}
