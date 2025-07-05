package com.banka.odev.dto.account;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountCreateResponseDto {
	private String number;
	private String name;
}
