package com.ucav.gestionSolicitudesBACK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ucav.gestionSolicitudesBACK.entity.Certificado;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
}