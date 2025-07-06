package com.banka.odev.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banka.odev.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, UUID>{
	List<Transaction> findByFromId(UUID id);
}
