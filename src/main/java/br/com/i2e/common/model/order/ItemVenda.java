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

import br.com.i2e.common.model.catalog.Cor;
import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "item_venda" )
public class ItemVenda {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private String codigoSku;
	@ManyToOne@JoinColumn( name = "fk_id_cor", foreignKey = @ForeignKey( name = "id_cor_fk" ) )
	private Cor cor;
	private int quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorDesconto;
	@ManyToOne@JoinColumn( name = "fk_id_venda", foreignKey = @ForeignKey( name = "id_venda_fk")  )
	private Venda venda;
}
