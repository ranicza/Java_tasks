package com.epam.te.task05.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.epam.te.task05.entity.Operator;
import com.epam.te.task05.entity.Tariffing;
import com.epam.te.task05.dao.XMLDao;
import com.epam.te.task05.dao.XMLDaoException;
import com.epam.te.task05.entity.Tariff;
import com.sun.org.apache.xerces.internal.parsers.DOMParser;

public final class DomXmlDao  implements XMLDao{
	private final static String TARIFF_INFO =  "tns:tariff_info";
	private final static String ID = "id";
	private final static String NAME = "tns:name";
	private final static String OPERATOR = "tns:operator_name";
	private final static String PAYROLL = "tns:payroll";
	private final static String CALL_PRICES = "tns:call_prices";
	private final static String INSIDE = "inside_network";
	private final static String OUTSIDE = "outside_network";
	private final static String STATIONARY = "stationary_network";
	private final static String SMS_PRICE = "tns:sms_price";
	private final static String NUMBER = "tns:favourite_number";
	private final static String TARIFFING = "tns:tariffing";
	private final static String CONNECTION = "tns:price_for_connection";
	
	private final static DomXmlDao instance = new DomXmlDao();
	
	public static DomXmlDao getInstance(){
		return instance;
	}
	
	public List<Tariff> parse(String resourceName) throws XMLDaoException, SAXException, IOException{
		DOMParser parser = new DOMParser();
		
		parser.parse(resourceName);
		Document document = parser.getDocument();
		Element root = document.getDocumentElement();

		List<Tariff> tariff_list = new ArrayList<Tariff>();
		
		NodeList tariffNodes = root.getElementsByTagName(TARIFF_INFO);
		Tariff tariff = null;
		
		for (int i = 0; i < tariffNodes.getLength(); i++){
			tariff = new Tariff();
			Element tariffElement = (Element) tariffNodes.item(i);
			
			tariff.setId(tariffElement.getAttribute(ID));
			tariff.setName(getSingleChild(tariffElement,  NAME).getTextContent().trim());
			tariff.setOperatorName(Operator.valueOf(getSingleChild(tariffElement, OPERATOR).getTextContent().trim().toUpperCase()));
			tariff.setPayroll(Double.parseDouble(getSingleChild(tariffElement, PAYROLL).getTextContent().trim()));
			
			NamedNodeMap calls = root.getElementsByTagName(CALL_PRICES).item(i).getAttributes();
			
			tariff.setPriceInsideNetwork(Double.parseDouble(calls.getNamedItem(INSIDE).getNodeValue().trim()));
			tariff.setPriceOutsideNetwork(Double.parseDouble(calls.getNamedItem(OUTSIDE).getNodeValue().trim()));
			tariff.setPriceStationaryNetwork(Double.parseDouble(calls.getNamedItem(STATIONARY).getNodeValue().trim()));
			
			tariff.setSmsPrice(Double.parseDouble(getSingleChild(tariffElement, SMS_PRICE).getTextContent().trim()));
			tariff.setFavouriteNumber(Integer.parseInt(getSingleChild(tariffElement, NUMBER).getTextContent().trim()));
			tariff.setTariffing(Tariffing.valueOf(getSingleChild(tariffElement, TARIFFING).getTextContent().trim().toUpperCase()));
			tariff.setPriceForConnection(Double.parseDouble(getSingleChild(tariffElement, CONNECTION).getTextContent().trim()));
			
			tariff_list.add(tariff);
	
		}
		return tariff_list;

	}
	
	private static Element getSingleChild(Element element, String childName){
		NodeList nlist = element.getElementsByTagName(childName);
		Element child = (Element) nlist.item(0);
		return child;
	}

}
