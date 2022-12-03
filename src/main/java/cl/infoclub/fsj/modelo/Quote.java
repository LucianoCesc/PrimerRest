package cl.infoclub.fsj.modelo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Quote {

	private String type;
	private Value value;
}
