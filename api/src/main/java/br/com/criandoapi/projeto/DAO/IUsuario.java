package br.com.criandoapi.projeto.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.criandoapi.projeto.entities.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario, Integer> {
	// CrudRepository<classe que irá utilizar, tipo do primary key>
	//Esta interface retorna Iterable como findAll
	
	// JpaRepository<Usuario, Integer>
	// Esta interface retorna uma List como findAll 
	

}
