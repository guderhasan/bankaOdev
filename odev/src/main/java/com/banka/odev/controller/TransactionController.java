package com.banka.odev.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.banka.odev.dto.transaction.TransactionDetailDto;
import com.banka.odev.dto.transaction.TransactionTransferRequestDto;
import com.banka.odev.dto.transaction.TransactionTransferResponseDto;
import com.banka.odev.services.transaction.ITransactionDetailService;
import com.banka.odev.services.transaction.ITransactionTransferService;
import lombok.RequiredArgsConstructor;

//Localde React testleri için yazıldı
@CrossOrigin(origins = "http://localhost:3000")

@RequiredArgsConstructor
@RestController
@RequestMapping("api/transactions")
public class TransactionController {
	
	private final ITransactionTransferService transferService;
	private final ITransactionDetailService detailService;
	
	@PostMapping(path = "/transfer")
	public ResponseEntity<TransactionTransferResponseDto> transfer(TransactionTransferRequestDto transfer) {
		
		return ResponseEntity.ok(transferService.transfer(transfer));
	}
	
	@GetMapping(path = "/account")
	public ResponseEntity<List<TransactionDetailDto>> transactionDetail(@RequestParam UUID id) {
		
		return ResponseEntity.ok(detailService.transactionDetail(id));
	}
	
}
