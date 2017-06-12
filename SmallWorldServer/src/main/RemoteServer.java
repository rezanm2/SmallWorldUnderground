package main;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import server.ClientSkeleton;


public class RemoteServer extends UnicastRemoteObject{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int amountPlayers;
	private boolean onFirstStart;
	private int port;
	private boolean isRunning;
	private ServerImpl serverImpl;
	private ArrayList<ClientSkeleton> clientList = new ArrayList<ClientSkeleton>();
	//private  ClientSkeleton [] clients;
	protected RemoteServer() throws RemoteException {
		this.port = 1099;
		isRunning = false;
		onFirstStart = true;
		//super(1099);		// Port where RMI Registry listens

	}

	public void startServer(int amount) throws MalformedURLException {					// server requirs a amount of players
		this.amountPlayers = amount;
		try {

			if(onFirstStart == true) {									// if on first start
				LocateRegistry.createRegistry(port);					// creates a registery at the portnumber (1099)
				System.out.println("Server: connected to RMI registry.");
				onFirstStart = false;									// sets the firststart on false
			}
					if(isRunning == true)										// if the server is on
					{
						System.out.println("Server already running");
					}
					else
					{
						System.out.println("Amount of players: " + amountPlayers);
						isRunning = true;										// sets isRunning to true
						serverImpl = new ServerImpl(this);							// creates a serverimplementation						Naming.rebind("ServerService", serverImpl);
						System.out.println("Server: server registered as \'ServerService\' in RMI registry.");
						System.out.println("Server is running");
					}
				} catch (ExportException e) {
					System.out.println("Server already running");
				} catch (RemoteException e) {
					e.printStackTrace();
				}
	}
	public synchronized void addClient(ClientSkeleton client) throws RemoteException {
		if (this.clientList.size() < amountPlayers){
			System.out.println("Server: adding Client");
			this.clientList.add(client);
			System.out.println("Server: Client added");
			client.notifyMessage("Server: Server joined!!");
			client.updatePlayerList(clientList);
		}else {
			System.out.println("SERVER IS FULL");
			client.notifyMessage("Failed joining: server is full");

		}
	}

	/*
	public synchronized void addClient(ClientSkeleton client) throws IOException {
		try {

			Registry registry = LocateRegistry.getRegistry(ip, 1098);		// locates the client registery on the ip
			Clients[i] = (ClientSkeleton) registry.lookup("client");		// looks up the "client" and adds it to the array
			i++;
			System.out.println(i + " added client");
			if(i == amountPlayers){
																			//game is full - send signal to start the game;
				System.out.println("Game is full - Starting game...");

					Clients[0].startGame();
					//Clients[1].startGame();
			}
			} catch (ArrayIndexOutOfBoundsException AIB) {
				System.out.println("Server is vol");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
			*/
		}




