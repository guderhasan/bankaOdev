package com.banka.odev.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	// !!! Veritabanı buradan oluşturuldu.
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID  id;
	
	@NotNull
	@Column(name = "number",unique = true)
	private String number;
	
	@NotNull
	@Column(name = "name")
	private String name ;
	
	@Column(name = "balance")
	private BigDecimal balance; 
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

}
