package br.com.vainaweb.escolat3.model;

import br.com.vainaweb.escolat3.enums.Curso;
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
@Table(name = "tb_alunos")
public class AlunoModel {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

 	private String nome;
 	
 	@Column(unique = true)
    private String email;
 	
    @Column(unique = true)
    private String cpf;
    
    private Curso curso;
    
    private String telefone;
    
    @Embedded
    private Endereco endereco;
	    
	    
	    
}
