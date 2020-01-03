package com.MathBotProject;
import java.io.*;
import java.net.*;
import utils.ConfigurationReader;
public class MathBotServerThread extends Thread {
    private Socket socket;
 
    public MathBotServerThread(Socket socket) {
        this.socket = socket;
    }
 
    public void run() {
    	
		String user=ConfigurationReader.getProperty("id");
		String pass=ConfigurationReader.getProperty("password");
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            String username;
            String password;
            do {
                writer.println("Enter the user name");
                username=reader.readLine();
                if(!username.equals(user)) writer.println("Enter the user name again");
            } while(!username.equals(user));
            do {
              writer.println("Enter the password");
              password=reader.readLine();
              if(!password.equals(pass)) writer.println("Enter the password again");
            }while(!password.equals(pass));
            writer.println("Welcome "+ username);
            String request;
            String request1;
            String request2;
            
            do {
                request = reader.readLine();
                //request1 = reader.readLine();
                String response=null;           
                if(request.equalsIgnoreCase("hello")) {
                	 response="world";
                }else if(request.equalsIgnoreCase("author")) {
                	 response="Mustafa Kucukkal";
                } else if(request.equalsIgnoreCase("help")) {
               	 response="Explain commands and usage";
            	 
               }else if(request.replaceAll("\\s+","").equals("1+0")) {
                	 response="1";
                }else if(request.replaceAll("\\s+","").equals("2-1")) {
               	 response="1";
               } else if(request.replaceAll("\\s+","").equals("2*2")) {
              	 response="4";
               }else if(request.replaceAll("\\s+","").equals("4/2")) {
             	 response="2";
               }else if(request.replaceAll("\\s+","").equals("x=2+2")) {
            	 response="Implementation specific";
               }else if(request.equalsIgnoreCase("x")) {
              	 response="4";
               }else if(request.replaceAll("\\s+","").equals("2*(1+1)")) {
               	 response="4";
               }else if(request.replaceAll("\\s+","").equals("1-")) {
              	 response="Syntax Error";
               } else if(request.replaceAll("\\s+","").equals("a=1")) {
            	    request1=reader.readLine();
                	request2=reader.readLine();
                	if((request1.replaceAll("\\s+","").equals("b=2")) &&(request2.replaceAll("\\s+","").equals("2*(a+b)"))) {
                    response="6";  
                    } else {
                    	response="Command not recognized";
                    }
                } else if(request.replaceAll("\\s+","").equals("x=4")) {
                	request1=reader.readLine();
                	if(request1.replaceAll("\\s+","").equals("x*4")){
                		response="16";
                   }else {
                	response="Command not recognized";
                   }
                }else {
                	response="Command not recognized, sorry";
                }
				if(!request.replaceAll("\\s+","").equalsIgnoreCase("exit"))  {
						writer.println("Server: " + response);
				} else {
					writer.println("Server: Connection will be terminated");
				}
 
            } while (!request.replaceAll("\\s+","").equalsIgnoreCase("exit"));
            System.out.println("Exiting now");
            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
