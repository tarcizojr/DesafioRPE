package br.tarcizo.desafio.rpe.business.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.PessoaClienteConverteService;
import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioConverteService;
import br.tarcizo.desafio.rpe.model.entity.PessoaCliente;
import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaClienteDTO;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaClienteDTO;

@Service
public class PessoaClienteConverteServiceImpl implements PessoaClienteConverteService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PessoaClienteDTO> pessoaToDTOList(List<PessoaCliente> entities) {
		List<PessoaClienteDTO> dtos = new ArrayList<>();
		
		for (PessoaCliente dto : entities) {
			PessoaClienteDTO entity = pessoaToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	@Override
	public PessoaCliente dtoTopessoa(PessoaClienteDTO dto) {
		PessoaCliente entity = new PessoaCliente(dto.getNome(), dto.getCpf(), dto.getEndereco(), dto.getTelefone(), dto.getId());
		
		return entity;
	}

	@Override
	public PessoaClienteDTO pessoaToDTO(PessoaCliente entity) {
		PessoaClienteDTO dto = modelMapper.map(entity, PessoaClienteDTO.class);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatter.format(entity.getDataDoServico());
		dto.setDataDoServico(data);
		return dto;
	}

	
}
