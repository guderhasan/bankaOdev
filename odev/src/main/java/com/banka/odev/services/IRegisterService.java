package com.banka.odev.services;

import com.banka.odev.dto.UserRegisterRequestDto;
import com.banka.odev.dto.UserRegisterResponseDto;


public interface IRegisterService {
	public UserRegisterResponseDto register(UserRegisterRequestDto user) ;
}
