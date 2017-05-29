package client;

import java.rmi.RemoteException;

import server.Freem;

public class Thread implements Runnable{

	Freem freem;
	String naam;
	
	public Thread(String naam, Freem freem) {
		this.naam = naam;
		this.freem = freem;
	}
	
	@Override
	public void run() {
		try {
			freem.clickok(naam);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}


