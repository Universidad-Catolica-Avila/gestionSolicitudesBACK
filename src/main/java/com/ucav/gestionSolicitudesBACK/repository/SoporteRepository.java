package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.Soporte;

@Repository
public interface SoporteRepository extends JpaRepository<Soporte, Long> {}