package com.banka.odev.dto.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.banka.odev.enums.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionTransferResponseDto {
	
  private BigDecimal amount;
  private StatusEnum status;
  LocalDateTime transactionDate;
  
}
