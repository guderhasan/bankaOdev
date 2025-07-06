package com.banka.odev.services.impl.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.banka.odev.dto.transaction.TransactionTransferRequestDto;
import com.banka.odev.dto.transaction.TransactionTransferResponseDto;
import com.banka.odev.entities.Account;
import com.banka.odev.entities.Transaction;
import com.banka.odev.enums.StatusEnum;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.repository.TransactionRepository;
import com.banka.odev.services.transaction.ITransactionTransferService;
import lombok.RequiredArgsConstructor;

// @Transactional metot üzerinde kullanıldı
@RequiredArgsConstructor
@Service
public class TransactionTransferServiceImpl implements ITransactionTransferService{
     
	private final TransactionRepository repository;
	private final AccountRepository accountRepository;
	private final  ModelMapper modelMapper;
	
	// !!! Autowired vs. ile bu nesne yaratılabilirdi fakat model sınıfı olduğundan yaratılmıyor. Model classında @Component kullanmak ta sakıncalı olabileceğinden bu şekilde nesne türetildi.
	Transaction transaction =new Transaction();

	// Aynı anda gerçekleşen işlemlerde hata olursa işlemlerin geri alınması
	@Transactional
	@Override
	public TransactionTransferResponseDto transfer(TransactionTransferRequestDto transfer) {
		// TODO Auto-generated method stub
		
		//Bazı durumlarda var olan api servisler de çağrılabilir, bu örnekte hesap api servisi yerine veritabanından çağrıldı. Var olan repository sorgusu liste döndüğünden bu şekilde yazıldı. Burada tek bir elemanın döneceğini biliyoruz. 
		Account receiverAccount= accountRepository.findByNumber(transfer.getReceiver()) != null ? accountRepository.findByNumber(transfer.getReceiver()).get(0) : null;
		Account senderAccount= accountRepository.findByNumber(transfer.getSender()) != null ? accountRepository.findByNumber(transfer.getSender()).get(0) : null;
		
			int compareResult = senderAccount.getBalance().compareTo(transfer.getBalance());
			if(compareResult != -1) {
				
				// !!!!! Mikroservis mimarisine göre  var olan update api servisi çağrılabilirdi, repository üzerinde işlemler yapıldı.
				
				senderAccount.setBalance(senderAccount.getBalance().subtract(transfer.getBalance()));
				senderAccount.setUpdatedAt(LocalDateTime.now());
				accountRepository.save(senderAccount);
				  
				receiverAccount.setBalance(receiverAccount.getBalance().add(transfer.getBalance()));
				receiverAccount.setUpdatedAt(LocalDateTime.now());
				accountRepository.save(receiverAccount);
				
				saveTransaction(transfer.getBalance(),StatusEnum.SUCCESS,receiverAccount,senderAccount);
				
				return modelMapper.map(transaction, TransactionTransferResponseDto.class);
				
			}else {
				saveTransaction(transfer.getBalance(),StatusEnum.FAILED,receiverAccount,senderAccount);
				return modelMapper.map(transaction, TransactionTransferResponseDto.class);
			}
			
		} 

	
	public void saveTransaction(BigDecimal balance, StatusEnum status,Account receiver, Account sender) {
		
		transaction.setAmount(balance);
		transaction.setFrom(sender);
		transaction.setTo(receiver);
		transaction.setStatus(status);
		transaction.setTransactionDate(LocalDateTime.now());
		
		repository.save(transaction);
	}
	
}
