package com.banka.odev.services.impl.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banka.odev.dto.transaction.TransactionDetailDto;
import com.banka.odev.entities.Account;
import com.banka.odev.entities.Transaction;
import com.banka.odev.enums.StatusEnum;
import com.banka.odev.repository.AccountRepository;
import com.banka.odev.repository.TransactionRepository;
import com.banka.odev.services.transaction.ITransactionDetailService;
import lombok.RequiredArgsConstructor;

@Service
public class TransactionDetailServiceImpl implements ITransactionDetailService{

	@Autowired
	private TransactionRepository repository;
	
	@Override
	public List<TransactionDetailDto> transactionDetail(UUID id) {
		// TODO Auto-generated method stub
		
		// !!! Bu işlem JAVA STREAM API ile yapılmak istendi fakat uyumsuzluk olduğundan aşağıdaki yöntem kullanıldı
		
			List<Transaction> transactions =  repository.findByFromId(id);
			
			// Dependency Injection için uygun değil
			List<TransactionDetailDto> details = new ArrayList<TransactionDetailDto>();
		    
			for(int i=0 ; i< transactions.size();i++) {	
				
				// Dependency Injection için uygun değil
				TransactionDetailDto detail = new TransactionDetailDto();
				
				detail.setAmount(transactions.get(i).getAmount());
				detail.setStatus(transactions.get(i).getStatus());
				detail.setTransactionDate(transactions.get(i).getTransactionDate());
				detail.setSenderNumber(transactions.get(i).getFrom().getNumber());
				detail.setReceiverNumber(transactions.get(i).getTo().getNumber());
				details.add(detail);
			}
	
			return details;
	}

}
