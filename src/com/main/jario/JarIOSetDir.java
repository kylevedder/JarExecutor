/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.jario;

import com.main.JSONObjectWrapper;
import java.io.File;

/**
 *
 * @author Kyle
 */
public class JarIOSetDir implements JarIOInterface
{

    private JSONObjectWrapper jsonObj = null;

    /**
     * Sets up the JarIO class with a jsonObject
     *
     * @param jsonString
     */
    public JarIOSetDir(String jsonString)
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
        return JarIOEnum.SET_DIR;
    }

    /**
     * Gets the new directory to change to. May be a relative directory change.
     *
     * @return
     */
    public String getNewDir()
    {
        return jsonObj.getString(JarIOEnum.SET_DIR.toString());
    }
}
