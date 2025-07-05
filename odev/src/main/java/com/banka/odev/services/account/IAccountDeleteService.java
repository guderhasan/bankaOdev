package com.banka.odev.services.account;

import java.util.UUID;

import com.banka.odev.dto.account.AccountCreateResponseDto;

public interface IAccountDeleteService {
   public AccountCreateResponseDto delete(UUID id);
}
