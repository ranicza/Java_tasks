package com.epam.te.task05.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.epam.te.task05.entity.Tariff;
import com.epam.te.task05.entity.Operator;
import com.epam.te.task05.entity.Tariffing;;

public class TariffSAXHandler extends DefaultHandler{
	private List<Tariff> tariff_list = new ArrayList<Tariff>();
	private Tariff current_tariff;
	private StringBuilder text;
	
	public List<Tariff> getTariffList(){
		return this.tariff_list;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException{
		text = new StringBuilder();
		
		String tariff_info = TariffTagName.TARIFF_INFO.toString().toLowerCase();
		String call_prices = TariffTagName.CALL_PRICES.toString().toLowerCase();
		
		if (localName.equals(tariff_info)){
			current_tariff = new Tariff();
			current_tariff.setId(attrs.getValue(0));
		}
		if(localName.equals(call_prices)){
			current_tariff.setPriceInsideNetwork(Double.parseDouble(attrs.getValue(0)));
			current_tariff.setPriceOutsideNetwork(Double.parseDouble(attrs.getValue(1)));
			current_tariff.setPriceStationaryNetwork(Double.parseDouble(attrs.getValue(2)));
		}
	}
	
	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);	
	}
	
	
	public void endElement(String uri, String localName, String qName) throws SAXException{
		TariffTagName tagName = TariffTagName.valueOf(localName.toUpperCase());
			
		switch(tagName){
		case NAME:
			current_tariff.setName(text.toString());
			break;
		case OPERATOR_NAME:
			current_tariff.setOperatorName(Operator.valueOf(text.toString().toUpperCase()));
			break;
		case PAYROLL:
			current_tariff.setPayroll(Double.parseDouble(text.toString()));
			break;
		case SMS_PRICE:
			current_tariff.setSmsPrice(Double.parseDouble(text.toString()));
			break;
		case FAVOURITE_NUMBER:
			current_tariff.setFavouriteNumber(Integer.parseInt(text.toString()));
			break;
		case TARIFFING:
			current_tariff.setTariffing(Tariffing.valueOf(text.toString().toUpperCase()));
			break;
		case PRICE_FOR_CONNECTION:
			current_tariff.setPriceForConnection(Double.parseDouble(text.toString()));
			break;
		case PARAMETERS:
			break;
		case TARIFF_INFO:
			tariff_list.add(current_tariff);
			current_tariff = null;
			break;
		default:
			break;
		}
	}

}

