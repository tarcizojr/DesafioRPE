package br.tarcizo.desafio.rpe.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.business.service.FuncaoConverteService;
import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.presentation.dto.FuncaoDTO;
@Service
public class FuncaoConverteServicesImpl implements FuncaoConverteService {

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<FuncaoDTO> funcaoToDTOList(List<Funcao> entities) {
		List<FuncaoDTO> dtos = new ArrayList<>();
		
		for (Funcao dto : entities) {
			FuncaoDTO entity = funcaoToDTO(dto);
			dtos.add(entity);
		}
		return dtos;
	}

	@Override
	public Funcao dtoTofuncao(FuncaoDTO dto) {
		Funcao entity = modelMapper.map(dto, Funcao.class);
		return entity;
	}

	@Override
	public FuncaoDTO funcaoToDTO(Funcao entity) {
		FuncaoDTO dto = modelMapper.map(entity, FuncaoDTO.class);
		return dto;
	}
	
	
}
