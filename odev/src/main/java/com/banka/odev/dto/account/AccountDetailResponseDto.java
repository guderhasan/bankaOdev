package com.banka.odev.dto.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDetailResponseDto {
	private String number;
	private String name;
	private BigDecimal balance;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
