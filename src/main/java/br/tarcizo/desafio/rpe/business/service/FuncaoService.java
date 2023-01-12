package br.tarcizo.desafio.rpe.business.service;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.Funcao;

@Service
public interface FuncaoService {

	public Funcao save(Funcao user);
	public Funcao update(Funcao user);
	public void delete(Long id);
	public Funcao findById(Long id);
	
	public Iterable<Funcao>findAll();
	public Iterable<Funcao>find(Funcao filter);
	
	
}
