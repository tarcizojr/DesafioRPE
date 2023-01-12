package br.tarcizo.desafio.rpe.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import br.tarcizo.desafio.rpe.model.enums.Status;

@Entity
public class PessoaFuncionario extends Pessoa{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToMany
	@JoinTable(name = "Pessoa_Funcao",
            joinColumns={@JoinColumn(name="Funcao_id")},
            inverseJoinColumns={@JoinColumn(name="PessoaF_id")})
	private List<Funcao> funcao = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private Status status = Status.EM_ABERTO;
	
	@NotNull
	private Date dataDeContratacao;	
	

	public PessoaFuncionario() {
		
	}


	public PessoaFuncionario(String nome, String cpf, String endereco, String telefone, Long id, Funcao funcao, Status status, 	Date dataDeContratacao) {
		super(nome, cpf, endereco, telefone);
		this.id = id;
		this.funcao.add(funcao);
		this.status = status;
		this.dataDeContratacao = dataDeContratacao;
	}
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public List<Funcao> getFuncao() {
		return funcao;
	}


	public void setFuncao(List<Funcao> funcao) {
		this.funcao = funcao;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	public Date getDataDeContratacao() {
		return dataDeContratacao;
	}


	public void setDataDeContratacao(Date date) {
		this.dataDeContratacao = date;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataDeContratacao, funcao, id, status);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFuncionario other = (PessoaFuncionario) obj;
		return Objects.equals(dataDeContratacao, other.dataDeContratacao) && Objects.equals(funcao, other.funcao)
				&& Objects.equals(id, other.id) && status == other.status;
	}
	
	
	
	
}
