package br.com.i2e.common.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoFrete {
	EMITENTE("E"), DESTINATARIO("D");
	
	private String code; 
	
	private TipoFrete( String code ) {
		this.code = code;
	}
	
	@JsonValue	
	public String getCode() { return code; }
	
	@JsonCreator
	public static TipoFrete of( String codigo ) {
		
		return Stream.of( values() )
				.filter( c -> c.getCode().equals( codigo ) )
				.findFirst()
				.orElseThrow( IllegalArgumentException::new );
	}
}
