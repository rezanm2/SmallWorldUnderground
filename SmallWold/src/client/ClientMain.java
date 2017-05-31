package client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AccessException;
import java.rmi.NoSuchObjectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.ServerSkeleton;

public class ClientMain extends Application{

	private static Registry registry;
	private static ClientImpl clientImpl;
	private static ServerSkeleton serverSkeleton;
	
	public static void main(String[] args) throws RemoteException {
		System.out.println(ClientMain.getHostIP());
		launch();
	}
	
	public static String getHostIP() {
		InetAddress address = null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} 
	    return address.getHostAddress();
	}
	
	
	public static void startClientserver(String username) {
		try {
			clientImpl = new ClientImpl(getHostIP(), username); // create calculator and treat as Calculator
			ClientSkeleton clientSkeleton = (ClientSkeleton) UnicastRemoteObject.exportObject(clientImpl, 0); // cast to remote object
			registry = LocateRegistry.createRegistry(1098); // default port 1099 // run RMI registry on local host
			registry.rebind("client", clientSkeleton); // bind calculator to RMI registry
	        System.out.println("Clientserver running");
		} catch(RemoteException e) {
			System.out.println(e);
		};
	}
	
	public static void stopClientserver() {
		System.out.println("Shutting down");
		try {
        	registry.unbind("client");
			UnicastRemoteObject.unexportObject(clientImpl, true);
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
	
	public static void loadServer(String ServerIP, String username) {
		try {
			Registry registry = LocateRegistry.getRegistry(ServerIP);
			serverSkeleton = (ServerSkeleton) registry.lookup("server");
			startClientserver(username);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void joinServer() throws RemoteException {
		serverSkeleton.addClient(getHostIP());
	}
	
	public static String getUsername(int pos) throws RemoteException {
		return serverSkeleton.giveUsername(pos);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent View = FXMLLoader.load(getClass().getResource("Client.fxml")); 
		Scene scene = new Scene(View);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(e -> stopClientserver());
	}

	public static int getamountPlayers() throws RemoteException {
		return serverSkeleton.getamountPlayers();
	}
	
	

}
