/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class StreamsHandler
{
    BufferedWriter writer;
    InputStream stdout;
    Scanner sc;

    /**
     * Inits the IOHandler with BufferedReaders and InputStreams as parameters.
     * @param writer 
     * @param stdout
     */
    public StreamsHandler(BufferedWriter writer, InputStream stdout)
    {
        this.writer = writer;
        this.stdout = stdout;
        this.sc = new Scanner(stdout);        
    }

    /**
     * Inits the IOHandler with OutputStreams and InputStreams as parameters.
     * @param stdin
     * @param stdout 
     */
    public StreamsHandler(OutputStream stdin, InputStream stdout)
    {
        this.stdout = stdout;
        this.writer = new BufferedWriter(new OutputStreamWriter(stdin));
        this.sc = new Scanner(stdout);
    }
    
    /**
     * Writes out to the stream
     * @param s String to write
     * @return success of write
     */
    public boolean write(String s)
    {
        System.out.println("IN:  " + s);
        try
        {
            this.writer.write(s + "\n");            
            this.writer.flush();
            return true;
        }
        catch (IOException ex)
        {
            Logger.getLogger(StreamsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }        
    
    /**
     * Checks for a next line, or blocks until one is avaliable.
     * @return 
     */
    public boolean hasNext()
    {
        return sc.hasNextLine();
    }
    
    /**
     * <p>
     * Reads the next line of text, or blocks until it does.
     * </p>
     * Returns null if stream is closed.
     * @return 
     */
    public String read()
    {
        if(sc.hasNextLine())
        {
            return sc.nextLine();
        }
        return null;
    }
    
    
}
