package br.tarcizo.desafio.rpe.business.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.tarcizo.desafio.rpe.model.entity.Funcao;
import br.tarcizo.desafio.rpe.presentation.dto.FuncaoDTO;

@Service
public interface FuncaoConverteService {
	public List<FuncaoDTO> funcaoToDTOList(List<Funcao> entities);
	public Funcao dtoTofuncao(FuncaoDTO dto);
	public FuncaoDTO funcaoToDTO(Funcao entity);
}
