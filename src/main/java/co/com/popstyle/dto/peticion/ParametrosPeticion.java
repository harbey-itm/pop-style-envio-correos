package co.com.popstyle.dto.peticion;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ParametrosPeticion {
	
	
	@JsonProperty("sender")
	private Sender sender;
	
	@JsonProperty("to")
	private To to;
	
	@JsonProperty("subject")
	private String subject;

	@JsonProperty("htmlContent")
	private String htmlContent;

}
