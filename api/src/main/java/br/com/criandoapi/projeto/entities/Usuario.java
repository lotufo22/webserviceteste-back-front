package br.com.criandoapi.projeto.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Annotation de Lombok para os métodos especiais da classe
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Size(min = 3, max = 200, message = "Mínimo 3 e máximo 200 caracteres!")
	@NotBlank(message = "Nome obrigatório!")
	@Column(name = "nome", length = 200, nullable = false)
	private String nome;
	
	@Email(message = "Email inválido")
	@NotBlank(message = "Email obrigatório!")
	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@NotBlank(message = "Senha obrigatória!")
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
	private String senha;
	
	@NotBlank(message = "Telefone obrigatório!")
	@Column(name = "telefone", length = 15, nullable = false)
	private String telefone;
}
