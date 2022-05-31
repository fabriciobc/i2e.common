package br.com.i2e.common.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusVenda {
		RECEBIDO(1), PROCESSANDO_PAGAMENTO(2), EM_SEPARACAO(3), ENVIADO(4), ENTREGUE(5), CANCELADO(6);
	
	private int code; 
	
	private StatusVenda( int code ) {
		this.code = code;
	}
	
	@JsonValue	
	public int getCode() { return code; }
	
	@JsonCreator
	public static StatusVenda of( int codigo ) {
		if ( codigo == 0 ) {
			return null;
		}

		return Stream.of( values() )
				.filter( c -> c.getCode() ==  codigo )
				.findFirst()
				.orElseThrow( IllegalArgumentException::new );
	}
}