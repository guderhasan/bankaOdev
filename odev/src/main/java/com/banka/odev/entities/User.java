package com.banka.odev.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	// !!! Veritabanı buradan oluşturuldu
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID  id;
	
	@NotNull
	@Column(name = "username",unique = true)
	private String username;
	 
	@NotNull
	@Column(name = "password")
	private String password ;
	
	@NotNull
	@Column(name = "email",unique = true)
	private String email;
	
	@Column(name = "createdAt")
	private LocalDateTime createdAt;
	
	@Column(name = "updatedAt")
	private LocalDateTime updatedAt;
	
	@OneToMany
	private List<Account> account;
}
