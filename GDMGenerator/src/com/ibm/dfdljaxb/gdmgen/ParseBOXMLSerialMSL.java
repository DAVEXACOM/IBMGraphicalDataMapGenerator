package com.ibm.dfdljaxb.gdmgen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import com.ibm.msl.Assign;
import com.ibm.msl.CustomFunction;
import com.ibm.msl.Documentation;
import com.ibm.msl.Function;
import com.ibm.msl.Generation;
import com.ibm.msl.Import;
import com.ibm.msl.Imports;
import com.ibm.msl.MappingDeclaration;
import com.ibm.msl.MappingDesignator;
import com.ibm.msl.MappingRoot;
import com.ibm.msl.Move;
import com.ibm.msl.Namespace;
import com.ibm.msl.Namespaces;
import com.ibm.msl.ObjectFactory;
import com.ibm.msl.Param;


import com.ibm.wesbBO.*;

	public class ParseBOXMLSerialMSL {

		/**
		 * @param args 
		 */
		PrintDocHandler docHandler = null; // Get visibility of the docHandler outside of the Main Method

		public static void main(String[] args) throws URISyntaxException, IOException {
			
			String Path = args.length >= 1 ? args[0] : "../GeneratedMapTargetApp/";
			String MapName = args.length >= 2 ? args[1] : "WESB_mesBlastBlockMessageType_To_Blastblock_Submap";
			ObjectFactory factory = new ObjectFactory();
			String BOXML_FILE="WESB_mesBlastBlockMessageType_To_Blastblock_Submap.map";
			
			/*
			 * Construct from a JAXB parser
			 */
			
			ParseBOXMLSerialMSL metaData = new ParseBOXMLSerialMSL(); // Give us a handle for access to the class variables
			
			System.out.println("Building based on JAXB parsing");
			System.out.println("----------------");
			

			
		        JAXBContext jaxbInContext;
				try {
					jaxbInContext = JAXBContext.newInstance("com.ibm.wesbBO");
		        Unmarshaller jaxbUnmarshaller = jaxbInContext.createUnmarshaller();
		        BusinessObjectMap BO = (BusinessObjectMap)jaxbUnmarshaller.unmarshal(new File(BOXML_FILE));

		        System.out.println("BO Map name: "+BO.getName());
		        System.out.println("BO Map namespace: "+BO.getTargetNamespace());
			
		    // used the IIB Generate Classes for JAXB against a wesbBO schema to generate Java Objects	
			// used the IIB Generate Classes for JAXB against the MSL schema to generate the Java objects 
            // unmarshall the wesb map file and marshall an IIB GDM
		        
			// Create the basic map based on hard coded values
			MappingRoot MyMapRoot = new MappingRoot();
			Documentation MyDoc = new Documentation();
			MyDoc.setDescription("generated via JAXB map generation API at " + new Date().toString());
			MyMapRoot.setDocumentation(MyDoc);
			MyMapRoot.setDomainID("com.ibm.msl.mapping.xml");
			MyMapRoot.setDomainIDExtension("mb");
			MyMapRoot.setMainMap(false);
			MyMapRoot.setTargetNamespace("default");
			MyMapRoot.setVersion("8.0.5.0");
			
	// add the input and output map designators for the source and target objects
			
	//@DA   "mesBlastBlockMessageType.xsd"	
			MappingDesignator myInpMD = new MappingDesignator();
			myInpMD.setPath("/"+BO.getInputBusinessObjectVariable().getName()+".xsd"); //@DAx
			MyMapRoot.getInput().add(myInpMD); 
			
	//@DA "Blastblock.xsd"		
			MappingDesignator myOutMD = new MappingDesignator();
 			myOutMD.setPath("/"+BO.getOutputBusinessObjectVariable().getName()+".xsd"); //@DAx
			MyMapRoot.getOutput().add(myOutMD);		
    
	// if we are going to support custom Java we need a place holder Java class imported and an extension namespace of prefix 
	//		<imports>
    //	        <import kind="java" location="com.da.javaholder.placeholder" namespace="xalan://com.da.javaholder.placeholder"/>
    //	    </imports>
	//      <namespace kind="extension" prefix="placeholder" uri="xalan://com.da.javaholder.placeholder"/>
		
            Import MyPlaceHolderImport = new Import();
            MyPlaceHolderImport.setKind("java");
            MyPlaceHolderImport.setLocation("com.da.javaholder.placeholder");
            MyPlaceHolderImport.setNamespace("xalan://com.da.javaholder.placeholder");
            Imports MyPlaceHolderImports = new Imports();
            MyPlaceHolderImports.getImport().add(MyPlaceHolderImport);
			MyMapRoot.setImports(MyPlaceHolderImports);

			Namespaces myNSlist = new Namespaces();

			Namespace javaPrefixNS = new Namespace();
			javaPrefixNS.setKind("extension");
			javaPrefixNS.setPrefix("placeholder");
			javaPrefixNS.setUri("xalan://com.da.javaholder.placeholder");

			myNSlist.getNamespace().add(javaPrefixNS); 

    //additional add the namespaces list - need to do this without hard coding or pass in as parms		
			
			Namespace firstNS = new Namespace();
			firstNS.setKind("supplement");
			firstNS.setPrefix("in");
			firstNS.setUri("http://daltmines.net/services");
			
			myNSlist.getNamespace().add(firstNS); 
			
			Namespace secondNS = new Namespace();
			secondNS.setKind("supplement");
			secondNS.setPrefix("out");
			secondNS.setUri("http://MQ2BlastblockNotificationPublisher/BlastblockCMM");

			myNSlist.getNamespace().add(secondNS); 
			
            MyMapRoot.setNamespaces(myNSlist); 
			
			Generation MyMapGen = new Generation();
			MyMapGen.setEngine("xquery");
			MyMapRoot.setGeneration(MyMapGen);
			
			// Build the Map Declaration
			MappingDeclaration MyMapDecl = new MappingDeclaration();
			MyMapDecl.setName(MapName);		
			
			MappingDesignator myDecInpMD = new MappingDesignator();
			myDecInpMD.setNamespace("http://daltmines.net/services"); // need to get this from BusObjectMap attributes		
	//@DA	myDecInpMD.setPath("mb:msg(inmodel,assembly,XMLNSC,Properties)");
	//@DA	myDecInpMD.setVar("ComIbmMessageAssembly_inmodel");			
			myDecInpMD.setPath("type('"+BO.getInputBusinessObjectVariable().getName()+"')");   //@DAx
//                        +mapctxt.getSource_parser()+",Properties)");                         //@DAx
//			myDecInpMD.setVar("ComIbmMessageAssembly_"+mapctxt.getSource_message());           //@DAx	
			MyMapDecl.getInput().add(myDecInpMD);
						
			// add the output map designators for the source and target objects
						
			MappingDesignator myDecOutMD = new MappingDesignator();
			myDecOutMD.setNamespace("http://MQ2BlastblockNotificationPublisher/BlastblockCMM");	// need to get this from BusObjectMap attributes	
	//@DA	myDecOutMD.setPath("mb:msg(outmodel,assembly,XMLNSC,Properties)");
	//@DA	myDecOutMD.setVar("ComIbmMessageAssembly_outmodel");
						
			myDecOutMD.setPath("type('"+BO.getOutputBusinessObjectVariable().getName()+"')");   //@DAx
//                    +mapctxt.getTarget_parser()+",Properties)");                              //@DAx
//			myDecOutMD.setVar("ComIbmMessageAssembly_"+mapctxt.getTarget_message());            //@DAx

			MyMapDecl.getOutput().add(myDecOutMD);		
				
			MyMapRoot.getMappingDeclaration().add(MyMapDecl);
			
			// add the input map designators for the source and target objects
			
	/*@DAsub-str don't do this for a sub-map
	//@DA metaData.docHandler.getModel().gdmDef.sourceMessage to replace "inmodel"
	//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
			
			Move MyPrMove = new Move();
			Documentation MyPrMoveDoc = new Documentation();
			MyPrMoveDoc.setDescription("copy properties across");
			MyPrMove.setDocumentation(MyPrMoveDoc);
			MappingDesignator MyInpPrMoveDesignator = new MappingDesignator();
			MappingDesignator MyOutPrMoveDesignator = new MappingDesignator();
			
			MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+BO.getInputBusinessObjectVariable().getName()+"/Properties"); //@DAj
			
			MyPrMove.getInput().add(MyInpPrMoveDesignator);
			
			MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+BO.getOutputBusinessObjectVariable().getName()+"/Properties");
			
			MyPrMove.setOutput(MyOutPrMoveDesignator);

			JAXBElement<Move> MoveJaxbEl = factory.createMove(MyPrMove);
			
			MyMapDecl.getNested().add(MoveJaxbEl);  don't do this for a sub-map @DAsub-end*/

			
			//@DA Perform the moves - code just assumes moves at the moment need to check for custom
			
			int totalMappings = BO.getPropertyMap().size();
			
	        System.out.println("Number of element mappings: "+totalMappings); 

			for (int i = 0; i < totalMappings;i++) 

			{
					
	        List<PropertyMap> MappingList = BO.getPropertyMap();
	        
	        PropertyMap MyPropMap = MappingList.get(i);

			if (MyPropMap.getMove() != null){ //	check for move or customAssignment/Function			

	        System.out.println("execution order of move: "+MyPropMap.getExecutionOrder()); 
	        System.out.println("input ref of move: "+MyPropMap.getMove().getInput().getBusinessObjectVariableRef()); 
	        System.out.println("input property(field) of move: "+MyPropMap.getMove().getInput().getProperty()); 

	        System.out.println("output ref of move: "+MyPropMap.getMove().getOutput().getBusinessObjectVariableRef()); 
	        System.out.println("output property(field) of move: "+MyPropMap.getMove().getOutput().getProperty()); 

			Move MyMove = new Move();
			Documentation MyMoveDoc = new Documentation();
    		MyMoveDoc.setDescription("from WESB BO"); 				
    		MyMove.setDocumentation(MyMoveDoc);

			MappingDesignator MyInpMoveDesignator = new MappingDesignator();
			MappingDesignator MyOutMoveDesignator = new MappingDesignator();		

			
			MyInpMoveDesignator.setPath(
					//"$ComIbmMessageAssembly_"+BO.getInputBusinessObjectVariable()+"/" //@DAx           
                    //											 +BO.getInputBusinessObjectVariable()+"/" //@DAx             
                    											 MyPropMap.getMove().getInput().getProperty()); //@DAx	
				
			MyMove.getInput().add(MyInpMoveDesignator);
				
			MyOutMoveDesignator.setPath(
					//"$ComIbmMessageAssembly_"+BO.getOutputBusinessObjectVariable()+"/"  //@DAj            
                    //											 +BO.getOutputBusinessObjectVariable()+"/"  //@DAj
                    											 MyPropMap.getMove().getOutput().getProperty());//@DAj
			
			MyMove.setOutput(MyOutMoveDesignator);

			JAXBElement<Move> MoveJaxbEl = factory.createMove(MyMove);
						
			MyMapDecl.getNested().add(MoveJaxbEl);
	        
			}else // else Move so must be customAssignment that we will map to customFunction
			{
		        
		    System.out.println("execution order of custom: "+MyPropMap.getExecutionOrder()); 
		    System.out.println("output ref of custom: "+MyPropMap.getCustomAssignment().getOutput().getBusinessObjectVariableRef()); 
		    System.out.println("output property(field) of custom: "+MyPropMap.getCustomAssignment().getOutput().getProperty()); 
		    System.out.println("javacode(field) of custom: "+MyPropMap.getCustomAssignment().getJavaCode()); 

			CustomFunction MyCusFunc = new CustomFunction();
			Documentation MyCusFuncDoc = new Documentation();
			MyCusFuncDoc.setDescription("Java snippet from WESB BO");
			MyCusFuncDoc.setValue(MyPropMap.getCustomAssignment().getJavaCode());
			MyCusFunc.setDocumentation(MyCusFuncDoc);
			MyCusFunc.setLang("java");
			MyCusFunc.setRef("placeholder:sampleTransform");
			MappingDesignator MyOutCusFuncDesignator = new MappingDesignator();
							
			MyOutCusFuncDesignator.setPath(
					                    // "$ComIbmMessageAssembly_" +metaData.docHandler.getModel().gdmDef.targetMessage+"/"           
	                                    //                           +metaData.docHandler.getModel().gdmDef.targetMessage+"/"              
					                                                 MyPropMap.getCustomAssignment().getOutput().getProperty());

			MyCusFunc.getOutput().add(MyOutCusFuncDesignator);

			JAXBElement<CustomFunction> AssignJaxbEl = factory.createCustomFunction(MyCusFunc);
					
			MyMapDecl.getNested().add(AssignJaxbEl);

			} // end of if/else
			
			} //end for loop
				
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

