package com.banka.odev.services.account;

import java.util.UUID;
import com.banka.odev.dto.account.AccountDetailResponseDto;

public interface IAccountDetailService {
	public AccountDetailResponseDto accountDetail(UUID id);

}
