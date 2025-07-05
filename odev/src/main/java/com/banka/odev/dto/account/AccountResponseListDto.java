package com.banka.odev.dto.account;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Account Search Dönüş Değerlerinde böyle bir kullanım da olabilirdi.
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountResponseListDto {
private List<AccountResponseDto> account;
}
