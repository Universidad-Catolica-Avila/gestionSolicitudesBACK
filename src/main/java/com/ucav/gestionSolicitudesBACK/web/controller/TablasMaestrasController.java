package com.ucav.gestionSolicitudesBACK.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucav.gestionSolicitudesBACK.repository.*;

@RestController
@RequestMapping("/api")
public class TablasMaestrasController {

    @Autowired private CertificadoRepository certificadoRepository;
    @Autowired private DifusionRepository difusionRepository;
    @Autowired private EstadoEventoRepository estadoEventoRepository;
    @Autowired private FormatoEventoRepository formatoEventoRepository;
    @Autowired private LocalizacionRepository localizacionRepository;
    @Autowired private OrganizadorRepository organizadorRepository;
    @Autowired private PublicoRepository publicoRepository;
    @Autowired private SoporteRepository soporteRepository;
    @Autowired private TipoEventoRepository tipoEventoRepository;

    private static final Logger logger = LoggerFactory.getLogger(TablasMaestrasController.class);

    @GetMapping("/tablas/{tabla}")
    public ResponseEntity<?> getValoresTabla(@PathVariable String tabla) {
        try {
            List<?> resultSQL;

            switch (tabla.toLowerCase()) {
                case "certificados":
                    resultSQL = certificadoRepository.findAll();
                    break;
                case "difusiones":
                    resultSQL = difusionRepository.findAll();
                    break;
                case "estados_evento":
                    resultSQL = estadoEventoRepository.findAll();
                    break;
                case "formatos_evento":
                    resultSQL = formatoEventoRepository.findAll();
                    break;
                case "localizaciones":
                    resultSQL = localizacionRepository.findAll();
                    break;
                case "organizadores":
                    resultSQL = organizadorRepository.findAll();
                    break;
                case "publicos":
                    resultSQL = publicoRepository.findAll();
                    break;
                case "soportes":
                    resultSQL = soporteRepository.findAll();
                    break;
                case "tipos_evento":
                    resultSQL = tipoEventoRepository.findAll();
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("La tabla '" + tabla + "' no está disponible.");
            }

            if (resultSQL.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .body("No hay registros disponibles en la tabla '" + tabla + "'.");
            }

            return ResponseEntity.ok(resultSQL);
        } catch (Exception e) {
            logger.error("Error al recuperar datos de la tabla '{}': {}", tabla, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al recuperar los datos: " + e.getMessage());
        }
    }
}
