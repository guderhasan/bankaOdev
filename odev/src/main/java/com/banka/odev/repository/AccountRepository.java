package com.banka.odev.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banka.odev.dto.account.AccountResponseListDto;
import com.banka.odev.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{

	List<Account> findByNumber(String number);
	List<Account> findByName(String name);

}
