package com.banka.odev.services.transaction;

import com.banka.odev.dto.transaction.TransactionTransferRequestDto;
import com.banka.odev.dto.transaction.TransactionTransferResponseDto;

public interface ITransactionTransferService {
  public TransactionTransferResponseDto transfer(TransactionTransferRequestDto transfer);
}
