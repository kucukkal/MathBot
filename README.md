# MathBot
I created this assignment as a maven project. Before using, update the maven dependencies using pom.xml file located in the main directory.
The main TCP/IP server program is MathBotServer.java which handles multiple clients. It creates a new MathBotServerThread for every socket client. The MathBotServerThread.java program is the class file that handles each socket.
I used Eclipse IDE to create this project and run the MathBothServer.
It requires execution environment JavaSE 1.7 or higher and the program is written in Java 8.
The server, port, user id and password are stored in configuration.properties file and they have to be changed based on the credentials of the tester. These data is accessed by ConfigurationReader.java class loacted in the utils directory. This class is imported to all three programs.
 The MathBotClient.java is a client program to test the MathBotServer program. You do not need to enter any credentials for this program since it sends the username and password to the server itself. You can enter any command from the list below as an user input and will receive a response for each command. 
 Outline of ServerProgram function
 After the client is connected, server asks the user name and password (very simple authentication) then server recieves commands and sends response to client.
 
 Available commands;
   1) exit (terminates the connection)
   2) hello
   3) author
   4) help
   5) 1 + 0
   6) 2 * 2
   7) 2 - 1   
   8) 4 / 2
   9) x = 2 + 2
   10) x
   11) 1 -
   12) 2 * ( 1 + 1 ) 
   13) a) x = 4 b)  x * 4    
   14) a) a =1 b) b = 2 c) 2 * ( a + b )   
   ***The last two commands are multiple commands where you send the server in the given order.
   Telnet connection: You can connect to tcp/ip server program by writing "telnet [Host IP] [Port] " in the command line. In telnet window you need to enter the username and password to pass the authentication. After entering username and password, you can enter any command in the list by just typing the command and hitting the return key. Each sent command will receive a response from the server.
