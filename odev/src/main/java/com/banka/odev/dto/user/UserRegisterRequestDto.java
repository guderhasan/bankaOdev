package com.banka.odev.dto.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRegisterRequestDto {
   private String email;
   private String userName;
   private String password;
}
