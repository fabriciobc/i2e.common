package br.com.i2e.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity@Table( name = "cliente", schema = "i2e_core" )
public class Cliente {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	Long id;
	String nome;
	String codigo;
	private String fantasia;
//	@Pattern( regexp = "[C,F,R]" )
	private Character tipo;
//	@Pattern( regexp = "[F,J]" )
	private Character fisicaJuridica;
	// 1, 2 ou 9 (Contribuinte, Isento ou Não contribuinte) TODO converter em enum
//	@Pattern( regexp = "[1,2,9]" )
	private Integer indicadorIE;
	@Size( min = 11, max = 14 )
	private String cpfCnpj;
	private String rg;
	private String ie;
	@Size( min = 8, max = 8 )
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
//	@Size( min = 2, max = 2 )
	private String uf;
	private String pais;
	private String telefone1;
	private String telefone2;
	private String fax;
	private String entregaCep;
	private String entregaEndereco;
	private String entregaNumero;
	private String entregaComplemento;
	private String entregaBairro;
	private String entregaCidade;
	private String entregaUf;
	private String entregaPais;
	private String entregaPontoRef1;
	private String entregaPontoRef2;
	private String faturamentoCep;
	private String faturamentoEndereco;
	private String faturamentoNumero;
	private String faturamentoComplemento;
	private String faturamentoBairro;
	private String faturamentoCidade;
	private String faturamentoUf;
	private String faturamentoPais;
	private String faturamentoPontoRef1;
	private String faturamentoPontoRef2;
}
