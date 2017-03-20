package com.ibm.dfdljaxb.gdmgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.io.ByteArrayOutputStream;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;

import com.ibm.msl.Cast;
import com.ibm.msl.Documentation;
import com.ibm.msl.Generation;
import com.ibm.msl.Import;
import com.ibm.msl.Imports;
import com.ibm.msl.MappingDeclaration;
import com.ibm.msl.MappingDesignator;
import com.ibm.msl.MappingRoot;
import com.ibm.msl.Move;
import com.ibm.msl.Assign;
import com.ibm.msl.Function;
import com.ibm.msl.ObjectFactory;
import com.ibm.msl.Param;
import com.ibm.msl.Task;
import com.ibm.msl.Variable;

import javax.xml.namespace.QName;

import com.ibm.dfdl.grammar.DFDLGrammarFactory;
import com.ibm.dfdl.grammar.IDFDLGrammar;
import com.ibm.dfdl.processor.DFDLProcessorFactory;
import com.ibm.dfdl.processor.IDFDLDocHandler;
import com.ibm.dfdl.processor.IDFDLErrorHandler;
import com.ibm.dfdl.processor.IDFDLParser;
import com.ibm.dfdl.processor.IDFDLProcessor;
import com.ibm.dfdl.processor.IDFDLProcessorErrorHandler;
import com.ibm.dfdl.processor.IDFDLRegionHandler;
import com.ibm.dfdl.processor.exceptions.DFDLException;
import com.ibm.dfdl.processor.exceptions.DFDLNotRecognizedException;
import com.ibm.dfdl.processor.trace.IDFDLUserTraceListener;
import com.ibm.dfdl.processor.types.DFDLBOMType;

public class ParseMetaSerialMSL {

	/**
	 * @param args 
	 */
	PrintDocHandler docHandler = null; // Get visibility of the docHandler outside of the Main Method

