/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import com.main.jario.JarIOEnum;
import com.main.jario.JarIOObjectHandler;
import com.main.jario.JarIOPrintText;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Kyle
 */
public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        ProcessBuilder builder = new ProcessBuilder("java", "-jar", "JarExecutorTestJar.jar");
        builder.directory(new File("D:\\Documents\\NetBeansProjects\\JarExecutorTestJar\\dist"));
        Process process = builder.start();

        OutputStream stdin = process.getOutputStream();
        InputStream stdout = process.getInputStream();

        StreamsHandler io = new StreamsHandler(stdin, stdout);                
        JarIOObjectHandler jarIOHandler = null;        
        while (io.hasNext())
        {            
            String read = io.read();    
            jarIOHandler = new JarIOObjectHandler(read);            
//            System.out.println( "Type: " + lw.getType() + " Msg: " + lw.getMessage());
            if(jarIOHandler.getType() == JarIOEnum.PRINT_TEXT)
            {                
                JarIOPrintText pt = (JarIOPrintText)jarIOHandler.getObject();
                System.out.println(pt.getMessage());                
            }
            else if(jarIOHandler.getType() == JarIOEnum.SEND_TEXT)
            {                         
                io.write("Hello");
            }            
        }       
        System.out.println("<Done>");
    }
}
