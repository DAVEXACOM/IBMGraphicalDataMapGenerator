//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A <i>Lookup</i> represents domain extension logic to be used to perform this mapping.
 *       
 * 
 * <p>Java class for Lookup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Lookup">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/2008/ccl/Mapping}Mapping">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}documentation" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}input" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}output"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}code" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="LookupEngineCustomPropertiesKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="LookupPropertyEngineUniqueKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Lookup", propOrder = {
    "documentation",
    "input",
    "output",
    "code"
})
public class Lookup
    extends Mapping
{

    protected Documentation documentation;
    protected List<MappingDesignator> input;
    @XmlElement(required = true)
    protected MappingDesignator output;
    protected Code code;
    @XmlAttribute(name = "LookupEngineCustomPropertiesKey")
    protected String lookupEngineCustomPropertiesKey;
    @XmlAttribute(name = "LookupPropertyEngineUniqueKey")
    protected String lookupPropertyEngineUniqueKey;

    /**
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link Documentation }
     *     
     */
    public Documentation getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Documentation }
     *     
     */
    public void setDocumentation(Documentation value) {
        this.documentation = value;
    }

    /**
     * Gets the value of the input property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the input property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MappingDesignator }
     * 
     * 
     */
    public List<MappingDesignator> getInput() {
        if (input == null) {
            input = new ArrayList<MappingDesignator>();
        }
        return this.input;
    }

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link MappingDesignator }
     *     
     */
    public MappingDesignator getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link MappingDesignator }
     *     
     */
    public void setOutput(MappingDesignator value) {
        this.output = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link Code }
     *     
     */
    public Code getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link Code }
     *     
     */
    public void setCode(Code value) {
        this.code = value;
    }

    /**
     * Gets the value of the lookupEngineCustomPropertiesKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookupEngineCustomPropertiesKey() {
        return lookupEngineCustomPropertiesKey;
    }

    /**
     * Sets the value of the lookupEngineCustomPropertiesKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookupEngineCustomPropertiesKey(String value) {
        this.lookupEngineCustomPropertiesKey = value;
    }

    /**
     * Gets the value of the lookupPropertyEngineUniqueKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLookupPropertyEngineUniqueKey() {
        return lookupPropertyEngineUniqueKey;
    }

    /**
     * Sets the value of the lookupPropertyEngineUniqueKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLookupPropertyEngineUniqueKey(String value) {
        this.lookupPropertyEngineUniqueKey = value;
    }

}