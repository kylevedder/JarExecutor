/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kyle
 */
public class JSONObjectWrapper extends JSONObject
{
    
    /**
     * Construct a JSONObject from a source JSON text string. This is the most
     * commonly used JSONObject constructor.
     *
     * @param source
     *            A string beginning with <code>{</code>&nbsp;<small>(left
     *            brace)</small> and ending with <code>}</code>
     *            &nbsp;<small>(right brace)</small>.
     * @exception JSONException
     *                If there is a syntax error in the source string or a
     *                duplicated key.
     */
    public JSONObjectWrapper(String source) throws JSONException
    {
        super(source);
    }

    
    
    /**
     * Get the string associated with a key.
     *
     * @param key A key string.
     * @return A string which is the value, or null if no value is found.     
     */
    public String getString(String key)
    {
        try
        {
            return super.getString(key);
        }
        catch (JSONException ex)
        {
            return null;
        }
    }
}
