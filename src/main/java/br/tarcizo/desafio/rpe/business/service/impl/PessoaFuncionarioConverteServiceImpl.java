package br.tarcizo.desafio.rpe.business.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.PessoaFuncionarioConverteService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.model.entity.PessoaFuncionario;
import br.tarcizo.desafio.rpe.model.enums.Status;
import br.tarcizo.desafio.rpe.model.repository.FuncaoRespository;
import br.tarcizo.desafio.rpe.presentation.dto.PessoaFuncionarioDTO;

@Service
public class PessoaFuncionarioConverteServiceImpl implements PessoaFuncionarioConverteService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FuncaoRespository funcaoRespository;

	@Override
	public List<PessoaFuncionarioDTO> pessoaToDTOList(List<PessoaFuncionario> entities) {
		List<PessoaFuncionarioDTO> dtos = new ArrayList<>();
		
		for (PessoaFuncionario dto : entities) {
			PessoaFuncionarioDTO entity = pessoaToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	@Override
	public PessoaFuncionario dtoTopessoa(PessoaFuncionarioDTO dto) throws ParseException {
		
		Status status;
		if(dto.getNomeStatus() != null) {
			if(dto.getNomeStatus().equals("COMPLETO")) {
				status = Status.COMPLETO;
			}else {
				status = Status.EM_ABERTO;
			}
		}else {
			status = Status.EM_ABERTO;
		}
		List<Funcao> funcoes = new ArrayList<>();
		
		for (String funcao : dto.getIdFuncao()) {
			System.out.println(funcao);
			funcoes.add(funcaoRespository.findById(Long.parseLong(funcao)).get());
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formatter.parse(dto.getData());
		
		PessoaFuncionario entity = new PessoaFuncionario(dto.getNome(), dto.getCpf(), dto.getEndereco(), dto.getTelefone(), dto.getId(), funcoes.get(0), status, data);
		entity.setFuncao(funcoes);
		
		return entity;
	}

	@Override
	public PessoaFuncionarioDTO pessoaToDTO(PessoaFuncionario entity) {
		PessoaFuncionarioDTO dto = modelMapper.map(entity, PessoaFuncionarioDTO.class);
		dto.setNomeStatus(entity.getStatus().name());
		List<String> f = new ArrayList<String>();
		for (Funcao funcoes:  entity.getFuncao()) {
			f.add(String.valueOf(funcoes.getId()));
		}
		dto.setIdFuncao(f);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String data = formatter.format(entity.getDataDeContratacao());
		dto.setData(data);
		return dto;
	}

	
}
