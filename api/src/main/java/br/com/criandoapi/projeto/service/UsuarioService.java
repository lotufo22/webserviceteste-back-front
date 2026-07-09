package br.com.criandoapi.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.entities.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;

@Service
public class UsuarioService {

	private IUsuario repository;
	
	public UsuarioService(IUsuario repository) {
		this.repository = repository;
	}
	
	public List<Usuario> listarUsuarios(){
		List<Usuario> lista = repository.findAll();
		return lista;
	}
	
	public Usuario encontrarUsuarioPorId(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.get();
	}
	
	public Usuario salvarUsuario(Usuario usuario) {
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}
}
