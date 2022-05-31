package br.com.i2e.common.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum I2EStatus {
	SENT( 1, "Message Sent" ), PROCESSING( 2, "Processing on target" ), DELIVERED( 3, "Delivered to CORE"),  
	RECEIVED( 4, "Receiveide from target"),	PROCESSED( 5, "Processed" ), FAIL( 6, "FAIL" );
	
	private int code;
	private String description;
	
	private I2EStatus(int code, String description) {
		this.code = code;
		this.description = description;
	}
	
	@JsonCreator
	public static I2EStatus of( int codigo ) {
		if ( codigo == 0 ) {
			return null;
		}

		return Stream.of( values() )
				.filter( c -> c.getCode() ==  codigo )
				.findFirst()
				.orElseThrow( IllegalArgumentException::new );
	}
	
	@JsonValue
	public int getCode() { return code; }
	public String getDesccription() { return description; }
}