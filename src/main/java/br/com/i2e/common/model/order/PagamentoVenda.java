package br.com.i2e.common.model.order;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.i2e.common.enums.TipoPagamento;
import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "pagamento_venda" )
public class PagamentoVenda {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private TipoPagamento tipo;
	@ManyToOne@JoinColumn( name = "fk_id_venda", foreignKey = @ForeignKey ( name = "fk_id_venda" ) )
	private Venda venda;
	private BigDecimal valor;
	// TODO avaliar a necessidade de armazenar todas as parcelas
	@ManyToOne@JoinColumn( name = "fk_id_administradora_cartao", foreignKey = @ForeignKey ( name = "fk_id_administradora_cartao" ) )
	private AdministradoraCartao administradoraCartao;
	private BigDecimal valorParcelas;
	private int quantidadeParcelas;
	private String nsu;
	private String numeroCartao;
}
