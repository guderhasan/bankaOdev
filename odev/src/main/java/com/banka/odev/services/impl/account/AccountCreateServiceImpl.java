package com.banka.odev.services.impl.account;

import java.time.LocalDateTime;
import java.util.Base64;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.banka.odev.dto.account.AccountCreateRequestDto;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.dto.user.UserRegisterResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.entities.User;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.repository.UserRepository;
import com.banka.odev.services.account.IAccountCreateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountCreateServiceImpl implements IAccountCreateService{
	
    private final AccountRepository repository;
	private final  ModelMapper modelMapper;
	
	@Override
	public AccountCreateResponseDto create(AccountCreateRequestDto accountRegister) {
		// TODO Auto-generated method stub
		
		Account account = modelMapper.map(accountRegister, Account.class);
		account.setCreatedAt(LocalDateTime.now());
		account.setUpdatedAt(LocalDateTime.now());

		repository.save(account);

		Account accountResult = accountRegister != null ? repository.findByNumber(accountRegister.getNumber()).get(0) : null;
	
		return modelMapper.map(accountResult, AccountCreateResponseDto.class);
	}

}
