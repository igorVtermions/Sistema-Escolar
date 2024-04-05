package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.enums.Cargo;
import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_colaboradores")
public class ColaboradorModel {
	
    public ColaboradorModel( String nome, String email, String cpf, Cargo cargo) {
		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cargo = cargo;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	 @Column(unique = true)
	private String email;
	 
	 @Column(unique = true)
	private String cpf; 
	private Cargo cargo;
	
	@Embedded 
	private Endereco endereco;
	
	public ColaboradorModel(DadosColaborador dados) {
		
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.email = dados.email();
		this.cargo = dados.cargo();
	}

}
