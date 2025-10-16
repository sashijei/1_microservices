package com.mercy.__currency_exchange_service;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CurrencyExchange {

	private final Long id;
	private final String from;
	private final String to;
	private final BigDecimal conversionMultiple;
}
