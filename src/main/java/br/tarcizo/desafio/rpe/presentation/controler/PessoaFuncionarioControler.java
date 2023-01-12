package br.tarcizo.desafio.rpe.presentation.controler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.tarcizo.desafio.rpe.business.service.FuncaoService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioConverteService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaFuncionarioDTO;

@RestController
@RequestMapping("/api/pessoaFuncionario")
public class PessoaFuncionarioControler {
	
	@Autowired
	private PessoaFuncionarioConverteService converteService;
	
	@Autowired
	private PessoaFuncionarioService funcionarioService;
	
	@Autowired
	private FuncaoService funcaoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody PessoaFuncionarioDTO dto) throws ParseException {
		
		PessoaFuncionario entity = converteService.dtoTopessoa(dto);
		
		List<Funcao> funcao = new ArrayList<>();
		funcao.add(funcaoService.findById(Long.parseLong(dto.getIdFuncao().get(0))));
		
		entity.setFuncao(funcao);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatter.parse(dto.getData());
		
		entity.setDataDeContratacao(data);
		
		entity = funcionarioService.save(entity);
		
		dto = converteService.pessoaToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PessoaFuncionarioDTO dto) throws ParseException {
		
		dto.setId(id);
		PessoaFuncionario entity = converteService.dtoTopessoa(dto);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatter.parse(dto.getData());
		
		entity.setDataDeContratacao(data);
		entity = funcionarioService.update(entity);
		
		dto = converteService.pessoaToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
			funcionarioService.delete(id);			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/all")
	public List<PessoaFuncionario> findAll() throws Exception {

		List<PessoaFuncionario> result = (List<PessoaFuncionario>) funcionarioService.findAll();

		if (result.isEmpty()){
			throw new Exception("Lista Vazia");

		} else {
			return (List<PessoaFuncionario>) funcionarioService.findAll();	
		}
	}
	
	@GetMapping("/{id}")
	public PessoaFuncionario findById(@PathVariable("id") Long id) throws Exception {

		PessoaFuncionario result = funcionarioService.findById(id);

		if (result == null){
			throw new Exception("Funcionario não econtrado");

		} else {
			return result;	
		}
	}

}
