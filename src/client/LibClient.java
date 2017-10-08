package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/* Modified method based on the course COMP 3004 example*/
/*Reference:http://people.scs.carleton.ca/~jeanpier//304W16/T1%20TDD/4b-%20ChatExample%20and%20other%20files/*/
public class LibClient implements Runnable{
	private int ID = 0;
	private Socket socket            = null;
	private Thread thread            = null;
	private ClientThread   client    = null;
	private BufferedReader console   = null;
	private BufferedReader streamIn  = null;
	private BufferedWriter streamOut = null;
	
	
	public LibClient (String serverName, int serverPort) {  
		System.out.println("Connecting to the server. Please wait ...");
		try {  
			this.socket = new Socket(serverName, serverPort);
			this.ID = socket.getLocalPort();
			
	    	this.start();
	    	System.out.println("Welcome To Rob's Library!");
	    	System.out.println("Type Greeting To Start!");
		} catch(UnknownHostException uhe) {  
			System.err.println(ID + ": Unknown Host");
			String message = String.format("Exception thrown : %s \n", uhe.getMessage());
		
		} catch(IOException ioe) {  
			System.out.println(ID + ": Unexpected exception");
			String message = String.format("Exception thrown : %s \n", ioe.getMessage());
			
			System.out.println("Fail to connect to the server,please try later!");
	   }
	}

	public int getID () {
		return this.ID;
	}
	
   public void start() throws IOException {  
	   try {
	   	   console	= new BufferedReader(new InputStreamReader(System.in));
		   streamIn	= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		   streamOut = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		   if (thread == null) {  
		   	  client = new ClientThread(this, socket);
		      thread = new Thread(this);                   
		      thread.start();
		   }
	   } catch (IOException ioe) {
		   String message = String.format("Exception thrown : %s \n", ioe.getMessage());
			
         throw ioe;
	   }
   }

	public void run() { 
		while (thread != null) {  
			try {  
				if (streamOut != null) {
					streamOut.flush();
					streamOut.write(console.readLine() + "\n");
				} else {
					System.out.println(ID + ": Stream Closed");
				}
         }
         catch(IOException e) {  
        	String message = String.format("Exception thrown : %s \n", e.getMessage());
 			
         	stop();
         }}
   }

   public void handle (String msg) {
   	if (msg.equalsIgnoreCase("Exit")) {  
			System.out.println("Good bye.");
			stop();
		} else {
			System.out.println(msg);
		}
   }

   public void stop() {  
      try { 
      	if (thread != null) thread = null;
    	  	if (console != null) console.close();
    	  	if (streamIn != null) streamIn.close();
    	  	if (streamOut != null) streamOut.close();

    	  	if (socket != null) socket.close();

    	  	this.socket = null;
    	  	this.console = null;
    	  	this.streamIn = null;
    	  	this.streamOut = null;    	  
      } catch(IOException ioe) {  
    	  String message = String.format("Exception thrown : %s \n", ioe.getMessage());
		
      }
      client.close();  
   }
  
}
