package com.techelevator.services;

import com.techelevator.exception.DaoException;
import org.springframework.stereotype.Component;

import com.techelevator.model.CatFact;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestCatFactService implements CatFactService {

	private static final String API_URL = "https://cat-data.netlify.app/api/facts/random";
	private static final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CatFact getFact() {
		CatFact fact = null;
		try	{
			fact = restTemplate.getForObject(API_URL, CatFact.class);
		}
		catch (RestClientResponseException e) {
			throw new DaoException(e.toString());
		}

		return fact;
	}

}
