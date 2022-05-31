package br.com.i2e.common.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter( autoApply = true )
public class StatusVendaConverter implements AttributeConverter<StatusVenda, Integer> {

	@Override
	public StatusVenda convertToEntityAttribute( Integer relationalForm ) {
		
		return StatusVenda.of( relationalForm );
	}

	@Override
	public Integer convertToDatabaseColumn( StatusVenda domainForm ) {
		
		return domainForm.getCode();
	}

}