	public static void main(String[] args) throws URISyntaxException, IOException {
		
		String Path = args.length >= 1 ? args[0] : "../GeneratedMapTargetApp/";
		String MapName = args.length >= 2 ? args[1] : "inmodel_outmodel";
		ObjectFactory factory = new ObjectFactory();
		
		/*
		 * Construct a grammar from a schema file with DFDL annotations 
		 */
		
		ParseMetaSerialMSL metaData = new ParseMetaSerialMSL(); // Give us a handle for access to the class variables
		
		System.out.println("Building grammar");
		System.out.println("----------------");
		IDFDLErrorHandler grammarErrorHandler = new PrintErrorHandler();
		DFDLGrammarFactory grammarFactory = new DFDLGrammarFactory();
		grammarFactory.setErrorHandler(grammarErrorHandler);
		URI schemaUri = new URI("./IOMapModelMetaCSV.xsd");
		IDFDLGrammar grammar=null;
		try {
			grammar = grammarFactory.buildGrammarFromSchema(schemaUri, null);			
		} catch (DFDLException e) {
			System.err.println("DFDL Exception building schema: " + e.getMessage() );
			System.exit(1);
		} 
		
		/*
		 * Construct a DFDL Parser
		 */
		System.out.println("\nConstructing and initialising Parser");
		System.out.println("------------------------------------");
		DFDLProcessorFactory processorFactory = new DFDLProcessorFactory();
		IDFDLParser parser = processorFactory.createParser();
		
		
		/* 
		 * set required Parser properties
		 */
		
		// set grammar
		parser.setGrammar(grammar);
		
		// set root element
		parser.setRootElement("IOMapModelMetaCSV", null);
		
		// set document to parse - the CSV file containing our mapping meta-data
		File inputFile = new File("IOMapModelMeta.csv");
		InputStream documentInputStream = null;
		try {
			documentInputStream = new FileInputStream(inputFile);
			documentInputStream.mark(Integer.MAX_VALUE);
		} catch (FileNotFoundException fnf) {
			System.err.println("Document file "+inputFile+" not found: "+fnf.getMessage());
			System.exit(1);
		}
		
		try {
			parser.setInputDocument(documentInputStream, false);
		} catch (DFDLException e) {
			System.err.println("DFDLException setting document: " + e.getMessage() );
			System.exit(1);
		}
		
		
		/*
		 * set desired Parser handlers
		 */
		
		// set document handler
		metaData.docHandler = new PrintDocHandler(); //@PJ Create a new instance of the doc handler - this gives us
		// access to the internal IOMapModelMetaCSV object which is being created in the PrintDocHandler Class
		parser.setDocumentHandler(metaData.docHandler);
		
		// set error handler
		IDFDLProcessorErrorHandler errorHandler = new PrintErrorHandler();
		parser.setErrorHandler(errorHandler);
		
		// set region handler
		// Note: uncomment to see region handler output - this is quite verbose 
		//IDFDLRegionHandler regionHandler = new PrintRegionHandler();
		//parser.setRegionHandler(regionHandler);
		
		// add a trace listener
		IDFDLUserTraceListener traceListener = new PrintTraceListener();
		parser.addUserTraceListener(traceListener);
		
		// set parser feature : validation
		try {
			parser.setFeature(IDFDLProcessor.DFDL_FEATURE_VALIDATION, true);
		} catch (DFDLNotRecognizedException e) {
			System.err.println("Unknown DFDL processor feature : " + e.getMessage() );
			System.exit(1);
		}
		
		// set parser variable : predefined DFDL variable 'encoding'
		try {
			parser.setVariable("encoding", "http://www.ogf.org/dfdl/dfdl-1.0/", "ISO-8859-1");
		} catch (DFDLException e) {
			System.err.println("DFDL Exception while setting variable: " + e.getMessage() );
			System.exit(1);
		}
		
		/*
		 * parse
		 */
		
		boolean success;
		try {
			// One-step parsing method
			System.out.println("\nParsing with parseAll()");
			System.out.println("-----------------------");
			// the parser will call the docHandler methods - See PrintDocHandler.java @DA@
			// in order to grab the element values as the parser runs
			success = parser.parseAll();		
			System.out.println("\nParsing complete: parseAll() returned " + success);
			
			// validate that the object is being populated....

			System.out.println("sourceMessage:"+ metaData.docHandler.getModel().gdmDef.sourceMessage);
			System.out.println("sourceSchema:"+ metaData.docHandler.getModel().gdmDef.sourceSchema);
			System.out.println("targetMessage:"+ metaData.docHandler.getModel().gdmDef.targetMessage);
			System.out.println("targetSchema:"+ metaData.docHandler.getModel().gdmDef.targetSchema);
			System.out.println("sourceParser:"+ metaData.docHandler.getModel().gdmDef.sourceParser);
			System.out.println("targetParser:"+ metaData.docHandler.getModel().gdmDef.targetParser);
			for (int i = 0; i < metaData.docHandler.getModel().getFieldMapping().size();i++)
			{
					
				System.out.println("Base Action Value Line:" + i + " " +  metaData.docHandler.getModel().getFieldMapping().get(i).baseAction);
				System.out.println("Source Field Value Line:" + i + " " +  metaData.docHandler.getModel().getFieldMapping().get(i).sourceField);
				System.out.println("Target Field Value Line:" + i + " " +  metaData.docHandler.getModel().getFieldMapping().get(i).targetField);
				System.out.println("Description Value Line:" + i + " " +  metaData.docHandler.getModel().getFieldMapping().get(i).description);
				System.out.println("Assign Value Line:" + i + " " +  metaData.docHandler.getModel().getFieldMapping().get(i).assignValue);
				
			}

			if (!success){
				System.exit(1);
			}
			
		} catch (DFDLException e) {
			System.err.println("DFDL exception while processing : " + e.getMessage() );
			System.exit(1);
		}
		
		/* used the IIB Generate Classes for JAXB against the MSL schema to generate the Java objects */
		/* we don't need to use the DFDL serializer because the JAXB marshaller can be told to write XML to file.*/		

		// Create the basic map based on hard coded values
		MappingRoot MyMapRoot = new MappingRoot();
		Documentation MyDoc = new Documentation();
		MyDoc.setDescription("generated via JAXB map generation API at " + new Date().toString());
		MyMapRoot.setDocumentation(MyDoc);
		MyMapRoot.setDomainID("com.ibm.msl.mapping.xml");
		MyMapRoot.setDomainIDExtension("mb");
		MyMapRoot.setMainMap(true);
		MyMapRoot.setTargetNamespace("default");
		MyMapRoot.setVersion("8.0.5.0");
		
// add the input and output map designators for the source and target objects
		
//@DA   metaData.docHandler.getModel().gdmDef.sourceSchema to replace "Input_Model.xsd"	
		MappingDesignator myInpMD = new MappingDesignator();
		myInpMD.setPath("/"+metaData.docHandler.getModel().gdmDef.sourceSchema);
//@DA	myInpMD.setPath("/Input_Model.xsd");
		MyMapRoot.getInput().add(myInpMD); 
		
//@DA metaData.docHandler.getModel().gdmDef.targetSchema to replace "Output_Model.xsd"		
		MappingDesignator myOutMD = new MappingDesignator();
		myOutMD.setPath("/"+metaData.docHandler.getModel().gdmDef.targetSchema);		
//@DA	myOutMD.setPath("/Output_Model.xsd");
		MyMapRoot.getOutput().add(myOutMD);		
		
		Generation MyMapGen = new Generation();
		MyMapGen.setEngine("xquery");
		MyMapRoot.setGeneration(MyMapGen);
		
		// Build the Map Declaration
		MappingDeclaration MyMapDecl = new MappingDeclaration();
		MyMapDecl.setName(MapName);
	
		// add the input map designators for the source and target objects
		
//@DA  metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
//@DA  metaData.docHandler.getModel().gdmDef.sourceParser to replace "XMLNSC"
		
		MappingDesignator myDecInpMD = new MappingDesignator();
		myDecInpMD.setNamespace("http://www.da.com/modelSchema");		
//@DA	myDecInpMD.setPath("mb:msg(inmodel,assembly,XMLNSC,Properties)");
//@DA	myDecInpMD.setVar("ComIbmMessageAssembly_inmodel");	
		myDecInpMD.setPath("mb:msg("+metaData.docHandler.getModel().gdmDef.sourceMessage+",assembly,"   
                                    +metaData.docHandler.getModel().gdmDef.sourceParser+",Properties)");
		myDecInpMD.setVar("ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.sourceMessage);
		
		MyMapDecl.getInput().add(myDecInpMD);
		
		// add the output map designators for the source and target objects
		
//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
//@DA metaData.docHandler.getModel().gdmDef.targetParser to replace "XMLNSC"
		
		MappingDesignator myDecOutMD = new MappingDesignator();
		myDecOutMD.setNamespace("http://www.da.com/modelSchema");		
//@DA	myDecOutMD.setPath("mb:msg(outmodel,assembly,XMLNSC,Properties)");
//@DA	myDecOutMD.setVar("ComIbmMessageAssembly_outmodel");
		myDecOutMD.setPath("mb:msg("+metaData.docHandler.getModel().gdmDef.targetMessage+",assembly,"   
                                    +metaData.docHandler.getModel().gdmDef.targetParser+",Properties)");
		myDecOutMD.setVar("ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.targetMessage);

		MyMapDecl.getOutput().add(myDecOutMD);		
			
		MyMapRoot.getMappingDeclaration().add(MyMapDecl);

		// do a move to copy the properties from input to output
//@DA metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
		
		Move MyPrMove = new Move();
		Documentation MyPrMoveDoc = new Documentation();
		MyPrMoveDoc.setDescription("copy properties across");
		MyPrMove.setDocumentation(MyPrMoveDoc);
		MappingDesignator MyInpPrMoveDesignator = new MappingDesignator();
		MappingDesignator MyOutPrMoveDesignator = new MappingDesignator();
		
//@DA	MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/Properties");	
		MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.sourceMessage+"/Properties");
		
		MyPrMove.getInput().add(MyInpPrMoveDesignator);
		
//@DA	MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/Properties");
		MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.targetMessage+"/Properties");
		
		MyPrMove.setOutput(MyOutPrMoveDesignator);

		JAXBElement<Move> MoveJaxbEl = factory.createMove(MyPrMove);
		
		MyMapDecl.getNested().add(MoveJaxbEl);

//@DA Perform the moves and assigns
//@DA metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
//@DA metaData.docHandler.getModel().getFieldMapping().get(i).sourceField to replace "input1"
//@DA metaData.docHandler.getModel().getFieldMapping().get(i).targetField to replace "output1"
//@DA metaData.docHandler.getModel().getFieldMapping().get(1).assignValue to replace "10"
//@DA determine Move or Assign by Base Action Value metaData.docHandler.getModel().getFieldMapping().get(i).baseAction);
//@DA loop on for (int i = 0; i < metaData.docHandler.getModel().getFieldMapping().size();i++)

	for (int i = 0; i < metaData.docHandler.getModel().getFieldMapping().size();i++)
	{
		
// @DA  for now if it's not an assign assume a move - for now we only support move and assign
		
		if (!(metaData.docHandler.getModel().getFieldMapping().get(i).baseAction).equalsIgnoreCase("move")) 
		{ // if not a move do an assign or concat //@DA2 concat not yet fully implemented
			
			// do an Assign to perform the mapping to output	
			if ((metaData.docHandler.getModel().getFieldMapping().get(i).baseAction).equalsIgnoreCase("assign")) 
			{   // if an assign                                                    
				Assign MyAssign = new Assign();
				Documentation MyAssignDoc = new Documentation();
//@DA			MyAssignDoc.setDescription("constant value 10"); 
				MyAssignDoc.setDescription(metaData.docHandler.getModel().getFieldMapping().get(i).description);
				MyAssign.setValue(metaData.docHandler.getModel().getFieldMapping().get(i).assignValue);
				MyAssign.setDocumentation(MyAssignDoc);
				MappingDesignator MyOutAssignDesignator = new MappingDesignator();
								
//@DA			MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 
				MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_" +metaData.docHandler.getModel().gdmDef.targetMessage+"/"           
		                                                                 +metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
						                                                 +metaData.docHandler.getModel().getFieldMapping().get(i).targetField);

				MyAssign.setOutput(MyOutAssignDesignator);

				JAXBElement<Assign> AssignJaxbEl = factory.createAssign(MyAssign);
						
				MyMapDecl.getNested().add(AssignJaxbEl);
				
			} else // do a concat which is implemented as a function. We will have to use the assignedValue for the second input field
			{			
				Function MyFunction = new Function();

				Documentation MyFunctionDoc = new Documentation();
//@DA			MyMoveDoc.setDescription("uppercase"); 
				MyFunctionDoc.setDescription(metaData.docHandler.getModel().getFieldMapping().get(i).description);
				MyFunction.setRef("fn:concat");				
				MyFunction.setDocumentation(MyFunctionDoc);
				
				MappingDesignator MyInpFunctionDesignator = new MappingDesignator();
				MappingDesignator MyInp2FunctionDesignator = new MappingDesignator();

				MappingDesignator MyOutFunctionDesignator = new MappingDesignator();		

//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
				MyInpFunctionDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.sourceMessage+"/"            
			                                                         +metaData.docHandler.getModel().gdmDef.sourceMessage+"/"              
							                                         +metaData.docHandler.getModel().getFieldMapping().get(i).sourceField);		
					
				MyFunction.getInput().add(MyInpFunctionDesignator);
				
				//@DA second source input for the concat 
//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
				MyInp2FunctionDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.sourceMessage+"/"            
			                                                         +metaData.docHandler.getModel().gdmDef.sourceMessage+"/" 
			                                                    //@DA for a concat get the second input from the assignValue field     
			                                                         +metaData.docHandler.getModel().getFieldMapping().get(i).assignValue);		
					
				MyFunction.getInput().add(MyInp2FunctionDesignator);

					
//@DA			MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 
				MyOutFunctionDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
			                                                         +metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
							                                         +metaData.docHandler.getModel().getFieldMapping().get(i).targetField);				
				
