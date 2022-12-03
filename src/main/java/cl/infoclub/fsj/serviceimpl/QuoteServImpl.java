package cl.infoclub.fsj.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.infoclub.fsj.modelo.Quote;
import cl.infoclub.fsj.service.IQuoteService;

@Service
public class QuoteServImpl implements IQuoteService {
	@Value("${endpoints.quote}")
	private String quoteEndpoint;
	private RestTemplate restTemplate;
	@Autowired
	public QuoteServImpl(RestTemplate restTemplate) {
	this.restTemplate = restTemplate;
	}

	@Override
	public Quote buscar() {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(quoteEndpoint, Quote.class);
	}

}
