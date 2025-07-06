package com.banka.odev.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banka.odev.dto.transaction.TransactionTransferRequestDto;
import com.banka.odev.dto.transaction.TransactionTransferResponseDto;
import com.banka.odev.services.transaction.ITransactionTransferService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/transactions")
public class TransactionController {
	
	private final ITransactionTransferService transferService;
	
	@PostMapping(path = "/transfer")
	public ResponseEntity<TransactionTransferResponseDto> transfer(TransactionTransferRequestDto transfer) {
		
		return ResponseEntity.ok(transferService.transfer(transfer));
	}
}
