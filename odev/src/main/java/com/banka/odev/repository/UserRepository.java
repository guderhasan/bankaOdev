package com.banka.odev.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banka.odev.dto.user.UserRequestDto;
import com.banka.odev.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
  User findByEmail(String email);
  Optional<User> findById(UUID id);
  Optional<User> findUserByUsername(String username);

}
