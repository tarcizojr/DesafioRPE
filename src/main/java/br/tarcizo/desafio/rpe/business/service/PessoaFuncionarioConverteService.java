package br.tarcizo.desafio.rpe.business.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaFuncionarioDTO;



@Service
public interface PessoaFuncionarioConverteService {
	public List<PessoaFuncionarioDTO> pessoaToDTOList(List<PessoaFuncionario> entities);
	public PessoaFuncionario dtoTopessoa(PessoaFuncionarioDTO dto) throws ParseException;
	public PessoaFuncionarioDTO pessoaToDTO(PessoaFuncionario entity);
}
