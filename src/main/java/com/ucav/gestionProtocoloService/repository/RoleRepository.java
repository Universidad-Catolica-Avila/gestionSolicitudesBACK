package com.ucav.gestionProtocoloService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucav.gestionProtocoloService.entity.Rol;
import com.ucav.gestionProtocoloService.entity.RolName;


@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(RolName name);
    List<Rol> findAll();
}
