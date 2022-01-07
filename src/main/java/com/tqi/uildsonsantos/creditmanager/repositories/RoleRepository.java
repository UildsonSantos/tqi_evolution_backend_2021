package com.tqi.uildsonsantos.creditmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tqi.uildsonsantos.creditmanager.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
