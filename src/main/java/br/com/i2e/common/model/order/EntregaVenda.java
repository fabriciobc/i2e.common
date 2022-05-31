package br.com.i2e.common.model.order;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.i2e.common.enums.TipoFrete;
import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "entrega_venda" )
public class EntregaVenda {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private LocalDate data;
	private BigDecimal valor;
	private BigDecimal pesoBruto;
	private BigDecimal pesoLiquido;
	private BigDecimal volume;
	@ManyToOne@JoinColumn( name = "fk_id_transportadora", foreignKey = @ForeignKey ( name = "fk_id_transportadora" ) )
	private Transportadora transportadora;
	private TipoFrete tipoFrete;
	private Boolean somaNota;
	@ManyToOne@JoinColumn( name = "fk_id_endereco_entrega", foreignKey = @ForeignKey ( name = "fk_id_endereco_entrega" ) )
	private EnderecoEntrega endereco;	
}
