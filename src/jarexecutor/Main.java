/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jarexecutor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import org.json.*;

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
        LineWrapper lw = null;        
        while (io.hasNext())
        {            
            String read = io.read();
            lw = new LineWrapper(read);
//            System.out.println( "Type: " + lw.getType() + " Msg: " + lw.getMessage());
            if(lw.getType() == Type.TEXT)
            {
                System.out.println("OUT: " + lw.getMessage());
            }
            else if(lw.getType() == Type.COMMAND_WRITE)
            {                         
                io.write("Hello");
            }            
        }       
        System.out.println("<Done>");
    }
}
