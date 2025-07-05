package com.banka.odev.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	public ResponseEntity<AccountCreateResponseDto> create(AccountCreateRequestDto accountCreate,UUID id) {
		
		return ResponseEntity.ok(createService.create(accountCreate,id));
	}
	
	@PostMapping(path = "/search/name")
	public ResponseEntity<List<AccountResponseDto>> findByName(AccountRequestDto account,UUID id) {
		
		return ResponseEntity.ok(searchService.findByName(account,id));
	}
	
	@PostMapping(path = "/search/number")
	public ResponseEntity<List<AccountResponseDto>> findByNumber(AccountRequestDto account,UUID id) {
		
		return ResponseEntity.ok(searchService.findByNumber(account,id));
	}
	
	@GetMapping(path = "/search/findAll")
	public ResponseEntity<List<AccountResponseDto>> findAll(UUID id) {
		
		return ResponseEntity.ok(searchService.findAll(id));
	}
	
	@GetMapping(path = "/search/findById")
	public ResponseEntity<AccountResponseDto> findById(UUID id) {
		
		return ResponseEntity.ok(searchService.findById(id));
	}
	
}
