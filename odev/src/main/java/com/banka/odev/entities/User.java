package com.banka.odev.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	// !!! Veritabanı buradan oluşturuldu
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID  id;
	
	@NotNull
	@Column(name = "username",unique = true)
	private String username;
	 
	@JsonIgnore
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
	
	
	@OneToMany(mappedBy = "user")
	private List<Account> account;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public void addRole(Role role) {
	  this.roles.add(role);
	}
}
