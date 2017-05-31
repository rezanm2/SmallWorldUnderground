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

import server.ServerSkeleton;

public class ClientMain {

	private static String username = "WAASAW";
	private static Registry registry;
	private static ClientImpl clientImpl;
	private static ServerSkeleton serverSkeleton;
	private static String ServerIP = "145.101.74.50";
	
	public static void main(String[] args) throws RemoteException {
		System.out.println(ClientMain.getHostIP());
		ClientMain.loadServer();
		serverSkeleton.addClient(getHostIP());
		ClientMain.stopClientserver();
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
	
	
	public static void startClientserver() {
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
			e.printStackTrace();
		}
	}
	
	public static void loadServer() {
		try {
			Registry registry = LocateRegistry.getRegistry(ServerIP);
			serverSkeleton = (ServerSkeleton) registry.lookup("server");
			startClientserver();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	

}
