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
public class JarIOObjectHandler
{

    private JSONObjectWrapper jsonObj = null;
    private JarIOEnum type = null;
    private String jsonString = null;

    /**
     * Sets up the JarIO class with a jsonObject
     *
     * @param jsonString
     */
    public JarIOObjectHandler(String jsonString)
    {
        this.jsonString = jsonString;
        if (jsonString != null)
        {
            this.jsonObj = new JSONObjectWrapper(jsonString);
            for(JarIOEnum jarIO : JarIOEnum.values())
            {
                if(this.jsonObj.has(jarIO.toString()))
                {
                    this.type = jarIO;
                }
            }
        }
    }
    
    /**
     * Gets the type of command.
     * @return 
     */
    public JarIOEnum getType()
    {
        return type;
    }
    
    /**
     * Returns the correct object based upon the type or null if no correct object found.
     * @return 
     */
    public JarIOInterface getObject()
    {
        if(getType() == JarIOEnum.PRINT_TEXT)
        {
            return new JarIOPrintText(jsonString);
        }
        else if(getType() == JarIOEnum.SEND_TEXT)
        {
            return new JarIOSendText(jsonString);
        }
        else if(getType() == JarIOEnum.SET_DIR)
        {
            return new JarIOSetDir(jsonString);
        }
        else
        {
            return null;
        }
            
    }

    @Override
    public String toString()
    {
        return jsonString;
    }
    
    

}
