package br.com.i2e.common.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter( autoApply = true )
public class TipoFreteConverter implements AttributeConverter<TipoFrete, String> {

	@Override
	public TipoFrete convertToEntityAttribute( String relationalForm ) {
		
		return TipoFrete.of( relationalForm );
	}

	@Override
	public String convertToDatabaseColumn( TipoFrete domainForm ) {
		
		return domainForm.getCode();
	}
}