package br.com.i2e.common.util;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtils {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	private static Map<String, Object> paramsClass = new HashMap<String, Object>();
	
	static {
		mapper.registerModule( new JavaTimeModule() ) ;
	}
	
	private JsonUtils() {}
	
	public static String toJson( Object data ) throws JsonProcessingException {
		return mapper.writeValueAsString( data ); 
	}
	
	public static <T> T fromJson( String jsonMessage, Class<T> type ) {
		
		try {
			
			logger.debug( "Converting from Json : {}", jsonMessage );
			return mapper.readValue( jsonMessage, type );
		} catch ( JsonProcessingException e ) {
			
			logger.error( "Error on converting from Json: {}", jsonMessage, e );
		}
		
		return null;
	}
	
	public static String toJsonParameters( Object...params ) throws JsonProcessingException {

		if ( params.length % 2 > 0 ) {
			
			throw new IllegalArgumentException( "Número de parâmetros deve ser múltiplo de 2" );
		}
		
		var map = new HashMap<String, Object >();
		for ( int i = 0; i < params.length; i += 2 ) {
			map.put( (String) params[ i ] , params[ i + 1] );
		}
		
		return toJson( map );
	}
	
	public static Map<String, Object> fromJsonParameters( String jParams ) throws JsonProcessingException {
		
		return fromJson( jParams, paramsClass.getClass() );
	}
}