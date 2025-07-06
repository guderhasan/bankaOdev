package com.banka.odev.dto.transaction;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransactionTransferRequestDto {
	
	private String receiver;
	private String sender;
	private BigDecimal balance;

}
