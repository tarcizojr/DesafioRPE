package br.tarcizo.desafio.rpe.presentation.controler;

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

import br.tarcizo.desafio.rpe.business.service.FuncaoConverteService;
import br.tarcizo.desafio.rpe.business.service.FuncaoService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.presentation.dto.FuncaoDTO;

@RestController
@RequestMapping("/api/funcao")
public class FuncaoControler {

	@Autowired
	private FuncaoConverteService converteService;
	
	@Autowired
	private FuncaoService funcaoService;
	
	@PostMapping
	public ResponseEntity save(@RequestBody FuncaoDTO dto) {
		Funcao entity = converteService.dtoTofuncao(dto);
		entity = funcaoService.save(entity);
		
		dto = converteService.funcaoToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	private ResponseEntity update(@PathVariable("id") Long id, @RequestBody FuncaoDTO dto) {
		dto.setId(id);
		Funcao entity = converteService.dtoTofuncao(dto);
		entity = funcaoService.update(entity);
		
		dto = converteService.funcaoToDTO(entity);
		
		return new ResponseEntity(dto, HttpStatus.CREATED);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id) {
		
			funcaoService.delete(id);			
			return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity findByFilter (
				@RequestParam(value = "id", required = false) Long id,
				@RequestParam(value = "nome", required = false) String nome)
				 {
				
			Funcao filter = new Funcao();
			filter.setId(id);
			filter.setNome(nome);
			
			
			List<Funcao> entities = (List<Funcao>) funcaoService.find(filter);
					
			List<FuncaoDTO> dtos = converteService.funcaoToDTOList(entities);
			
			return ResponseEntity.ok(dtos);
					
	}
	
	@GetMapping("/all")
	public List<Funcao> findAll() throws Exception {

		List<Funcao> result = (List<Funcao>) funcaoService.findAll();

		
		return result;	
		
	}
	
	@GetMapping("/{id}")
	public Funcao findById(@PathVariable("id") Long id) throws Exception {

		Funcao result = funcaoService.findById(id);

		if (result == null){
			throw new Exception("Função não encontrada");

		} else {
			return result;	
		}
	}
}
