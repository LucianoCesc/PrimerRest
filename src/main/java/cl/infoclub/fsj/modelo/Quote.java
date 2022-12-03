package cl.infoclub.fsj.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Quote {
	//Objeto modelo con atributos: type (String) y value (Objeto: Value) 
	private String type;
	private Value value;
}
