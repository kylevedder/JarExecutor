/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Kyle
 */
public class CommsHandler
{

    private StreamsHandler io;
    
    /**
     * Inits the JSON Handler with the Streams
     * @param writer
     * @param stdout 
     */
    public CommsHandler(BufferedWriter writer, InputStream stdout)
    {
        io = new StreamsHandler(writer, stdout);
    }
    
    /**
     * Inits the Handler with the Streams
     * @param stdin
     * @param stdout 
     */
    public CommsHandler(OutputStream stdin, InputStream stdout)
    {
        io = new StreamsHandler(stdin, stdout);
    }
    
    /**
     * <p>
     * Checks if the communications have a connection and if line avaliable.
     * </p>     
     * <p>
     * May block.
     * </p>
     * @return 
     */
    public boolean hasNext()
    {
        return io.hasNext();
    }
}
