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
 * Example implementation of the DFDL IDFDLTrace interface.
 * This simple implementation prints to stdout on each call.
 */

import com.ibm.dfdl.processor.trace.IDFDLTrace;
import com.ibm.dfdl.processor.trace.IDFDLUserTraceListener;

public class PrintTraceListener implements IDFDLUserTraceListener {

	public void info(IDFDLTrace traceItem) {
		System.out.println("TraceListener : info() "+traceItem.getMessage() );
	}

	public void warning(IDFDLTrace traceItem) {
		System.out.println("TraceListener : warning() "+traceItem.getMessage() );
	}
	
	public void error(IDFDLTrace traceItem) {
		System.out.println("TraceListener : error() "+traceItem.getMessage() );
	}
	
	public void fatal(IDFDLTrace traceItem) {
		System.out.println("TraceListener : fatal() "+traceItem.getMessage() );
	}


}
