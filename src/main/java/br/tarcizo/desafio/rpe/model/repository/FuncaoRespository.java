package br.tarcizo.desafio.rpe.model.repository;


import br.tarcizo.desafio.rpe.model.entity.Funcao;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FuncaoRespository extends JpaRepository<Funcao, Long>  {

	

}
