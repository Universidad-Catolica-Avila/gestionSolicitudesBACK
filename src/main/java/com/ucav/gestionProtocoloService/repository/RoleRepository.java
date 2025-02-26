package com.ucav.gestionProtocoloService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucav.gestionProtocoloService.entity.Role;
import com.ucav.gestionProtocoloService.entity.RoleName;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
    List<Role> findAll();
}
