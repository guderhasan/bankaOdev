package com.banka.odev.services.account;

import java.util.UUID;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.entities.Account;

public interface IAccountUpdateService {
	public AccountCreateResponseDto update(UUID id,Account account) ;

}
