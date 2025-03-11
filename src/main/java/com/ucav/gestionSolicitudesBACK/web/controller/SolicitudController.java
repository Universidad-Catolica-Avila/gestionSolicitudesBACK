package com.ucav.gestionSolicitudesBACK.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucav.gestionSolicitudesBACK.entity.Solicitud;
import com.ucav.gestionSolicitudesBACK.repository.SolicitudRepository;

@RestController
@RequestMapping("/api")
public class SolicitudController {

    @Autowired
    private SolicitudRepository solicitudRepository;
    


    private static final Logger logger = LoggerFactory.getLogger(SolicitudController.class);

    @Secured({"ROLE_ADMIN_CC", "ROLE_ADMIN", "ROLE_PROFESOR", "ROLE_CC", "ROLE_APROBADOR"})
    @GetMapping("/solicitudes")
    public List<Solicitud> getSolicitudes() {
    	List<Solicitud> resultSQL = solicitudRepository.findAll();
    	return resultSQL;
    }
    
    

}
