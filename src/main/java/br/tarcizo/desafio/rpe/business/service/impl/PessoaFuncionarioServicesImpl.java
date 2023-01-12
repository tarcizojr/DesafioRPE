package br.tarcizo.desafio.rpe.business.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioService;
import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.model.repository.PessoaFuncionarioRepository;

@Service
public class PessoaFuncionarioServicesImpl implements PessoaFuncionarioService {

	@Autowired
	private PessoaFuncionarioRepository funcionarioRepository;
	
	@Override
	public PessoaFuncionario save(PessoaFuncionario user) {
		
		user.setStatus(Status.EM_ABERTO);
		return funcionarioRepository.save(user);
	}

	@Override
	public PessoaFuncionario update(PessoaFuncionario user) {
		PessoaFuncionario pessoa = findById(user.getId());
		pessoa.setCpf(user.getCpf());
		pessoa.setEndereco(user.getEndereco());		
		pessoa.setFuncao(user.getFuncao());
		pessoa.setNome(user.getNome());
		
		if(user.getStatus().equals("COMPLETO")) {
			pessoa.setStatus(Status.COMPLETO);
		}else {
			pessoa.setStatus(Status.EM_ABERTO);
		}
		
		pessoa.setTelefone(user.getTelefone());
		
		return funcionarioRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		PessoaFuncionario pessoa = findById(id);
		
		if(pessoa == null) {
			throw new IllegalStateException(String.format("Não foi encontrada pessoa com esse id=%1", 1));
		}
		
		funcionarioRepository.deleteById(id);
	}

	@Override
	public PessoaFuncionario findById(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id null");
		}
		return funcionarioRepository.findById(id).get();
	}

	@Override
	public Iterable<PessoaFuncionario> findAll() {
		return (ArrayList<PessoaFuncionario>) funcionarioRepository.findAll();
	}

	@Override
	public Iterable<PessoaFuncionario> find(PessoaFuncionario filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return funcionarioRepository.findAll(example);
	}

	

}
