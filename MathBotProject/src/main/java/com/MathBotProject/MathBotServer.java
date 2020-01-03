package com.MathBotProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import utils.ConfigurationReader;
 
public class MathBotServer {
 static String pt=ConfigurationReader.getProperty("port");
		 public static void main(String[] args) {
      //  if (args.length < 1) return;
 
        int port = Integer.parseInt(pt);
        		//Integer.parseInt(args[0]);
        System.out.println("port:" + port);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Server is listening on port " + port);
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
 
                new MathBotServerThread(socket).start();
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
