package br.tarcizo.desafio.rpe.presentation.dto;

import java.util.List;

public class PessoaFuncionarioDTO {

	private Long id;
	private String nome;	
	private String cpf;	
	private String endereco;	
	private String telefone;
	private List<String> idFuncao;
	private String nomeStatus;
	private String data;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<String> getIdFuncao() {
		return idFuncao;
	}
	public void setIdFuncao(List<String> idFuncao) {
		this.idFuncao = idFuncao;
	}
	public String getNomeStatus() {
		return nomeStatus;
	}
	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	

	
	
	
	
}
