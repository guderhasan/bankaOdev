package com.banka.odev.services.account;


import java.util.List;
import java.util.UUID;
import com.banka.odev.dto.account.AccountRequestDto;
import com.banka.odev.dto.account.AccountResponseDto;

public interface IAccountSearchService {
	public List<AccountResponseDto> findByName(AccountRequestDto name,UUID id) ;
	public List<AccountResponseDto> findByNumber(AccountRequestDto number,UUID id) ;
	public List<AccountResponseDto> findAll(UUID id) ;
	public AccountResponseDto findById(UUID id);
}
