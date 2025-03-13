package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.FormatoEvento;

@Repository
public interface FormatoEventoRepository extends JpaRepository<FormatoEvento, Long> {}
