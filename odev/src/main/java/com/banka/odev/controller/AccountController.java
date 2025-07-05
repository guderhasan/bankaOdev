package com.banka.odev.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banka.odev.dto.account.AccountCreateRequestDto;
import com.banka.odev.dto.account.AccountCreateResponseDto;
import com.banka.odev.dto.account.AccountRequestDto;
import com.banka.odev.dto.account.AccountResponseDto;
import com.banka.odev.services.account.IAccountCreateService;
import com.banka.odev.services.account.IAccountSearchService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/accounts")
public class AccountController {

	private final IAccountCreateService createService;
	private final IAccountSearchService searchService;

	@PostMapping(path = "/create")
	public ResponseEntity<AccountCreateResponseDto> create(AccountCreateRequestDto accountCreate) {
		
		return ResponseEntity.ok(createService.create(accountCreate));
	}
	
	@PostMapping(path = "/search/name")
	public ResponseEntity<List<AccountResponseDto>> findByName(AccountRequestDto account) {
		
		return ResponseEntity.ok(searchService.findByName(account));
	}
	
	@PostMapping(path = "/search/number")
	public ResponseEntity<List<AccountResponseDto>> findByNumber(AccountRequestDto account) {
		
		return ResponseEntity.ok(searchService.findByNumber(account));
	}
	
}
