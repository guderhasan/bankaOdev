package com.banka.odev.services.account;

import com.banka.odev.dto.account.AccountCreateRequestDto;
import com.banka.odev.dto.account.AccountCreateResponseDto;


public interface IAccountCreateService {
	public AccountCreateResponseDto create(AccountCreateRequestDto account) ;

}
