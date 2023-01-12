package br.tarcizo.desafio.rpe.model.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;


@Entity
public class PessoaCliente extends Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private Date dataDoServico;	

	public PessoaCliente(String nome, String cpf, String endereco, String telefone, Long id) {
		super(nome, cpf, endereco, telefone);
		this.id = id;
		
	}
	
	public PessoaCliente() {
		super();
				
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataDoServico() {
		return dataDoServico;
	}

	public void setDataDoServico(Date dataDoServico) {
		this.dataDoServico = dataDoServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataDoServico, id);
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
		PessoaCliente other = (PessoaCliente) obj;
		return Objects.equals(dataDoServico, other.dataDoServico) && Objects.equals(id, other.id);
	}
	
	

}
