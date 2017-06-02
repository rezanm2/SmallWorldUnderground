package server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;
import java.rmi.server.UnicastRemoteObject;

import client.ClientSkeleton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ServerMain extends Application{

	private static boolean isRunning = false;
	private static boolean onFirstStart = true;
	private static Registry registry;
	private static ServerImpl serverImpl;
	private static int portNumber = 1099;
	private static ClientSkeleton [] Clients;
	 private static int i = 0;
	
	public static void main(String[] args) {
		launch();														// starts the javafx application
	}
	
	public static void startServer(int amountPlayers) {					// server requirs a amount of players
		try {
			if(onFirstStart == true) {									// if on first start
				registry = LocateRegistry.createRegistry(portNumber);	// creates a registery at the portnumber (1099)
				onFirstStart = false;									// sets the firststart on false
			}
			if(isRunning == true)										// if the server is on
			{
				System.out.println("Server already running");
			}
			else
			{
				Clients = new ClientSkeleton [amountPlayers];			// makes the client array with the amount of selected players
				System.out.println("Amount of players: " + amountPlayers);	
				isRunning = true;										// sets isRunning to true
				serverImpl = new ServerImpl();							// creates a serverimplementation 
				ServerSkeleton serverSkeleton = (ServerSkeleton) UnicastRemoteObject.exportObject(serverImpl, 0);	// creates the serverskeleton as an export object
				registry.rebind("server", serverSkeleton);				// binds object on the registery with the name server
				System.out.println("Server is running");
			}
				} catch (ExportException e) {
					System.out.println("Server already running");
				} catch (RemoteException e) {
					e.printStackTrace();
				}					
	}
	
	public static void stopServer() {
		try {
			registry.unbind("server");								//unbinds the serverobject
			System.out.println("Shutting down");					
			UnicastRemoteObject.unexportObject(serverImpl, true);	//unexports the object from the server
			isRunning = false;										// sets isRunning false so the server is off
		} catch (NoSuchObjectException e) {
			e.printStackTrace();
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("Server is al uit");
		} catch (NullPointerException e) {
			System.out.println("Server is al uit");
		}
	}
	
	public static void addClient(String ip) throws RemoteException {
		try {
			Registry registry = LocateRegistry.getRegistry(ip, 1098);		// locates the client registery on the ip
			Clients[i] = (ClientSkeleton) registry.lookup("client");		// looks up the "client" and adds it to the array
			i++;															
			System.out.println(i + " added client");
			} catch (ArrayIndexOutOfBoundsException AIB) {
				System.out.println("Server is vol");
			} catch (RemoteException e) {
				e.printStackTrace();
			} catch (NotBoundException e) {
				e.printStackTrace();
			}
		}

	@Override
	public void start(Stage primaryStage) throws Exception {
        Parent View = FXMLLoader.load(getClass().getResource("Server.fxml")); 	// connects with the view
        Scene scene = new Scene(View);											// sets view
        primaryStage.setScene(scene);					
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> stopServer());						// on close the server shutsdown
	}
	
	public static String getHostIP() {											// this method gets the serverIP
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
	    return address.getHostAddress();
	}
	
	public static ClientSkeleton getClient(int pos) {							// returns a client
		return Clients[pos];
	}
	
	public static String getClientUsername(int pos) throws RemoteException {	// returns a clients username
		return Clients[pos].getUsername();
	}

}
