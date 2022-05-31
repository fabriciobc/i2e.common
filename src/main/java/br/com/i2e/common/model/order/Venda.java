package br.com.i2e.common.model.order;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.i2e.common.enums.StatusVenda;
import lombok.Data;

@Data
@Entity@Table( schema = "i2e_core", name = "venda" )
public class Venda {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private String numero;
	private LocalDateTime criado;
	private LocalDateTime atualizado;
	private StatusVenda status;
	@OneToMany( mappedBy = "venda" )
	private List<ItemVenda> itens;
	@OneToMany( mappedBy = "venda" )
	private List<PagamentoVenda> pagamentos;
	@ManyToOne@JoinColumn( name = "fk_id_entrega_venda", foreignKey = @ForeignKey ( name = "fk_id_entrega_venda" ) )
	private EntregaVenda entrega;
}