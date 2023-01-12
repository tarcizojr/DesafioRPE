package br.tarcizo.desafio.rpe.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;


public interface PessoaFuncionarioRepository extends JpaRepository<PessoaFuncionario, Long> {

	
}
