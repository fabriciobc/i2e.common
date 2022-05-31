package br.com.i2e.common.model.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "endereco_entrega" )
public class EnderecoEntrega {
	
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
}
