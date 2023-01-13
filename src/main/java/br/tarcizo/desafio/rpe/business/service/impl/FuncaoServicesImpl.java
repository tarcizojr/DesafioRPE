package br.tarcizo.desafio.rpe.business.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.FuncaoService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.model.repository.FuncaoRespository;

@Service
public class FuncaoServicesImpl implements FuncaoService {
	
	@Autowired
	private FuncaoRespository funcaoRespository;
	
	
	@Override
	public Funcao save(Funcao entity) {
		
		return funcaoRespository.save(entity);
	}

	@Override
	public Funcao update(Funcao entity) {
		Funcao funcao = findById(entity.getId());
		funcao.setNome(entity.getNome());
		return funcaoRespository.save(funcao);
	}

	@Override
	public void delete(Long id) {
		Funcao pessoa = findById(id);
		
		if(pessoa == null) {
			throw new IllegalStateException(String.format("Não foi encontrada funcao com esse id=%1", 1));
		}
		
		funcaoRespository.deleteById(id);
		
	}

	@Override
	public Funcao findById(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id null");
		}
		return funcaoRespository.findById(id).get();
	}

	@Override
	public Iterable<Funcao> findAll() {
		return (ArrayList<Funcao>) funcaoRespository.findAll();
	}

	@Override
	public Iterable<Funcao> find(Funcao filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return funcaoRespository.findAll(example);
	}

	

}
