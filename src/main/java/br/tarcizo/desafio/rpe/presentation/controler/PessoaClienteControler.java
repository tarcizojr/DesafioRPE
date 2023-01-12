package br.tarcizo.desafio.rpe.presentation.controler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import br.tarcizo.desafio.rpe.business.service.PessoaClienteConverteService;
import br.tarcizo.desafio.rpe.business.service.PessoaClienteService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioConverteService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;
import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaClienteDTO;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaFuncionarioDTO;

@RestController
@RequestMapping("/api/pessoaCliente")
public class PessoaClienteControler {
	
	@Autowired
	private PessoaClienteConverteService converteService;
	
	@Autowired
	private PessoaClienteService clienteService;
	
	@Autowired
	private FuncaoService funcaoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody PessoaClienteDTO dto) throws ParseException {
		
		PessoaCliente entity = converteService.dtoTopessoa(dto);
		
			
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatter.parse(dto.getDataDoServico());
		
		entity.setDataDoServico(data);
		
		entity = clienteService.save(entity);
		
		dto = converteService.pessoaToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id, @RequestBody PessoaClienteDTO dto) throws ParseException {
		
		dto.setId(id);
		PessoaCliente entity = converteService.dtoTopessoa(dto);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatter.parse(dto.getDataDoServico());
		
		entity.setDataDoServico(data);
		
		entity = clienteService.update(entity);
		
		dto = converteService.pessoaToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
			clienteService.delete(id);			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity findByFilter (
				@RequestParam(value = "id", required = false) Long id,
				@RequestParam(value = "name", required = false) String nome,
				@RequestParam(value = "cpf", required = false) String cpf,
				@RequestParam(value = "endereco", required = false) String endereco,
				@RequestParam(value = "telefone", required = false) String telefone)
				{
				
		PessoaCliente filter = new PessoaCliente(nome, cpf, endereco, telefone, id);
			
					
			List<PessoaCliente> entities = (List<PessoaCliente>) clienteService.find(filter);
					
			List<PessoaClienteDTO> dtos = converteService.pessoaToDTOList(entities);
			
			return ResponseEntity.ok(dtos);
					
	}
	
	@GetMapping("/all")
	public List<PessoaCliente> findAll() throws Exception {

		List<PessoaCliente> result = (List<PessoaCliente>) clienteService.findAll();

		if (result.isEmpty()){
			throw new Exception("Lista Vazia");

		} else {
			return (List<PessoaCliente>) clienteService.findAll();	
		}
	}
	
	@GetMapping("/{id}")
	public PessoaCliente findById(@PathVariable("id") Long id) throws Exception {

		PessoaCliente result = clienteService.findById(id);

		if (result == null){
			throw new Exception("Cliente não econtrado");

		} else {
			return result;	
		}
	}

}
