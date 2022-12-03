package cl.infoclub.fsj.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.infoclub.fsj.modelo.Quote;
import cl.infoclub.fsj.service.IQuoteService;

//La linea a continuacion señala que es un servicio (Una implementacion de este)
@Service
public class QuoteServImpl implements IQuoteService { // Se implementa la Interfaz IQuoteService
	@Value("${endpoints.quote}") // Valor definido en la application.properties
	private String quoteEndpoint; // Variable tipo String, con valor de la anotacion "Value"
	private RestTemplate restTemplate; // Variable de Objeto: RestTemplate

	@Autowired
	public QuoteServImpl(RestTemplate restTemplate) { //constructor de la implementacion de servicio
		this.restTemplate = restTemplate;
	}

	@Override
	public Quote buscar() {
		
		return restTemplate.getForObject(quoteEndpoint, Quote.class); // Busca un objeto, pasandole una url "quoteEndpoint", con la clase Quote
	}

}
