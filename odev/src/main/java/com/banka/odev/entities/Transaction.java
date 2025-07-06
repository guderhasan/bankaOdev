package com.banka.odev.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import com.banka.odev.enums.StatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {
	// !!! Veritabanı buradan oluşturuldu
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID  id;
	
	@ManyToOne 
	private Account from;
	
	@ManyToOne
	private Account to;
	
	@Column(name = "amount")
	private BigDecimal amount;
	
	@Column(name = "transactionDate")
	private LocalDateTime transactionDate;
	
	@Column(name = "status")
	private StatusEnum status;
	
}
