package br.tarcizo.desafio.rpe.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;



	public interface PessoaClienteRepository extends JpaRepository<PessoaCliente, Long> {
	}

