package com.banka.odev.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banka.odev.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{

	List<Account> findByNumberAndUserId(String number, UUID id);
	List<Account> findByNameAndUserId(String name, UUID id);
	Optional<Account> findById(UUID id);
	List<Account> findByNumber(String number);
	List<Account> findByUserId(UUID userId);
	
}
