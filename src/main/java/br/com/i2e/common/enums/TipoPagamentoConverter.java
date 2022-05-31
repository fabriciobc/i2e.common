package br.com.i2e.common.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter( autoApply = true )
public class TipoPagamentoConverter implements AttributeConverter<TipoPagamento, String> {

	@Override
	public TipoPagamento convertToEntityAttribute( String relationalForm ) {
		
		return TipoPagamento.of( relationalForm );
	}

	@Override
	public String convertToDatabaseColumn( TipoPagamento domainForm ) {
		
		return domainForm.getCode();
	}
}