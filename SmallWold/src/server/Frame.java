package server;

import java.rmi.RemoteException;

public class Frame implements Freem {

	protected Frame() throws RemoteException {
	}

	public void printkaas() throws RemoteException {
		System.out.println("Kftgyjkhjaas");
		
	}
	
	public void zegiets(String text) {
		System.out.println(text);
	}

	public String clickok(String input) {
		Server.addClient(input);
		int waitTime = 0;
		while (Server.isVol() && waitTime  < 120) {
			System.out.println("Henk");
			try {
				Thread.sleep(1000);
				waitTime = waitTime++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int j = 0; j < 5; j++)
		{
			System.out.println(Server.getClient(j));
		}
		return "Server = vol";
		
	}

}
