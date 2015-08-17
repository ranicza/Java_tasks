//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.07 at 08:37:39 PM FET 
//


package com.epam.te.task04.entity_jaxb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Call_Prices complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Call_Prices">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="inside_network" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="outside_network" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="stationary_network" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Call_Prices")
public class CallPrices {

    @XmlAttribute(name = "inside_network", required = true)
    protected BigDecimal insideNetwork;
    @XmlAttribute(name = "outside_network", required = true)
    protected BigDecimal outsideNetwork;
    @XmlAttribute(name = "stationary_network", required = true)
    protected BigDecimal stationaryNetwork;

    /**
     * Gets the value of the insideNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInsideNetwork() {
        return insideNetwork;
    }

    /**
     * Sets the value of the insideNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInsideNetwork(BigDecimal value) {
        this.insideNetwork = value;
    }

    /**
     * Gets the value of the outsideNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOutsideNetwork() {
        return outsideNetwork;
    }

    /**
     * Sets the value of the outsideNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOutsideNetwork(BigDecimal value) {
        this.outsideNetwork = value;
    }

    /**
     * Gets the value of the stationaryNetwork property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getStationaryNetwork() {
        return stationaryNetwork;
    }

    /**
     * Sets the value of the stationaryNetwork property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setStationaryNetwork(BigDecimal value) {
        this.stationaryNetwork = value;
    }

}
