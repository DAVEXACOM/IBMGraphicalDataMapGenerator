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

import com.ibm.dfdl.processor.IDFDLRegionHandler;
import com.ibm.dfdl.processor.exceptions.DFDLUserException;

/**
 * Example implementation of the DFDL IDFDLRegionHandler interface.
 * This simple implementation prints to stdout on each call.
 */

public class PrintRegionHandler implements IDFDLRegionHandler {

	/* parse and serialize region methods */
	
	public void elementStart(String name, String namespace, String scd, long startOffset, String encoding) throws DFDLUserException {
		System.out.println("RegionHandler : elementStart() '"+scd+"' at offset "+ startOffset);
	}
	
	public void elementEnd(String scd, long offset) throws DFDLUserException {
		System.out.println("RegionHandler : elementEnd() '"+scd+"' at offset "+ offset);
	}

	public void groupStart(String scd, long offset) throws DFDLUserException {
		System.out.println("RegionHandler : groupStart() '"+scd+"' at offset "+ offset);
	}
	
	public void groupEnd(String scd, long offset) throws DFDLUserException {
		System.out.println("RegionHandler : groupEnd() '"+scd+"' at offset "+ offset);
	}
	
	/* region methods */

	public void leadingAlignmentRegion(String scd, long startOffset, long length)	throws DFDLUserException {
		System.out.println("RegionHandler : leadingAlignmentRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}
	
	public void initiatorRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : initiatorRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}

	public void simpleContentRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : simpleContentRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}

	public void terminatorRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : terminatorRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}
	
	public void trailingAlignmentRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : trailingAlignmentRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}
	
	public void prefixSeparatorRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : separatorRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}
	
	public void infixSeparatorRegion(String scd, long startOffset, long length) throws DFDLUserException {
		System.out.println("RegionHandler : infixSeparatorRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}

	public void postfixSeparatorRegion(String scd, long startOffset, long length)	throws DFDLUserException {
		System.out.println("RegionHandler : postfixSeparatorRegion() '"+scd+"' at offset "+ startOffset + " length "+length);
	}



}
