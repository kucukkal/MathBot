package com.MathBotProject;

import java.net.*;
import java.io.*;
import utils.ConfigurationReader;
import java.util.Scanner;
/**
 * This program demonstrates a socket client program that talks to a SMTP server.
 *
 * @author www.codejava.net
 */
public class MathBotClient {
 
    public static void main(String[] args) {
    	 String ip=ConfigurationReader.getProperty("server");
	     int port=Integer.parseInt(ConfigurationReader.getProperty("port"));
	     String user=ConfigurationReader.getProperty("id");
	     String password=ConfigurationReader.getProperty("password"); 
 
        try (Socket socket = new Socket(ip, port)) {
 
            InputStream input = socket.getInputStream();
 
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
 
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                            
            Scanner scanner=new Scanner(System.in);
            String command=null;
            String nameline=reader.readLine();
            System.out.println(nameline);
            writer.println(user);
            String pline=reader.readLine();
            System.out.println(pline);
            writer.println(password);
            String welcome=reader.readLine();
            System.out.println(welcome);
            do{
            	System.out.println("Enter the command");
            	command=scanner.nextLine();
            	writer.println(command);
            	 String line = reader.readLine();
                 System.out.println(line);
            } while(!command.equalsIgnoreCase("exit"));  
           
             
        }catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}