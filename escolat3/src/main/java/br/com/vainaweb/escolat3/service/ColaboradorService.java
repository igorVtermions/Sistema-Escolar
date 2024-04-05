package br.com.vainaweb.escolat3.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	public List<ColaboradorModel> encontrarColaboradores() {
		return colaboradorRepository.findAll();
	}

	public Optional<ColaboradorModel> encontrarUmColaborador(Long id) {
		return colaboradorRepository.findById(id);
	}

	public String cadastarColaborador(DadosColaborador dados) {
		var colaborador = colaboradorRepository.findByCpf(dados.cpf());

		if (colaborador.isPresent()) {
			return "CPF ja cadastrado!";
		} else {
			colaboradorRepository.save(new ColaboradorModel(dados.nome(), dados.cpf(), dados.email(), dados.cargo()));
			return "Colaborador cadastrado com Sucesso!";
		}
	}
}
