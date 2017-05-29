package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server{
	
	public static String [] Clients = new String [5];
	static int i = 0;

	private void renserver() {
		try {
			Frame calcImpl = new Frame(); // create calculator and treat as Calculator
			Freem calcSkeleton = (Freem) UnicastRemoteObject.exportObject(calcImpl, 0); // cast to remote object
			System.out.println("Freem skeleton created");
			Registry registry = LocateRegistry.createRegistry(1099); // default port 1099 // run RMI registry on local host
			System.out.println("RMI Registry starter");
			registry.rebind("Frame", calcSkeleton); // bind calculator to RMI registry
	        System.out.println("Frame skeleton bound");
	        System.out.println("Server running...");
	        System.out.println(registry.toString());
		} catch(RemoteException e) {
			System.out.println(e);
		};
	}
		
		public static void main(String[] args){
			new Server().renserver();
		}
		
		public static void addClient(String naam) {
			try {
			Clients[i] = new String(naam);
			i++;
			} catch (ArrayIndexOutOfBoundsException AIB) {
				System.out.println("Server is vol");
			}
		}
		
		public static boolean isVol() {
			return i < 5;
		}
		
		public static String getClient(int pos) {
			return Clients[pos];
		}

	}


