//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.07 at 08:37:39 PM FET 
//


package com.epam.te.task04.entity_jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Tarrifing_type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="Tarrifing_type">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="from_first_second"/>
 *     &lt;enumeration value="from_twelve_second"/>
 *     &lt;enumeration value="from_first_minute"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Tarrifing_type")
@XmlEnum
public enum TarrifingType {

    @XmlEnumValue("from_first_second")
    FROM_FIRST_SECOND("from_first_second"),
    @XmlEnumValue("from_twelve_second")
    FROM_TWELVE_SECOND("from_twelve_second"),
    @XmlEnumValue("from_first_minute")
    FROM_FIRST_MINUTE("from_first_minute");
    private final String value;

    TarrifingType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TarrifingType fromValue(String v) {
        for (TarrifingType c: TarrifingType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
