package br.com.i2e.common.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.i2e.common.enums.I2EStatus;
import br.com.i2e.common.enums.I2EType;
import lombok.Data;

@Data
@Entity@Table( name = "i2e_message", schema = "i2e_core" )
public class I2EMessage {
	@Id
	@Column( name = "PK_ID" )
	@GeneratedValue( generator = "native" )
	private Long id;
	private String traceabilitycode;
	private LocalDateTime timestamp;
	private I2EType type;
	private I2EStatus status;
	
	// TODO add 'from' and 'to' attributes 
	
	@ManyToOne@JoinColumn( name = "fk_id_parent", foreignKey = @ForeignKey( name = "fk_id_parent") )
	private I2EMessage parent;
	/**
	 * Json list parameters {name, value}
	 */
	private String parameters;
	/**
	 * Json request payload acording by type
	 */
	private String request;
	/**
	 * Json response payload acording by type
	 */
	private String response;
	private String error;
	
	public static I2EMessage get() {

		var msg = new I2EMessage();
		msg.setTimestamp( LocalDateTime.now() );
		msg.setTraceabilitycode( UUID.randomUUID().toString() );
		
		return msg;
	}
	
	public static I2EMessage getChild( I2EMessage parent) {
		
		return I2EMessage.getChild( parent, parent.getType() );
	}
	
	public static I2EMessage getChild( I2EMessage parent, I2EType type) {

		var msg = I2EMessage.get();
		msg.setParent( parent );
		msg.setType( type );
		
		return msg;
	}
}