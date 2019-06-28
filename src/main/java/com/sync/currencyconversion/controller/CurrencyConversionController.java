package com.sync.currencyconversion.controller;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sync.currencyconversion.client.CurrencyExchangeFeignClient;
import com.sync.currencyconversion.model.CurrencyConversion;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeFeignClient feignClient;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	private CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigInteger quantity) {

		Map<String, String> urlParams = new HashMap<String, String>();
		urlParams.put("from", from);
		urlParams.put("to", to);

		ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange-service/currency-exchange/from/{from}/to/{to}",
				CurrencyConversion.class, urlParams);

		CurrencyConversion response = responseEntity.getBody();

		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	private CurrencyConversion convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigInteger quantity) {
		
		CurrencyConversion response = feignClient.getExchangeValue(from, to);

		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

}
