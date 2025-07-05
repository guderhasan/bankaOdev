package com.banka.odev.services.impl.account;

import java.time.LocalDateTime;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.services.account.IAccountUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUpdateServiceImpl implements IAccountUpdateService{
	
     private final AccountRepository repository;
     private final  ModelMapper modelMapper;

	@Override
	public AccountCreateResponseDto update(UUID id,Account account) {
		
		// TODO Auto-generated method stub
		
		Account accountResult = repository.findById(id).get();
		accountResult.setName(account.getName());
		accountResult.setUpdatedAt(LocalDateTime.now());
		
		repository.save(accountResult);
		
		Account accountUpdated = repository.findById(id).get();
		
		return modelMapper.map(accountUpdated, AccountCreateResponseDto.class);
	}
		

}
