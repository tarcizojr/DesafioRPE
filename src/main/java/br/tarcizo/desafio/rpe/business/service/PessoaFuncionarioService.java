package br.tarcizo.desafio.rpe.business.service;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;

@Service
public interface PessoaFuncionarioService  {
	
	public PessoaFuncionario save(PessoaFuncionario user);
	public PessoaFuncionario update(PessoaFuncionario user);
	public void delete(Long id);
	public PessoaFuncionario findById(Long id);
	
	public Iterable<PessoaFuncionario>findAll();
	public Iterable<PessoaFuncionario>find(PessoaFuncionario filter);
	
	


}
