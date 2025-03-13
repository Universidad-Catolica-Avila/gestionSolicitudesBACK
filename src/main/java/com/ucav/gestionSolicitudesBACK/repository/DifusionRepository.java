package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.Difusion;

@Repository
public interface DifusionRepository extends JpaRepository<Difusion, Long> {}