/**********************************************************************
* IBM Confidential
*
* OCO Source Materials
*
* (C) Copyright IBM Corp. 2012  All Rights Reserved.
*
* The source code for this program is not published or otherwise  
* divested of its trade secrets, irrespective of what has been 
* deposited with the U.S. Copyright Office.
**********************************************************************/
package com.ibm.dfdljaxb.gdmgen;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;


import javax.xml.datatype.XMLGregorianCalendar;

import com.ibm.dfdl.processor.IDFDLDocHandler;
import com.ibm.dfdl.processor.types.DFDLBOMType;
import com.ibm.dfdl.processor.types.DFDLSchemaType;
import com.ibm.dfdljaxb.gdmgen.IOMapModelMetaCSV;
import com.ibm.dfdljaxb.gdmgen.IOMapModelMetaCSV.FieldMapping;

/**
 * Example implementation of the DFDL IDFDLDocHandler interface.
 * 
 * This simple implementation prints to stdout on each call. A realistic use 
 * would build an appropriate data structure from the information received. 
 */

public class PrintDocHandler implements IDFDLDocHandler {
	
	
	//@PJ - static string values for the fields
	private static final String IOMapModelMetaCSV_s = "IOMapModelMetaCSV";
	private static final String GDMDef_s = "GDMDef";
	private static final String source_schema_s = "source_schema";
	private static final String source_message_s = "source_message";
	private static final String source_parser_s = "source_parser";
	private static final String target_schema_s = "target_schema";
	private static final String target_message_s = "target_message";
	private static final String target_parser_s = "target_parser";
	private static final String source_field_s = "source_field";
	private static final String target_field_s = "target_field";
	private static final String base_action_s = "base_action";
	private static final String assign_value_s = "assign_value";
	private static final String description_s = "description";
	
	String context = ""; //@PJ - This keeps a placeholder for the field we have just parsed.....
	
	
	String value = "";
		
	
	
	
	public IOMapModelMetaCSV csvModel;
	
	public PrintDocHandler(){
		// No implementation required
	}
	
	IOMapModelMetaCSV myCSV = null; //@PJ -  this is the JAXB model we will populate
	
	FieldMapping m = null;
	
	String myCSVvalue = null; //@DA
	
	public void elementValue(XMLGregorianCalendar value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}
	
	public IOMapModelMetaCSV getModel()
	{
		
		return this.csvModel;
	}

	
	public void elementValue(String value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
		System.out.println("@DA@ above was the value!");
//@DA		myCSV.gdmDef.setSourceSchema(value.toString());
//@DA		System.out.println("myCSV: elementValue("+myCSV.gdmDef.getSourceSchema()+")");
		myCSVvalue = value.toString();
		System.out.println("myCSV: elementValue("+myCSVvalue+")");		
		//@PJ - set field values based on the 'context' of the parse....
		switch (context){
		 case source_schema_s:
			 csvModel.gdmDef.setSourceSchema(value);
             break;
         case source_message_s:
        	 csvModel.gdmDef.setSourceMessage(value);
             break;
         case source_parser_s:
        	 csvModel.gdmDef.setSourceParser(value);
             break;
         case target_schema_s:
        	 csvModel.gdmDef.setTargetSchema(value);
             break;
         case target_message_s:
        	 csvModel.gdmDef.setTargetMessage(value);
             break;
         case target_parser_s:
        	 csvModel.gdmDef.setTargetParser(value);
             break; 
         case source_field_s:
        	 m.setSourceField(value);
             break;
         case target_field_s:
             m.setTargetField(value);
             break;
         case base_action_s:
             m.setBaseAction(value);
             break;
         case assign_value_s:
             m.setAssignValue(value);
             break;
         case description_s:
             m.setDescription(value);
             csvModel.fieldMapping.add(m); //@PJ This is the last field so add the mapping to the ArrayList
             break;
        
		
		}
		
		
	}

	
	public void elementValue(int value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Integer(value).toString()+")");
	}

	
	public void elementValue(long value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Long(value).toString()+")");
	}

	
	public void elementValue(short value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Short(value).toString()+")");
	}

	
	public void elementValue(BigDecimal value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}

	
	public void elementValue(BigInteger value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+value.toString()+")");
	}

	
	public void elementValue(float value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Float(value).toString()+")");
	}

	
	public void elementValue(double value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Double(value).toString()+")");
	}

	
	public void elementValue(boolean value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Boolean(value).toString()+")");
	}

	
	public void elementValue(byte value, DFDLSchemaType type) {
		System.out.println("DocHandler: elementValue("+ new Byte(value).toString()+")");
	}

	
	public void elementValue(byte[] value, DFDLSchemaType type) {		
		System.out.println("DocHandler: elementValue(" + new String(value).toString() +")");
	}
	
	
	public void elementNilValue() {
		System.out.println("DocHandler: elementValue is NIL");
	}

	
	public void endDocument(long byteOffset) {
		System.out.println("DocHandler: endDocument(" + byteOffset + ")");
	}

	
	public void endElement(long byteOffset) {
		System.out.println("DocHandler: endElement(" + byteOffset + ")");
	}

	
	public void startDocument(String dfdlVersion, String schema, DFDLBOMType unicodeByteOrderMark) {
		this.csvModel = new IOMapModelMetaCSV();
		
		
		System.out.println("DocHandler: startDocument("+dfdlVersion+", "+schema+", "+unicodeByteOrderMark+")");
		
	}	

	
	public void startElement(String name, String namespace, String elementSCD, long byteOffset) {
		
		//@PJ - The start Element event gives us a way to set the context for the next 'field value' event
		//@PJ - and to initialise the internal JAXB objects as necessary
		  switch (name) {
	         case IOMapModelMetaCSV_s:
	             csvModel.gdmDef = new IOMapModelMetaCSV.GDMDef();
	             csvModel.fieldMapping = new ArrayList<IOMapModelMetaCSV.FieldMapping>();
	             
	             break;
	         case source_schema_s:
	             context = source_schema_s;
	             break;
	         case source_message_s:
	             context = source_message_s;
	             break;
	         case source_parser_s:
	             context = source_parser_s;
	             break;
	         case target_schema_s:
	             context = target_schema_s;
	             break;
	         case target_message_s:
	             context = target_message_s;
	             break;
	         case source_field_s:
	        	 m = new FieldMapping(); //@PJ Source Field is the first field so create a new mapping
	             context = source_field_s;
	             break;
	         case target_field_s:
	             context = target_field_s;
	             break;
	         case base_action_s:
	             context = base_action_s;
	             break;
	         case assign_value_s:
	             context = assign_value_s;
	             break;
	         case description_s:
	             context = description_s;
	             break;
	         case target_parser_s:
	             context = target_parser_s;
	             break;
		  }
		
		System.out.println("DocHandler: startElement(name:'"+name+"' namespace:'"+namespace+"' offset:" + byteOffset + ")");
	}

}
