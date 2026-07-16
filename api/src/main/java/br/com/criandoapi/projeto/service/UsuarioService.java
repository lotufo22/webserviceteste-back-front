package br.com.criandoapi.projeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.criandoapi.projeto.dto.UsuarioDto;
import br.com.criandoapi.projeto.entities.Usuario;
import br.com.criandoapi.projeto.repository.IUsuario;
import br.com.criandoapi.projeto.security.Token;
import br.com.criandoapi.projeto.security.TokenUtil;
import jakarta.validation.Valid;

@Service
public class UsuarioService {

	private IUsuario repository;
	
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
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
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		Usuario novoUsuario = repository.save(usuario);
		return novoUsuario;
	}
	
	public boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
		return true;
	}

	public boolean validarSenha(Usuario usuario) {
		String senha = repository.getReferenceById(usuario.getId()).getSenha();
		boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
		return valid;
	}

	public Token gerarToken(@Valid UsuarioDto usuario) {
		Usuario user = repository.findByNomeOrEmail(usuario.getNome(), usuario.getEmail());
		if(user != null) {
			boolean valid = passwordEncoder.matches(usuario.getSenha(), user.getSenha());
			if(valid) {
				return new Token(TokenUtil.createToken(user));
			}
		}
		return null;
	}
}
