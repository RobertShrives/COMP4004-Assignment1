package server.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import server.logic.handler.InputHandler;
import server.logic.handler.model.Client;
import server.logic.handler.model.ServerOutput;
import server.logic.tables.FeeTable;
import server.logic.tables.ItemTable;
import server.logic.tables.LoanTable;
import server.logic.tables.TitleTable;
import server.logic.tables.UserTable;
import utilities.Config;
/* Modified method based on the course COMP 3004 example*/
/*Reference:http://people.scs.carleton.ca/~jeanpier//304W16/T1%20TDD/4b-%20ChatExample%20and%20other%20files/*/
public class LibServer implements Runnable{
	int clientCount = 0;
	private Thread thread = null;
	private ServerSocket server = null;
	private HashMap<Integer, ServerThread> clients;
	
	InputHandler handler=new InputHandler();
	private List<Client> clientList=new ArrayList<Client>();
	public LibServer(int port) {
		try {
			
			clients = new HashMap<Integer, ServerThread>();
			server = new ServerSocket(port);
			server.setReuseAddress(true);
			start();
		} catch (IOException ioe) {
			
		}
	}
	
	public void start() {
		if (thread == null) {
			thread = new Thread(this);
			thread.start();
		
			//Initialize the tables
			UserTable.getInstance();
			TitleTable.getInstance();
			ItemTable.getInstance();
			LoanTable.getInstance();
			FeeTable.getInstance();
			
			System.out.println("Server started successfully!");
		}
	}

	public void run() {
		while (thread != null) {
			try {
				
				addThread(server.accept());
			} catch (IOException e) {				
				
			}}
	}

	private void addThread(Socket socket) {
		String message = String.format("%s : Client Address : [%15s] Client Socket: [%-6d]\n", "Client accepted", socket.getRemoteSocketAddress(), socket.getPort());
		
		if (clientCount < Config.MAX_CLIENTS) {
			try {
				ServerThread serverThread = new ServerThread(this, socket);
				serverThread.open();
				serverThread.start();
				clients.put(serverThread.getID(), serverThread);
				this.clientCount++;
			} catch (IOException e) {
				
			}
		} else {
			
		}
	}

	public synchronized void handle(int ID, String input) {
		if (input.equals("Exit")) 
		{
			
			if (clients.containsKey(ID)) {
				clients.get(ID).send("Exit" + "\n");
				remove(ID);
				
			}}

		else 
		{
			ServerThread from = clients.get(ID);			
			
			ServerOutput so;
			String output;
			if(exist(from)){
				int state=clientState(from);
				so=handler.processInput(input,state);
				output=so.getOutput()+"\n";
				from.send(output);
				clientSetState(from,so.getState());
				
			}else{
				Client client=new Client(from,InputHandler.WAITING);
				clientList.add(client);
				so=handler.processInput(input,InputHandler.WAITING);
				output=so.getOutput()+"\n";
				from.send(output);
				clientSetState(from,so.getState());
				
			};
			
	}} 


	private void clientSetState(ServerThread from, int state) {
		int index=0;
		for(int i=0;i<clientList.size();i++){
			if(clientList.get(i).getClient().equals(from)){
				index=i;
			}
		}
		clientList.get(index).setState(state);
		
	}

	private int clientState(ServerThread from) {
		int result=0;
		for(int i=0;i<clientList.size();i++){
			if(clientList.get(i).getClient().equals(from)){
				result=clientList.get(i).getState();
			}
		}
		return result;
	}

	private boolean exist(ServerThread from) {
		boolean result=false;
		for(int i=0;i<clientList.size();i++){
			if(clientList.get(i).getClient().equals(from)){
				result=true;
			}
		}
		return result;
	}

	/** Try and shutdown the client cleanly */
	public synchronized void remove(int ID) {
		if (clients.containsKey(ID)) {
			ServerThread toTerminate = clients.get(ID);
			clients.remove(ID);
			clientCount--;
			toTerminate.close();
			toTerminate = null;
		}
	}

	

}
