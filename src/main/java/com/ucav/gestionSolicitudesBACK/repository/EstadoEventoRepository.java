package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.EstadoEvento;

@Repository
public interface EstadoEventoRepository extends JpaRepository<EstadoEvento, Long> {}
