package com.sync.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sync.currencyexchange.dao.CurrencyExchangeRepository;
import com.sync.currencyexchange.model.ExchangeValue;


@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@Autowired
	Environment env;

	@Autowired
	CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		logger.info("{}", exchangeValue.toString());
		return exchangeValue;
	}

}
