package com.ibm.dfdljaxb.gdmgen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import com.ibm.msl.Assign;
import com.ibm.msl.Documentation;
import com.ibm.msl.Function;
import com.ibm.msl.Generation;
import com.ibm.msl.MappingDeclaration;
import com.ibm.msl.MappingDesignator;
import com.ibm.msl.MappingRoot;
import com.ibm.msl.Move;
import com.ibm.msl.ObjectFactory;
import com.ibm.msl.Param;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import com.ibm.dfdljaxb.gdmgen.Mapping_myjson;
import com.ibm.dfdljaxb.gdmgen.Mapping_context;
import com.ibm.dfdljaxb.gdmgen.Mapping_list;
import com.ibm.dfdljaxb.gdmgen.Mapping_item;

	public class ParseJSONSerialMSL {

		/**
		 * @param args 
		 */
		PrintDocHandler docHandler = null; // Get visibility of the docHandler outside of the Main Method

		public static void main(String[] args) throws URISyntaxException, IOException {
			
			String Path = args.length >= 1 ? args[0] : "../GeneratedMapTargetApp/";
			String MapName = args.length >= 2 ? args[1] : "inmodel_outmodel_fromJSON";
			ObjectFactory factory = new ObjectFactory();
			String JSON_FILE="IOMapModelMeta.json";
			
			/*
			 * Construct from a JSON parser
			 */
			
			ParseJSONSerialMSL metaData = new ParseJSONSerialMSL(); // Give us a handle for access to the class variables
			
			System.out.println("Building based on JSON parsing");
			System.out.println("----------------");
			
			InputStream fis = new FileInputStream(JSON_FILE);
			//create JsonReader object
			System.out.println("create Jsonreader: Json.createReader(fis)");

			JsonReader jsonReader = Json.createReader(fis);
			
			/**
			 * you can create JsonReader from Factory also
			JsonReaderFactory factory = Json.createReaderFactory(null);
			jsonReader = factory.createReader(fis);
			*/
			System.out.println("get base Json Object: jsonReader.readObject()");
			
			//get JsonObject from JsonReader
			JsonObject baseJsonObject = jsonReader.readObject();

			System.out.println(baseJsonObject.toString());
			
			System.out.println("close I/O: jsonReader.close() and fis.close()");
			
			//close IO resource and JsonReader now
			jsonReader.close();
			fis.close();

			//Retrieve data from JsonObject and create myjson object bean
			Mapping_myjson  mapjson = new Mapping_myjson();
			Mapping_context mapctxt = new Mapping_context();
			Mapping_list    maplist = new Mapping_list();
			Mapping_item    mapitem = new Mapping_item();

			//reading inner mapping context object from base json object - get the mapping_context
			JsonObject mapctxtJsonObject = baseJsonObject.getJsonObject("mapping_context");
			
			mapctxt.setSource_schema(mapctxtJsonObject.getString("sourceSchema"));
			mapctxt.setSource_message(mapctxtJsonObject.getString("sourceMessage"));
			mapctxt.setSource_parser(mapctxtJsonObject.getString("sourceParser"));
			mapctxt.setTarget_schema(mapctxtJsonObject.getString("targetSchema"));
			mapctxt.setTarget_message(mapctxtJsonObject.getString("targetMessage"));
			mapctxt.setTarget_parser(mapctxtJsonObject.getString("targetParser"));

			System.out.println("set sourceSchema from Json object mapping_context:"+(mapctxtJsonObject.getString("sourceSchema")));	
			System.out.println("get sourceSchema from mapping_context Java object:"+(mapctxt.getSource_schema()));	
			System.out.println("full map context details:"+mapctxt.toString());
			
			mapjson.setMapping_context(mapctxt);
			
			System.out.println("full map object details:"+mapjson.toString());
			
			//reading inner mapping list object from mapping context json object - get the mapping_context
			JsonObject maplistJsonObject = mapctxtJsonObject.getJsonObject("mapping_list");
			
			//reading inner mapping item array from mapping list json object - get the mapping_context
			JsonArray mapitemJsonArray = maplistJsonObject.getJsonArray("mapping_item");

			// create and initialize the Java array of mappings
			Mapping_item[] mappings = new Mapping_item[mapitemJsonArray.size()];
			
			for(int i=0;i<mappings.length;i++){mappings[i]=new Mapping_item();}
			
			int index = 0;
			for(JsonValue value : mapitemJsonArray){
				System.out.println("in the array loop at index:"+index);
				
				JsonObject mapitemJsonObject = mapitemJsonArray.getJsonObject(index);
				
				System.out.println("get input from json Object:"+ mapitemJsonObject.getString("input"));				
				System.out.println("get output from json Object:"+ mapitemJsonObject.getString("output"));				
				System.out.println("get action from json Object:"+ mapitemJsonObject.getString("action"));
				System.out.println("get value from json Object:"+ mapitemJsonObject.getString("value"));				
				System.out.println("get description from json Object:"+ mapitemJsonObject.getString("description"));				

				mappings[index].setInput(mapitemJsonObject.getString("input"));
				mappings[index].setOutput(mapitemJsonObject.getString("output"));
				mappings[index].setAction(mapitemJsonObject.getString("action"));
				mappings[index].setValue(mapitemJsonObject.getString("value"));
				mappings[index].setDescription(mapitemJsonObject.getString("description"));
				
				System.out.println("get input from java object:"+ mappings[index].getInput());
				System.out.println("mapping detail from java object:"+ mappings[index].toString());

				index++;
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
			myInpMD.setPath("/"+mapctxt.getSource_schema()); //@DAj
	//@DA	myInpMD.setPath("/Input_Model.xsd");
			MyMapRoot.getInput().add(myInpMD); 
			
	//@DA metaData.docHandler.getModel().gdmDef.targetSchema to replace "Output_Model.xsd"		
			MappingDesignator myOutMD = new MappingDesignator();
 			myOutMD.setPath("/"+mapctxt.getTarget_schema()); //@DAj			
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
			
			myDecInpMD.setPath("mb:msg("+mapctxt.getSource_message()+",assembly,"   //@DAj
                    +mapctxt.getSource_parser()+",Properties)");                    //@DAj
			myDecInpMD.setVar("ComIbmMessageAssembly_"+mapctxt.getSource_message());//@DAj
		
			MyMapDecl.getInput().add(myDecInpMD);
			
			// add the output map designators for the source and target objects
			
	//@DA metaData.docHandler.getModel().gdmDef.targetMessage to replace "outmodel"
	//@DA metaData.docHandler.getModel().gdmDef.targetParser to replace "XMLNSC"
			
			MappingDesignator myDecOutMD = new MappingDesignator();
			myDecOutMD.setNamespace("http://www.da.com/modelSchema");		
	//@DA	myDecOutMD.setPath("mb:msg(outmodel,assembly,XMLNSC,Properties)");
	//@DA	myDecOutMD.setVar("ComIbmMessageAssembly_outmodel");
						
			myDecOutMD.setPath("mb:msg("+mapctxt.getTarget_message()+",assembly,"   //@DAj
                    +mapctxt.getTarget_parser()+",Properties)");                    //@DAj
			myDecOutMD.setVar("ComIbmMessageAssembly_"+mapctxt.getTarget_message());//@DAj


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
			MyInpPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getSource_message()+"/Properties"); //@DAj
			
			MyPrMove.getInput().add(MyInpPrMoveDesignator);
			
	//@DA	MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/Properties");
			MyOutPrMoveDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getTarget_message()+"/Properties");
			
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

		for (int i = 0; i < mappings.length;i++) //@DAj

		{
			
	// @DA  for now if it's not an assign or concat assume a move - for now we only support move assign and fn:concat
			
			if (!(mappings[i].getAction()).equalsIgnoreCase("move")) //	@DAj		
			{ // if not a move do an assign or concat //@DA2 concat not yet fully implemented
				
				// do an Assign to perform the mapping to output	
				if ((mappings[i].getAction()).equalsIgnoreCase("assign")) //@DAj
				
				{   // if an assign                                                    
					Assign MyAssign = new Assign();
					Documentation MyAssignDoc = new Documentation();
	//@DA			MyAssignDoc.setDescription("constant value 10"); 
					
					MyAssignDoc.setDescription(mappings[i].getDescription()); //@DAj
					MyAssign.setValue(mappings[i].getValue()); //@DAj
					
					MyAssign.setDocumentation(MyAssignDoc);
					MappingDesignator MyOutAssignDesignator = new MappingDesignator();
									
	//@DA			MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 

					MyOutAssignDesignator.setPath("$ComIbmMessageAssembly_" +mapctxt.getTarget_message()+"/" //@DAj       
                            												+mapctxt.getTarget_message()+"/" //@DAj       
                            												+mappings[i].getOutput());       //@DAj

					
					MyAssign.setOutput(MyOutAssignDesignator);

					JAXBElement<Assign> AssignJaxbEl = factory.createAssign(MyAssign);
							
					MyMapDecl.getNested().add(AssignJaxbEl);
					
				} else // do a concat which is implemented as a function. We will have to use the assignedValue for the second input field
				{			
					Function MyFunction = new Function();

					Documentation MyFunctionDoc = new Documentation();
	//@DA			MyMoveDoc.setDescription("uppercase"); 
					MyFunctionDoc.setDescription(mappings[i].getDescription()); //@DAj
					MyFunction.setRef("fn:concat");				
					MyFunction.setDocumentation(MyFunctionDoc);
					
					MappingDesignator MyInpFunctionDesignator = new MappingDesignator();
					MappingDesignator MyInp2FunctionDesignator = new MappingDesignator();

					MappingDesignator MyOutFunctionDesignator = new MappingDesignator();		

	//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
					
					MyInpFunctionDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getSource_message()+"/"  //@DAj          
                            												 +mapctxt.getSource_message()+"/"  //@DAj            
                            												 +mappings[i].getInput());	       //@DAj	
						
					MyFunction.getInput().add(MyInpFunctionDesignator);
					
					//@DA second source input for the concat 
	//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
					
					MyInp2FunctionDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getSource_message()+"/"       //@DAj     
                                                                              +mapctxt.getSource_message()+"/"       //@DAj
                       //@DA for a concat get the second input from the value field(json)     
                                                                              +mappings[i].getValue());		         //@DAj   
					
										
					MyFunction.getInput().add(MyInp2FunctionDesignator);

						
	//@DA			MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 

					MyOutFunctionDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getTarget_message()+"/"        //@DAj      
                            											 +mapctxt.getTarget_message()+"/"            //@DAj  
                            											 +mappings[i].getOutput());				     //@DAj

					
					MyFunction.setOutput(MyOutFunctionDesignator);
	//@DA after output designated need to add
	//@DA            <param name="string1" value="$input8"/>
	//@DA            <param name="string2" value="$input9"/>

					Param MyFunctionParam1 = new Param();		
					MyFunctionParam1.setName("string1");
					MyFunctionParam1.setValue("$"+mappings[i].getInput()); //@DAj
					MyFunction.getParam().add(MyFunctionParam1);
					
					Param MyFunctionParam2 = new Param();		
					MyFunctionParam2.setName("string2");
					MyFunctionParam2.setValue("$"+mappings[i].getValue()); //@DAj
					
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
					MyMoveDoc.setDescription(mappings[i].getDescription()); //@DAj
						
					MyMove.setDocumentation(MyMoveDoc);
					MappingDesignator MyInpMoveDesignator = new MappingDesignator();
					MappingDesignator MyOutMoveDesignator = new MappingDesignator();		

	//@DA			MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_inmodel/inmodel/input1"); 
					
					MyInpMoveDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getSource_message()+"/" //@DAj           
                            											 +mapctxt.getSource_message()+"/" //@DAj             
                            											 +mappings[i].getInput()); 		  //@DAj		
						
					MyMove.getInput().add(MyInpMoveDesignator);
						
	//@DA			MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_outmodel/outmodel/output1"); 

					MyOutMoveDesignator.setPath("$ComIbmMessageAssembly_"+mapctxt.getTarget_message()+"/"  //@DAj            
                            											 +mapctxt.getTarget_message()+"/"  //@DAj
                            											 +mappings[i].getOutput());//@DAj
					
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

