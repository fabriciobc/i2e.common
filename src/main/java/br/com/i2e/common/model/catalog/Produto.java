package br.com.i2e.common.model.catalog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "produto" )
public class Produto {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Integer id;
	private LocalDate dataCadastro;
	private String nome;
	private String descricao;
	private String descricaoResumida;
	private String codigoSKU;
	private String codigoBarras;
	// em quilogramas
	private BigDecimal peso;
	private String ncm;
	// em centímetros
	private BigDecimal comprimento;
	// em centímetros
	private BigDecimal altura;
	// em centímetros
	private BigDecimal largura;
	@ManyToOne@JoinColumn( name = "fk_id_marca", foreignKey = @ForeignKey( name = "fk_id_marca") )
	private Marca marca;
	@ManyToOne@JoinColumn( name = "fk_id_fornecedor", foreignKey = @ForeignKey( name = "fk_id_fornecedor") )
	private Fornecedor fornecedor;
	@JsonManagedReference
	@OneToMany( mappedBy = "produto", cascade = CascadeType.ALL )
	List<Foto> fotos;
}
