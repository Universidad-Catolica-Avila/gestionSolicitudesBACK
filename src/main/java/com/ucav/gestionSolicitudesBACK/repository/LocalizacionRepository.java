package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.Localizacion;

@Repository
public interface LocalizacionRepository extends JpaRepository<Localizacion, Long> {}
