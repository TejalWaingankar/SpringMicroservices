package com.sync.currencyconversion.model;

import java.math.BigInteger;

public class CurrencyConversion {

	private int id;
	private String from;
	private String to;
	private BigInteger conversionMultiple;
	private BigInteger quantity;
	private BigInteger totalConversionValue;
	private int port;

	public CurrencyConversion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyConversion(int id, String from, String to, BigInteger conversionMultiple, BigInteger quantity,
			BigInteger totalConversionValue, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalConversionValue = totalConversionValue;
		this.port = port;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigInteger getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigInteger conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quantity) {
		this.quantity = quantity;
	}

	public BigInteger getTotalConversionValue() {
		return totalConversionValue;
	}

	public void setTotalConversionValue(BigInteger totalConversionValue) {
		this.totalConversionValue = totalConversionValue;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", totalConversionValue=" + totalConversionValue
				+ ", port=" + port + "]";
	}

}
