/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main.jario;

/**
 *
 * @author Kyle
 */
public interface JarIOInterface
{
    /**
     * Sets the JSON for this object to operate.
     * @param JSONString 
     */
    public void setJSON(String JSONString);
    
    /**
     * Gets the type of JarIO object
     * @return 
     */
    public JarIOEnum getType();
    
    /**
     * Gets the raw JSON passed into setJSON() function. Simply a convenience function.
     * @return 
     */
    public String getRawJSON();
        
}
