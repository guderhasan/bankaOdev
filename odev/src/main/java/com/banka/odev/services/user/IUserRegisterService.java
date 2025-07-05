package com.banka.odev.services.user;

import com.banka.odev.dto.user.UserRegisterRequestDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;


public interface IUserRegisterService {
	public UserRegisterResponseDto register(UserRegisterRequestDto user) ;
}
