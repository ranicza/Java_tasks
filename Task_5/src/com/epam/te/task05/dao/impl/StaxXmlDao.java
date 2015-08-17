package com.epam.te.task05.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.xml.sax.SAXException;

import com.epam.te.task05.dao.XMLDao;
import com.epam.te.task05.dao.XMLDaoException;
import com.epam.te.task05.entity.Tariff;
import com.epam.te.task05.entity.Operator;
import com.epam.te.task05.entity.Tariffing;;

public final class StaxXmlDao implements XMLDao{
	private final static String ID = "id";
	private final static String INSIDE = "inside_network";
	private final static String OUTSIDE = "outside_network";
	private final static String STATIONARY = "stationary_network";
	
	private final static StaxXmlDao instance = new StaxXmlDao();
	
	public static StaxXmlDao getInstance(){
		return instance;
	}
	
	public List<Tariff> parse(String resourceName) throws XMLDaoException, SAXException, IOException{
		XMLInputFactory inputFactory  = XMLInputFactory.newInstance();
		List<Tariff> tariff_list = null;

		try{
			InputStream input = new FileInputStream(resourceName);
			
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			tariff_list = process(reader);
			
		}catch(XMLStreamException e){
			e.printStackTrace();
		}
		return tariff_list;
	}
	
	
	
	private static List<Tariff> process (XMLStreamReader reader) throws XMLStreamException{
		
		List<Tariff> tariff_list = new ArrayList<Tariff>();
		Tariff tariff = null;
		TariffTagName elementName = null;
		
		while(reader.hasNext()){
			int type = reader.next();

			switch(type){
			case XMLStreamConstants.START_ELEMENT:
				elementName = TariffTagName.getElementTagName(reader.getLocalName());

				switch(elementName){
				case TARIFF:
					break;
				case TARIFF_INFO:
					tariff = new Tariff();
					String id = reader.getAttributeValue(null, ID);
					tariff.setId(id);
					break;
				case CALL_PRICES:
					double inside = Double.parseDouble(reader.getAttributeValue(null, INSIDE));
					double outside = Double.parseDouble(reader.getAttributeValue(null, OUTSIDE));
					double stationary = Double.parseDouble(reader.getAttributeValue(null, STATIONARY));
					
					tariff.setPriceInsideNetwork(inside);
					tariff.setPriceOutsideNetwork(outside);
					tariff.setPriceStationaryNetwork(stationary);
					break;
				default:
					break;
				}
				break;
				
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				
				if (text.isEmpty()){
					break;
				}
				switch(elementName){
				
				case NAME:
					tariff.setName(text);
					break;
				case OPERATOR_NAME:
					tariff.setOperatorName(Operator.valueOf(text.toUpperCase()));
					break;
				case PAYROLL:
					tariff.setPayroll(Double.parseDouble(text));
					break;
				case SMS_PRICE:
					tariff.setSmsPrice(Double.parseDouble(text));
					break;
				case FAVOURITE_NUMBER:
					tariff.setFavouriteNumber(Integer.parseInt(text));
					break;
				case TARIFFING:
					tariff.setTariffing(Tariffing.valueOf(text.toUpperCase()));
					break;
				case PRICE_FOR_CONNECTION:
					tariff.setPriceForConnection(Double.parseDouble(text));
					break;
				case PARAMETERS:
					break;
				default:
					break;
				}
				break;
			
			case XMLStreamConstants.END_ELEMENT:
				elementName = TariffTagName.getElementTagName(reader.getLocalName());
				
				switch(elementName){
				case TARIFF_INFO:
					tariff_list.add(tariff);
				default:
					break;
				}			
			}
		}
		return tariff_list;
		
	}
}
