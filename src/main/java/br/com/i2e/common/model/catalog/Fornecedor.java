package br.com.i2e.common.model.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity@Table( name = "fornecedor", schema = "i2e_core" )
public class Fornecedor {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Integer id;
	private String nome;
	private String codigo;
}
