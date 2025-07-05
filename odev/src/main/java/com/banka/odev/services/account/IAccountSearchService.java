package com.banka.odev.services.account;


import java.util.List;
import com.banka.odev.dto.account.AccountRequestDto;
import com.banka.odev.dto.account.AccountResponseDto;

public interface IAccountSearchService {
	public List<AccountResponseDto> findByName(AccountRequestDto name) ;
	public List<AccountResponseDto> findByNumber(AccountRequestDto number) ;
}
