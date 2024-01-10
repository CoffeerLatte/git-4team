package com.todo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.entity.ERole;
import com.todo.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {  
	Optional<Role> findByName(ERole roleName);
}
