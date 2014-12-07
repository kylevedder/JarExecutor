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
public class JarIOWrapper
{

    private JSONObjectWrapper jsonObject = null;
    private JarIOEnum type = null;

    public JarIOWrapper(String jsonString)
    {
        if (jsonString != null)
        {
            jsonObject = new JSONObjectWrapper(jsonString);
            //find the type this command is. Assumes only one type per command.
            findType:
            for(JarIOEnum jarioEnum : JarIOEnum.values())
            {
                if(jsonObject.has(jarioEnum.toString()))
                {
                    this.type = jarioEnum;
                    break findType;
                }
            }
        }
    }
    
    /**
     * Gets the String for the new directory.
     * <p>Only for GET_DIR commands.</p>
     * @return 
     */
    public String getNewDirectory()
    {
        if(getType() == JarIOEnum.GET_DIR)
        {
            return this.jsonObject.getString(JarIOEnum.GET_DIR.toString());
        }
        return null;
    }
    

    /**
     * Gets the type of the object.
     * @return 
     */
    public JarIOEnum getType()
    {
        return type;
    }
        
    /**
     * Gets the raw JSON of the object.
     * @return 
     */
    public String getRawJSON()
    {
        return this.jsonObject.toString();
    }

}
