package br.com.i2e.common.model.catalog;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data@AllArgsConstructor@NoArgsConstructor
@Entity@Table( name = "foto", schema = "i2e_core" )
public class Foto {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Integer id;
	private Integer posicao;
	private Boolean principal;
	private byte[] imagem;
	@ManyToOne@JoinColumn( name = "fk_id_produto", foreignKey = @ForeignKey( name = "fk_id_produto") )
	@JsonBackReference@ToString.Exclude
	private Produto produto;
}