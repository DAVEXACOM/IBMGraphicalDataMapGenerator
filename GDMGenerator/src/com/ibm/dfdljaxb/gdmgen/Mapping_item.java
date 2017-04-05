package com.ibm.dfdljaxb.gdmgen;

public class Mapping_item
{
    private String input;

    private String description;

    private String value;

    private String action;

    private String output;

    public String getInput ()
    {
        return input;
    }

    public void setInput (String input)
    {
        this.input = input;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getValue ()
    {
        return value;
    }

    public void setValue (String value)
    {
        this.value = value;
    }

    public String getAction ()
    {
        return action;
    }

    public void setAction (String action)
    {
        this.action = action;
    }

    public String getOutput ()
    {
        return output;
    }

    public void setOutput (String output)
    {
        this.output = output;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [input = "+input+", description = "+description+", value = "+value+", action = "+action+", output = "+output+"]";
    }
}
			
			