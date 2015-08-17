package com.epam.te.task05.dao.impl;

public enum TariffTagName {
	NAME,
	OPERATOR_NAME,
	PAYROLL,
	CALL_PRICES,
	SMS_PRICE,
	FAVOURITE_NUMBER,
	TARIFFING,
	PRICE_FOR_CONNECTION,
	PARAMETERS,
	TARIFF_INFO,
	TARIFF;
	
	
	public static TariffTagName getElementTagName(String element){
		switch(element){
		case "tariff":
			return TARIFF;
		case "tariff_info":
			return TARIFF_INFO;
		case "name":
			return NAME;
		case "operator_name":
			return OPERATOR_NAME;
		case "payroll":
			return PAYROLL;
		case "call_prices":
			return CALL_PRICES;
		case "sms_price":
			return SMS_PRICE;
		case "parameters":
			return PARAMETERS;
		case "favourite_number":
			return FAVOURITE_NUMBER;
		case "tariffing":
			return TARIFFING;
		case "price_for_connection":
			return PRICE_FOR_CONNECTION;
		default:
			throw new EnumConstantNotPresentException(TariffTagName.class, element);
		}
		
	}
}

