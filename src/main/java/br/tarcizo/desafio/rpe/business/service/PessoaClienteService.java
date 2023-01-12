package br.tarcizo.desafio.rpe.business.service;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;

@Service
public interface PessoaClienteService  {
	
	public PessoaCliente save(PessoaCliente user);
	public PessoaCliente update(PessoaCliente user);
	public void delete(Long id);
	public PessoaCliente findById(Long id);
	
	public Iterable<PessoaCliente>findAll();
	public Iterable<PessoaCliente>find(PessoaCliente filter);
	
	


}
