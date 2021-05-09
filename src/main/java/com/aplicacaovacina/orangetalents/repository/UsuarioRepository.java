package com.aplicacaovacina.orangetalents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aplicacaovacina.orangetalents.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByEmail(String email);
}
