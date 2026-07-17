package br.com.criandoapi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.criandoapi.projeto.entities.Usuario;

@Repository
public interface IUsuario extends JpaRepository<Usuario, Integer> {

	public Usuario findByNomeOrEmail(String nome, String email);
	// CrudRepository<classe que irá utilizar, tipo do primary key>
	//Esta interface retorna Iterable como findAll
	
	// JpaRepository<Usuario, Integer>
	// Esta interface retorna uma List como findAll 
	
	boolean existsByNome(String nome);
	boolean existsByEmail(String email);
}
