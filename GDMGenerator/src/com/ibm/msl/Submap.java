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
 * A <i>Submap</i> mapping allows for invoking a
 * <i>mappingDeclaration</i> to perform work for this mapping.
 * 
 * Has one or more <i>inputs</i> and one <i>output</i> defined on it.
 * 
 * <b>attributes</b>
 * <ul>
 * <li><i>ref</i>
 * The <i>ref</i> is the reference to the MappingDeclaration this submap is using. 
 * Note the value is a qualified name: the local name representing the name 
 * of the mapping declaration; and the prefix indicating the namespace where
 * the mapping declaration resides.</li>
 * </ul>
 *       
 * 
 * <p>Java class for Submap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Submap">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/2008/ccl/Mapping}Mapping">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}documentation" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}input" maxOccurs="unbounded"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}output"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}sort" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}test" minOccurs="0"/>
 *           &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}filter" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="ref" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Submap", propOrder = {
    "documentation",
    "input",
    "output",
    "sort",
    "test",
    "filter"
})
public class Submap
    extends Mapping
{

    protected Documentation documentation;
    @XmlElement(required = true)
    protected List<MappingDesignator> input;
    @XmlElement(required = true)
    protected MappingDesignator output;
    protected List<Sort> sort;
    protected Test test;
    protected Filter filter;
    @XmlAttribute(name = "ref")
    protected String ref;

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
     * Gets the value of the sort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Sort }
     * 
     * 
     */
    public List<Sort> getSort() {
        if (sort == null) {
            sort = new ArrayList<Sort>();
        }
        return this.sort;
    }

    /**
     * Gets the value of the test property.
     * 
     * @return
     *     possible object is
     *     {@link Test }
     *     
     */
    public Test getTest() {
        return test;
    }

    /**
     * Sets the value of the test property.
     * 
     * @param value
     *     allowed object is
     *     {@link Test }
     *     
     */
    public void setTest(Test value) {
        this.test = value;
    }

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link Filter }
     *     
     */
    public Filter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Filter }
     *     
     */
    public void setFilter(Filter value) {
        this.filter = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRef(String value) {
        this.ref = value;
    }

}
