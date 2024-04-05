package br.com.vainaweb.escolat3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vainaweb.escolat3.dto.DadosColaborador;
import br.com.vainaweb.escolat3.model.ColaboradorModel;
import br.com.vainaweb.escolat3.repository.ColaboradorRepository;
import br.com.vainaweb.escolat3.service.ColaboradorService;

@RestController
@RequestMapping("/Colaborador-hello")
public class ColaboradorController {

	private ColaboradorService colaboradorService;

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@GetMapping
	public List<ColaboradorModel> encontrarColaboradores() {
		return colaboradorService.encontrarColaboradores();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ColaboradorModel> listarPorId(@PathVariable Long id) {
		return colaboradorRepository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@PostMapping
	public ResponseEntity<String> cadastrarColaborador(@RequestBody DadosColaborador dados) {

		String mensagemCadastro = colaboradorService.cadastarColaborador(dados);

		if (mensagemCadastro.equalsIgnoreCase("CPF ja cadastrado!")) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mensagemCadastro);
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(mensagemCadastro);
		}
	}
}
