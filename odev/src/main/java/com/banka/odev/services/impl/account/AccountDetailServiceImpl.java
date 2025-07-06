package com.banka.odev.services.impl.account;

import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.account.AccountDetailResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.services.account.IAccountDetailService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountDetailServiceImpl implements IAccountDetailService{
	private final AccountRepository repository;
	  private final  ModelMapper modelMapper;

	@Override
	public AccountDetailResponseDto accountDetail(UUID id) {
		// TODO Auto-generated method stub
		Optional<Account> account =  repository.findById(id);
		return modelMapper.map(account, AccountDetailResponseDto.class);
	}

}
