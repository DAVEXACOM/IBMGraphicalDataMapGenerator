# IBMGraphicalDataMapGenerator
Standalone IBM Graphical Data Mapper generation utility to accelerate the creation of map specification language maps based on transformation meta-data modelled in comma delimited CSV(XLS)files
#

This utility uses the standalone DFDL Java parser to parse a comma delimited (CSV) format file containing the definition of a transformation mapping exercise that needs to be performed. The data in the parsed object is then passed to JAXB code that executes against the IBM GDM XML schema (msl.xsd) to produce an IBM Graphical Data Map that can be used in IBM Integration Bus by default. However, if opened in IBM Integration Designer the target runtime can be changed from xquery to XSLT in order to be used with Datapower.(I have not tested against Datapower) 

This utility is a work in progess and at this point in time it will attempt to do the following:
1) Create basic IBM GDM Maps with a single input and output schema
2) Perform element association.
3) Supports move and assigns only

Therefore, at this point in time the utility represents a rudimentary capability that demonstrates how to use meta-data (in this example in the form of a CSV file to define a transformation and then use that data to generate an IBM Graphical Data Map.

There is an ObjectAssociation java project included. This code can be used in conjunction with an IIB Pattern to associate the generate map files with IIB Mapping Nodes in IIB Message flows.

The original ObjectAssociation pattern was shipped with the WESB-CONV-UTILITIES repository. I am in the process of updating it. I have removed the pattern from this material (but left the Java source) until I have completed this exercise.


If you wish to contribute please email Dave - davearno@au1.ibm.com
