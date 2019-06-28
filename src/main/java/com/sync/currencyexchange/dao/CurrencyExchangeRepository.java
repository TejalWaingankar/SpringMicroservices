package com.sync.currencyexchange.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sync.currencyexchange.model.ExchangeValue;

public interface CurrencyExchangeRepository extends JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
