package com.example.obspringsecuritycifrado.repository;

import com.example.obspringsecuritycifrado.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}


