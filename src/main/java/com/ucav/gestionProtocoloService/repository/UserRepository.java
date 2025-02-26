package com.ucav.gestionProtocoloService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucav.gestionProtocoloService.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {
	
	List<Usuario> findAll();
	 
    Optional<Usuario> findByEmail(String email);
    
    Optional<Usuario> findByUsernameOrEmail(String username, String email);

    List<Usuario> findByIdIn(List<Long> userIds);

    Optional<Usuario> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
