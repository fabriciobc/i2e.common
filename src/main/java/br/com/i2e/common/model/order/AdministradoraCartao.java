package br.com.i2e.common.model.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "administradora_cartao" )
public class AdministradoraCartao {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private String codigo; 
	private String nome;
}
