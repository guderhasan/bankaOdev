package com.banka.odev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banka.odev.dto.account.AccountCreateRequestDto;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.services.account.IAccountCreateService;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

	
	@Autowired
	private IAccountCreateService createService;

	@PostMapping(path = "/create")
	public ResponseEntity<AccountCreateResponseDto> create(AccountCreateRequestDto accountCreate) {
		
		return ResponseEntity.ok(createService.create(accountCreate));
	}
	
}
