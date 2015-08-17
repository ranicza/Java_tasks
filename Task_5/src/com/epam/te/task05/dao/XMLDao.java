package com.epam.te.task05.dao;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import com.epam.te.task05.entity.Tariff;

public interface XMLDao {
	List<Tariff> parse(String resourceName) throws XMLDaoException, SAXException, IOException;
}
