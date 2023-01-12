package br.tarcizo.desafio.rpe.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaClienteDTO;





@Service
public interface PessoaClienteConverteService {
	public List<PessoaClienteDTO> pessoaToDTOList(List<PessoaCliente> entities);
	public PessoaCliente dtoTopessoa(PessoaClienteDTO dto);
	public PessoaClienteDTO pessoaToDTO(PessoaCliente entity);
}
