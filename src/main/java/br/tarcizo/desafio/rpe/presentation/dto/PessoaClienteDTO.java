package br.tarcizo.desafio.rpe.presentation.dto;

public class PessoaClienteDTO {
	
	private Long id;
	private String nome;	
	private String cpf;	
	private String endereco;	
	private String telefone;
	private String dataDoServico;
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
	public String getDataDoServico() {
		return dataDoServico;
	}
	public void setDataDoServico(String dataDoServico) {
		this.dataDoServico = dataDoServico;
	}
	
	

}
