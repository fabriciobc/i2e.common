package br.com.i2e.common.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoPagamento {
	BOLETO("B"), CARTAO_CREDITO("C"), CONTA_BANCARIA("CB"), CREDITO_CLIENTE("CR");
	
	private String code; 
	
	private TipoPagamento( String code ) {
		this.code = code;
	}
	
	@JsonValue	
	public String getCode() { return code; }
	
	@JsonCreator
	public static TipoPagamento of( String codigo ) {
		
		return Stream.of( values() )
				.filter( c -> c.getCode().equals( codigo ) )
				.findFirst()
				.orElseThrow( IllegalArgumentException::new );
	}
}
