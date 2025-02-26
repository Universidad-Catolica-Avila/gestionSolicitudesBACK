package com.ucav.gestionProtocoloService.web.controller;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ucav.gestionProtocoloService.entity.Categoria;
import com.ucav.gestionProtocoloService.entity.Role;
import com.ucav.gestionProtocoloService.entity.User;
import com.ucav.gestionProtocoloService.exception.ResourceNotFoundException;
import com.ucav.gestionProtocoloService.payload.ApiResponse;
import com.ucav.gestionProtocoloService.payload.CategoriaRequest;
import com.ucav.gestionProtocoloService.payload.UserRequest;
import com.ucav.gestionProtocoloService.repository.CategoriaRepository;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    private static final Logger logger = LoggerFactory.getLogger(CategoriaController.class);

    @Secured("ROLE_ADMIN")
    @GetMapping("/categorias")
    public List<Categoria> getCategorias() {
    	List<Categoria> resultSQL = categoriaRepository.findAll();
    	return resultSQL;
    }
    
    @Secured("ROLE_ADMIN") 
    @PostMapping("/categoria")
    public ResponseEntity<?> saveCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        
    	Categoria categoria = new Categoria();
        
        BeanUtils.copyProperties(categoriaRequest, categoria);

        Categoria result = categoriaRepository.save(categoria);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/categorias/{id}")
                .buildAndExpand(result.getIdCategoria()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
    
//    @Secured("ROLE_ADMIN")
//    @GetMapping("/temas/id/{id}")
//    public Tema getTemaById(@PathVariable(value = "id") Long id) {
//    	Tema tema = temaRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Tema", "id", id));
//        return tema;
//    }
//
//    @Secured("ROLE_ADMIN")
//    @DeleteMapping("/temas/id/{id}")
//    public boolean deleteTemaId(@PathVariable(value = "id") Long id) {
//        return temaRepository.findById(id).map(u -> {
//        	temaRepository.deleteById(id);
//            return true;
//        }).orElseGet(() -> false);
//    }
//    
//    @Secured("ROLE_ADMIN")
//    @PostMapping("/tema")
//    public ResponseEntity<?> createTema(@RequestBody Tema temaRequest) {
//        Tema tema = temaRepository.save(temaRequest);
//        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/temas/id/{id}").buildAndExpand(tema.getIDtema()).toUri();
//        return ResponseEntity.created(location).body(new ApiResponse(true, "Tema creado exitosamente"));
//    }
//
//    @Secured("ROLE_ADMIN")
//    @PutMapping("/tema")
//    public ResponseEntity<?> updateTema(@RequestBody Tema temaRequest) {
//        Tema tema = temaRepository.findById(temaRequest.getIDtema()).orElseThrow(() -> new ResourceNotFoundException("Tema", "id", temaRequest.getIDtema()));
//        tema.setTema(temaRequest.getTema());
//        tema.setRelaciones(temaRequest.getRelaciones());
//        temaRepository.save(tema);
//        return ResponseEntity.ok(new ApiResponse(true, "Tema actualizado exitosamente"));
//    }
}
