package com.banka.odev.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.banka.odev.entities.Account;
import com.banka.odev.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionDetailDto {
	  private BigDecimal amount;
	  private StatusEnum status;
	  LocalDateTime transactionDate;
	  String senderNumber;
	  String receiverNumber;
}
