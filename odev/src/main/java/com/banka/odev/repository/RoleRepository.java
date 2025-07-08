package com.banka.odev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banka.odev.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}