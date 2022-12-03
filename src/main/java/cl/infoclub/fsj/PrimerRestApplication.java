package cl.infoclub.fsj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.infoclub.fsj.modelo.Quote;
import cl.infoclub.fsj.service.IQuoteService;

@SpringBootApplication
public class PrimerRestApplication {

	public static void main(String[] args) { //Main, donde se ejecuta el proyecto
		SpringApplication.run(PrimerRestApplication.class, args);
	}

	private static final Logger logger = LoggerFactory.getLogger(PrimerRestApplication.class); //logger de la class PrimerRestApplication
	private ObjectMapper mapper = new ObjectMapper(); //Mapeo de los objetos
	@Autowired
	private IQuoteService objQuoteService; //Llamada e inyeccion de una interfaz para funciones

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(); //Plantilla de transferencia de estado representativo
	}

	@Bean
	public CommandLineRunner run() throws Exception {
		return args -> {
			Quote quote = objQuoteService.buscar(); //Uso de la funcion "buscar" de la interfaz inyectada
			logger.info(mapper.writeValueAsString(quote)); //Escribe valor a String, del objeto quote
		};
	}

}
