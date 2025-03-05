package com.ucav.gestionSolicitudesBACK.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucav.gestionSolicitudesBACK.entity.Rol;
import com.ucav.gestionSolicitudesBACK.entity.RolName;


@Repository
public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(RolName name);
    List<Rol> findAll();
}
