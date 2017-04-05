package com.ibm.dfdljaxb.gdmgen;

public class Mapping_context
{
    private String targetSchema;

    private Mapping_list mapping_list;

    private String targetMessage;

    private String sourceParser;

    private String sourceMessage;

    private String sourceSchema;

    private String targetParser;

    public String getTarget_schema ()
    {
        return targetSchema;
    }

    public void setTarget_schema (String targetSchema)
    {
        this.targetSchema = targetSchema;
    }

    public Mapping_list getMapping_list ()
    {
        return mapping_list;
    }

    public void setMapping_list (Mapping_list mapping_list)
    {
        this.mapping_list = mapping_list;
    }

    public String getTarget_message ()
    {
        return targetMessage;
    }

    public void setTarget_message (String targetMessage)
    {
        this.targetMessage = targetMessage;
    }

    public String getSource_parser ()
    {
        return sourceParser;
    }

    public void setSource_parser (String sourceParser)
    {
        this.sourceParser = sourceParser;
    }

    public String getSource_message ()
    {
        return sourceMessage;
    }

    public void setSource_message (String sourceMessage)
    {
        this.sourceMessage = sourceMessage;
    }

    public String getSource_schema ()
    {
        return sourceSchema;
    }

    public void setSource_schema (String sourceSchema)
    {
        this.sourceSchema = sourceSchema;
    }

    public String getTarget_parser ()
    {
        return targetParser;
    }

    public void setTarget_parser (String targetParser)
    {
        this.targetParser = targetParser;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [targetSchema = "+targetSchema+", mapping_list = "+mapping_list+", targetMessage = "+targetMessage+", sourceParser = "+sourceParser+", sourceMessage = "+sourceMessage+", sourceSchema = "+sourceSchema+", targetParser = "+targetParser+"]";
    }
}
			
			
