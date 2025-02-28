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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ucav.gestionProtocoloService.entity.Rol;
import com.ucav.gestionProtocoloService.entity.Usuario;
import com.ucav.gestionProtocoloService.exception.ResourceNotFoundException;
import com.ucav.gestionProtocoloService.payload.ApiResponse;
import com.ucav.gestionProtocoloService.payload.UserProfile;
import com.ucav.gestionProtocoloService.payload.UserRequest;
import com.ucav.gestionProtocoloService.repository.RoleRepository;
import com.ucav.gestionProtocoloService.repository.UserRepository;
import com.ucav.gestionProtocoloService.security.CurrentUser;
import com.ucav.gestionProtocoloService.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    //private PollService pollService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Secured("ROL_ADMIN_CC")
    @GetMapping("/users")
    public List<Usuario> getUsuarios() {
    	List<Usuario> resultSQL = userRepository.findAll();
    	return resultSQL;
    }
    
    @Secured("ROL_ADMIN_CC")
    @GetMapping("/roles")
    public List<Rol> getRoles() {
    	List<Rol> resultSQL = roleRepository.findAll();
    	return resultSQL;
    }
    
    @Secured("ROL_ADMIN_CC")
    @GetMapping("/users/id/{id}")
    public Usuario getUserId(@PathVariable(value = "id") Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        return user;
    }

    @Secured("ROL_ADMIN_CC")
    @DeleteMapping("/users/id/{id}")
    public boolean deleteUserId(@PathVariable(value = "id") Long id) {
        
        return userRepository.findById(id)
                .map(u -> {
                	userRepository.deleteById(id);
                    return true;
                })
                .orElseGet(() -> false);
        
    }    
    
    
    @GetMapping("/user/me")
    @Secured({"ROL_ADMIN_CC","ROLE_USER"})
    public Usuario getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    	Usuario userR = userRepository.findById(currentUser.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", currentUser.getId()));;
        return userR;
    }

    @Secured("ROL_ADMIN_CC")
    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        Usuario user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getNombre(), user.getCreatedAt());

        return userProfile;
    }

    @Secured("ROL_ADMIN_CC") 
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody UserRequest userRequest) {
        Usuario user = new Usuario();
        
        BeanUtils.copyProperties(userRequest, user);
        Rol role = new Rol();
        role.setId(Long.valueOf(userRequest.getRolId()));
        user.setRoles(Collections.singleton(role));
        
        if (user.getId()!= null && userRequest.getPassword() == null) {
        	Usuario userPass = userRepository.findById(user.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        	if(userPass.getPassword() != null) {
        		user.setPassword(userPass.getPassword());
        	}
        } else {
        	user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        }

        Usuario result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
    
    @Secured("ROL_ADMIN_CC") 
    @PutMapping("/user")
    public ResponseEntity<?> updateUser(@RequestBody UserRequest userRequest) {
        
        Usuario user = new Usuario();
        
        BeanUtils.copyProperties(userRequest, user);
        Rol role = new Rol();
        role.setId(Long.valueOf(userRequest.getRolId()));
        user.setRoles(Collections.singleton(role));
        
        if (user.getId()!= null && userRequest.getPassword() == null) {
        	Usuario userPass = userRepository.findById(user.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("User", "id", user.getId()));
        	if(userPass.getPassword() != null) {
        		user.setPassword(userPass.getPassword());
        	}
        } 
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        
        Usuario result = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();

        return ResponseEntity.created(location).body(new ApiResponse(true, "User updated successfully"));
    }

}
