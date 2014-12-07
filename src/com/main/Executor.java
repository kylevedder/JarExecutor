/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kyle
 */
public class Executor
{

    private ProcessBuilder builder;

    private Process process = null;

    private OutputStream stdin = null;
    private InputStream stdout = null;
    private BufferedReader reader = null;
    private BufferedWriter writer = null;

    /**
     * Creates a new Executor with the given file name and operating directory.
     *
     * @param name Name of the jar.
     * @param path Path to the directory containing the jar.
     */
    public Executor(String name, String path)
    {
        this.builder = new ProcessBuilder("java", "-jar", name + ".jar");
        this.builder.directory(new File(path));
    }
    
    /**
     * Creates a new Executor with the given file name, assuming the file path is included in the name.
     *
     * @param name Name of the jar containing the file path to the jar.
     */
    public Executor(String name)
    {       
        this.builder = new ProcessBuilder("java", "-jar", name + ".jar");
    }

    /**
     * Begin executing the process and initialize all objects for use.
     *
     * @return Success of start.
     */
    public boolean start()
    {
        try
        {
            this.builder.start();
            stdin = process.getOutputStream(); // <- Eh?
            stdout = process.getInputStream();

            reader = new BufferedReader(new InputStreamReader(stdout));
            writer = new BufferedWriter(new OutputStreamWriter(stdin));
            return true;
        }
        catch (IOException ex)
        {
            Logger.getLogger(Executor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
