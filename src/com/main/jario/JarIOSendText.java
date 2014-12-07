/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.jario;

import com.main.JSONObjectWrapper;
import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class JarIOSendText implements JarIOInterface
{

    private JSONObjectWrapper jsonObj = null;

    /**
     * Sets up the JarIO class with a jsonObject
     *
     * @param jsonString
     */
    public JarIOSendText(String jsonString)
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
        return JarIOEnum.SEND_TEXT;
    }

    /**
     * Gets the JSON message to write out to the jar based upon the JSON message
     * given.
     *
     * @param message Message to add to JSON
     * @return
     */
    public String getJSONOutMessage(String message)
    {
        return new JSONObject().put(JarIOEnum.SEND_TEXT.toString(), message).toString();
    }
}
