package br.com.i2e.common.model.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data@NoArgsConstructor
@Entity@Table( name = "marca", schema = "i2e_core" )
public class Marca {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	Integer id;
	String codigo;
	String nome;
	@ManyToOne@JoinColumn( name = "fk_id_fabricante", foreignKey = @ForeignKey( name = "fk_id_fabricante" ) )
	Fabricante fabricante;
	
	public Marca( String codigo) {
		this( codigo, null );
	}
	
	public Marca( String codigo, String nome ) {
		this.codigo = codigo;
		this.nome = nome;
	}
}