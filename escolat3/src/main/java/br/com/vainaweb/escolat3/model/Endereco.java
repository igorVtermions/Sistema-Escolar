package br.com.vainaweb.escolat3.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Embeddable
public class Endereco {
	
	private String lougradourado;
	private int numero;
	private String complemento;
	private String bairro;
	private String ciadade;
	private String uf;
	private String cep;
}
