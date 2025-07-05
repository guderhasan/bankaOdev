package com.banka.odev.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banka.odev.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID>{

	Account findByNumber(String number);
 
}
