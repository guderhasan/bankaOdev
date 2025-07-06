package com.banka.odev.services.impl.account;

import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.services.account.IAccountDeleteService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountDeleteServiceImpl implements IAccountDeleteService{
	
	private final AccountRepository repository;
    private final  ModelMapper modelMapper;


	@Override
	public AccountCreateResponseDto delete(UUID id) {
		// TODO Auto-generated method stub
		
		//Silinen hesaba ait bazı bilgileri kullanıcıya göstermek amaçlı oluşturuldu.
		Optional<Account> account =  repository.findById(id);
		
		repository.deleteById(id);
		
		return modelMapper.map(account, AccountCreateResponseDto.class);
	}

}
