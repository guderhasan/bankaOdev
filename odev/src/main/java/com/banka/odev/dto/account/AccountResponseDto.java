package com.banka.odev.dto.account;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountResponseDto {
	private String number;
	private String name;
	private BigDecimal balance;
	private LocalDateTime createdAt;
	// id kullanarak silme,güncelleme işlemlerini yapabilmek için oluşturuldu.
	private UUID id;
}
