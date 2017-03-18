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

/**
 * Example implementation of the DFDL IDFDLProcessorErrorHandler interface.
 * This simple implementation prints to stdout on each call.
 */

import com.ibm.dfdl.processor.IDFDLDiagnostic;
import com.ibm.dfdl.processor.IDFDLProcessorErrorHandler;

public class PrintErrorHandler implements IDFDLProcessorErrorHandler {
	
	public void processingError(IDFDLDiagnostic diagnostic) {
		System.out.println("ErrorHandler: processingError() " + diagnostic.getCodeAndSummary() );		
	}

	
	public void schemaDefinitionError(IDFDLDiagnostic diagnostic) {
		System.out.println("ErrorHandler: schemaDefinitionError() " + diagnostic.getCodeAndSummary() );		
	}

	
	public void validationError(IDFDLDiagnostic diagnostic) {
		System.out.println("ErrorHandler: validationError() " + diagnostic.getCodeAndSummary() );		
	}

	
	public void warning(IDFDLDiagnostic diagnostic) {
		System.out.println("ErrorHandler: warning() " + diagnostic.getCodeAndSummary() );		
	}

}
