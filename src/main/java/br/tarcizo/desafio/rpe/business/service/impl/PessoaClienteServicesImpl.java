package br.tarcizo.desafio.rpe.business.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.PessoaClienteService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioService;
import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.model.repository.PessoaClienteRepository;
import br.tarcizo.desafio.rpe.model.repository.PessoaFuncionarioRepository;

@Service
public class PessoaClienteServicesImpl implements PessoaClienteService {

	@Autowired
	private PessoaClienteRepository clienteRepository;
	
	@Override
	public PessoaCliente save(PessoaCliente user) {
		
		
		return clienteRepository.save(user);
	}

	@Override
	public PessoaCliente update(PessoaCliente user) {
		PessoaCliente pessoa = findById(user.getId());
		pessoa.setCpf(user.getCpf());
		pessoa.setEndereco(user.getEndereco());		
		pessoa.setNome(user.getNome());		
		pessoa.setTelefone(user.getTelefone());
		pessoa.setDataDoServico(user.getDataDoServico());
		
		return clienteRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		PessoaCliente pessoa = findById(id);
		
		if(pessoa == null) {
			throw new IllegalStateException(String.format("Não foi encontrada pessoa com esse id=%1", 1));
		}
		
		clienteRepository.deleteById(id);
	}

	@Override
	public PessoaCliente findById(Long id) {
		if(id == null) {
			throw new IllegalStateException("Id null");
		}
		return clienteRepository.findById(id).get();
	}

	@Override
	public Iterable<PessoaCliente> findAll() {
		return (ArrayList<PessoaCliente>) clienteRepository.findAll();
	}

	@Override
	public Iterable<PessoaCliente> find(PessoaCliente filter) {
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));

		return clienteRepository.findAll(example);
	}

	

}
