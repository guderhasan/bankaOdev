package com.banka.odev.services.impl.account;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.account.AccountRequestDto;
import com.banka.odev.dto.account.AccountResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.services.account.IAccountSearchService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AccountSearchServiceImpl implements IAccountSearchService{

	  private final AccountRepository repository;
	  private final  ModelMapper modelMapper;
	  
	@Override
	public List<AccountResponseDto> findByName(AccountRequestDto name) {
		// TODO Auto-generated method stub
		List<Account> accounts =  repository.findByName(name.getName());
		List<AccountResponseDto> results= 
				accounts.stream()
        .map(c -> modelMapper.map(c, AccountResponseDto.class))
        .collect(Collectors.toList());
		
		return results;
	}
	@Override
	public List<AccountResponseDto> findByNumber(AccountRequestDto number) {
		// TODO Auto-generated method stub
		List<Account> accounts =  repository.findByNumber(number.getNumber());
		
		return
		 accounts.stream()
        .map(c -> modelMapper.map(c, AccountResponseDto.class))
        .collect(Collectors.toList());
	}

	


}
