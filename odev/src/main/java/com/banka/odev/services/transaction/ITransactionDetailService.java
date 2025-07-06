package com.banka.odev.services.transaction;

import java.util.List;
import java.util.UUID;
import com.banka.odev.dto.transaction.TransactionDetailDto;

public interface ITransactionDetailService {
	public List<TransactionDetailDto> transactionDetail(UUID id);

}
