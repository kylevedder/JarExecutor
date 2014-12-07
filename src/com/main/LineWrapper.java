/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class LineWrapper
{

    //control command
    public static final String KEY_CONTROL = "control";
    public static final String VALUE_CONTROL_WRITE_REQUEST = "input";
    
    //text command
    public static final String KEY_TEXT = "text";
    
    private JSONObjectWrapper jo;
    private Type type = null;
    private String message = null;

    /**
     * Wrapper object for each line sent from the Jar.
     * @param line 
     */
    public LineWrapper(String line)
    {
        try
        {
            jo = new JSONObjectWrapper(line);
        }
        catch (Exception ex)
        {
            System.err.println(line);
            ex.printStackTrace();
            jo = null;
        }
        parseJSON();
    }
    
    /**
     * Parse the JSON to setup exposed info.
     */
    private void parseJSON()
    {
        if(jo != null)
        {
            //if a write request
            String value;
            if((value = jo.getString(KEY_CONTROL)) != null && value.equals(VALUE_CONTROL_WRITE_REQUEST))
            {
                type = Type.COMMAND_WRITE;
                message = jo.toString();
            }
            else if((value = jo.getString(KEY_TEXT)) != null)
            {
                type = Type.TEXT;
                message = value;
            }
        }
    }

    /**
     * Get the operation type.
     * @return 
     */
    public Type getType()
    {
        return type;
    }
    
    /**
     * Gets the line message, either raw JSON or the text of the message if a text type.
     * @return 
     */
    public String getMessage()
    {
        return message;
    }
    
    

}

enum Type
{
    COMMAND_WRITE, TEXT
}
