//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.19 at 02:49:12 PM AEST 
//


package com.ibm.wesbBO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.ibm.com/xmlns/prod/websphere/wbiserver/map/6.0.0}customAssignment" minOccurs="0"/>
 *           &lt;element ref="{http://www.ibm.com/xmlns/prod/websphere/wbiserver/map/6.0.0}move" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="executionOrder" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customAssignment",
    "move"
})
@XmlRootElement(name = "propertyMap", namespace = "http://www.ibm.com/xmlns/prod/websphere/wbiserver/map/6.0.0")
public class PropertyMap {

    protected CustomAssignment customAssignment;
    protected Move move;
    @XmlAttribute(name = "executionOrder")
    protected String executionOrder;

    /**
     * Gets the value of the customAssignment property.
     * 
     * @return
     *     possible object is
     *     {@link CustomAssignment }
     *     
     */
    public CustomAssignment getCustomAssignment() {
        return customAssignment;
    }

    /**
     * Sets the value of the customAssignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomAssignment }
     *     
     */
    public void setCustomAssignment(CustomAssignment value) {
        this.customAssignment = value;
    }

    /**
     * Gets the value of the move property.
     * 
     * @return
     *     possible object is
     *     {@link Move }
     *     
     */
    public Move getMove() {
        return move;
    }

    /**
     * Sets the value of the move property.
     * 
     * @param value
     *     allowed object is
     *     {@link Move }
     *     
     */
    public void setMove(Move value) {
        this.move = value;
    }

    /**
     * Gets the value of the executionOrder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExecutionOrder() {
        return executionOrder;
    }

    /**
     * Sets the value of the executionOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExecutionOrder(String value) {
        this.executionOrder = value;
    }

}