				MyFunction.setOutput(MyOutFunctionDesignator);
//@DA after output designated need to add
//@DA            <param name="string1" value="$input8"/>
//@DA            <param name="string2" value="$input9"/>

				Param MyFunctionParam1 = new Param();		
				MyFunctionParam1.setName("string1");
				MyFunctionParam1.setValue("$"+metaData.docHandler.getModel().getFieldMapping().get(i).sourceField);

				MyFunction.getParam().add(MyFunctionParam1);
				
				Param MyFunctionParam2 = new Param();		
				MyFunctionParam2.setName("string2");
				MyFunctionParam2.setValue("$"+metaData.docHandler.getModel().getFieldMapping().get(i).assignValue);

				MyFunction.getParam().add(MyFunctionParam2);
				
				JAXBElement<Function> FunctionJaxbEl = factory.createFunction(MyFunction);/*@DA3*/			
							
				MyMapDecl.getNested().add(FunctionJaxbEl);
				
				
			}
		
		} else { // else for if move or assign/concat - default to move
			// do a move to perform the mapping from input to output	
			
			//@DA metaData.docHandler.getModel().getFieldMapping().get(i).description to replace "uppercase"
					
				Move MyMove = new Move();
				Documentation MyMoveDoc = new Documentation();
//@DA			MyMoveDoc.setDescription("uppercase"); 
				MyMoveDoc.setDescription(metaData.docHandler.getModel().getFieldMapping().get(i).description);
					
				MyMove.setDocumentation(MyMoveDoc);
				MappingDesignator MyInpMoveDesignator = new MappingDesignator();
				MappingDesignator MyOutMoveDesignator = new MappingDesignator();		

//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
				MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.sourceMessage+"/"            
			                                                         +metaData.docHandler.getModel().gdmDef.sourceMessage+"/"              
							                                         +metaData.docHandler.getModel().getFieldMapping().get(i).sourceField);		
					
				MyMove.getInput().add(MyInpMoveDesignator);
					
