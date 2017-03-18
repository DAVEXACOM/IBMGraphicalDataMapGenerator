//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.28 at 01:32:25 PM AEDT 
//


package com.ibm.msl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * A <i>Join</i> is an Mapping that joins data from two or more
 * different repeatable source nodes into a single repeatable target node.
 *       
 * 
 * <p>Java class for Join complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Join">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.ibm.com/2008/ccl/Mapping}Mapping">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}documentation" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}input" maxOccurs="unbounded" minOccurs="2"/>
 *         &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}output" maxOccurs="unbounded"/>
 *         &lt;choice>
 *           &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}test" minOccurs="0"/>
 *           &lt;element ref="{http://www.ibm.com/2008/ccl/Mapping}filter" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;group ref="{http://www.ibm.com/2008/ccl/Mapping}nested" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Join", propOrder = {
    "documentation",
    "input",
    "output",
    "test",
    "filter",
    "nested"
})
public class Join
    extends Mapping
{

    protected Documentation documentation;
    @XmlElement(required = true)
    protected List<MappingDesignator> input;
    @XmlElement(required = true)
    protected List<MappingDesignator> output;
    protected Test test;
    protected Filter filter;
    @XmlElementRefs({
        @XmlElementRef(name = "custom", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "insert", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "update", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "select", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "delete", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "remove", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lookup", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "task", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "create", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "join", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "transaction", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "submap", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "foreach", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "local", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "if", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "move", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "condition", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "expression", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "passthrough", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "append", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "group", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "convert", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "customFunction", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "assign", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "function", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "rdbcall", namespace = "http://www.ibm.com/2008/ccl/Mapping", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> nested;

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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the output property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MappingDesignator }
     * 
     * 
     */
    public List<MappingDesignator> getOutput() {
        if (output == null) {
            output = new ArrayList<MappingDesignator>();
        }
        return this.output;
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
     * Gets the value of the nested property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nested property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNested().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Custom }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * {@link JAXBElement }{@code <}{@link Remove }{@code >}
     * {@link JAXBElement }{@code <}{@link Lookup }{@code >}
     * {@link JAXBElement }{@code <}{@link Task }{@code >}
     * {@link JAXBElement }{@code <}{@link Create }{@code >}
     * {@link JAXBElement }{@code <}{@link Join }{@code >}
     * {@link JAXBElement }{@code <}{@link Transaction }{@code >}
     * {@link JAXBElement }{@code <}{@link Submap }{@code >}
     * {@link JAXBElement }{@code <}{@link Foreach }{@code >}
     * {@link JAXBElement }{@code <}{@link Local }{@code >}
     * {@link JAXBElement }{@code <}{@link If }{@code >}
     * {@link JAXBElement }{@code <}{@link Move }{@code >}
     * {@link JAXBElement }{@code <}{@link Condition }{@code >}
     * {@link JAXBElement }{@code <}{@link Expression }{@code >}
     * {@link JAXBElement }{@code <}{@link Passthrough }{@code >}
     * {@link JAXBElement }{@code <}{@link Append }{@code >}
     * {@link JAXBElement }{@code <}{@link Group }{@code >}
     * {@link JAXBElement }{@code <}{@link Convert }{@code >}
     * {@link JAXBElement }{@code <}{@link CustomFunction }{@code >}
     * {@link JAXBElement }{@code <}{@link Assign }{@code >}
     * {@link JAXBElement }{@code <}{@link Function }{@code >}
     * {@link JAXBElement }{@code <}{@link DatabaseMapping }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getNested() {
        if (nested == null) {
            nested = new ArrayList<JAXBElement<?>>();
        }
        return this.nested;
    }

}
