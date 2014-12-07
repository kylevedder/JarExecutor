/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.jario;

import com.main.JSONObjectWrapper;

/**
 *
 * @author Kyle
 */
public class JarIOPrintText implements JarIOInterface
{    
    
    private JSONObjectWrapper jsonObj = null;
    /**
     * Sets up the JarIOPrintText class with a jsonObject
     * @param jsonString 
     */
    public JarIOPrintText(String jsonString)
    {
        setJSON(jsonString);
    }

    @Override
    public void setJSON(String JSONString)
    {
        jsonObj = new JSONObjectWrapper(JSONString);
    }

    @Override
    public String getRawJSON()
    {
        if (jsonObj != null)
        {
            return jsonObj.toString();
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public JarIOEnum getType()
    {
        return JarIOEnum.PRINT_TEXT;
    }
    
    
    /**
     * Gets the String message.
     * @return 
     */
    public String getMessage()
    {
        return this.jsonObj.getString(JarIOEnum.PRINT_TEXT.toString());
    }

    
}

  