//@DA			MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 
				MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_"+metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
			                                                         +metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
							                                         +metaData.docHandler.getModel().getFieldMapping().get(i).targetField);

				MyMove.setOutput(MyOutMoveDesignator);

				MoveJaxbEl = factory.createMove(MyMove);
							
				MyMapDecl.getNested().add(MoveJaxbEl);

				
		} // end of if move or assign
	} // end of the loop for element mapping entries
								
		try {
			// Write the map file
			File file = new File(Path + MapName + ".map");
			JAXBContext jaxbContext = JAXBContext.newInstance(MappingRoot.class);

			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
			// @DA@ MappingRoot does not have a @XMLRootElement annotation so you have to wrap it - maybe the MSL.xsd schema needs updating
			// @DA@ this link explains http://www.source4code.info/2013/07/jaxb-marshal-element-missing-xmlrootelement-annotation.html
			
			QName qName = new QName("http://www.ibm.com/2008/ccl/Mapping","mappingRoot");
			JAXBElement<MappingRoot> myRoot = new JAXBElement<MappingRoot>(qName,MappingRoot.class, MyMapRoot);
			
			jaxbMarshaller.marshal(myRoot, file);
			jaxbMarshaller.marshal(myRoot, System.out);

//@DA	now refresh GeneratedMapTargetApp then open	../GeneratedMapTargetApp/inmodel_outmodel.map to check result
			
	      } catch (JAXBException e) {
			e.printStackTrace();
	      }		
		
	}

}
