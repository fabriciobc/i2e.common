package br.com.i2e.common.enums;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum I2EType {
	REFRESH_CATALOG_BY_PERIOD( 1, "" ), PRODUCT_DETAIL( 2, "" ), CUSTOMER_BY_PERIOD( 3 , ""), CUSTOMER_DETAIL( 4 , ""),
	BRANDS_BY_PERIOD( 5, "" ),	BRAND_DETAIL( 6, "" ), SEND_SALES_ORDER( 7, "" );
	private int code;
	private String description;
	
	private I2EType(int code, String description) {
		this.code = code;
		this.description = description;
	}
	@JsonCreator
	public static I2EType of( int codigo ) {
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