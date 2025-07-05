package com.banka.odev.dto.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
	// Kullanıcıya ait sorgulamalarda kullanmak için oluşturuldu.
	private UUID id;
}
