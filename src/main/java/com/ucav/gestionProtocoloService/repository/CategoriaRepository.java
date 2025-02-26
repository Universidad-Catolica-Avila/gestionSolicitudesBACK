package com.ucav.gestionProtocoloService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucav.gestionProtocoloService.entity.Categoria;
import com.ucav.gestionProtocoloService.entity.User;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
 
}
