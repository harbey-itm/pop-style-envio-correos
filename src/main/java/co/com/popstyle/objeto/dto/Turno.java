package co.com.popstyle.objeto.dto;

import org.springframework.stereotype.Component;

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
public class Turno {
	
	private String nombresApellidos;
	private String fechaTurno;
	private String horaTurno;
	private String nombreServicio;
	private String nombreBarbero;

}
