package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


public class Beeld extends Stage/* implements Freem*/{
	
	Label label;
	String naam;
	TextField tf;
	
	public Beeld() {
		BorderPane bp = new BorderPane();
		tf = new TextField();
		Button b = new Button("Waiting for other players");
		bp.setCenter(b);
		Scene s = new Scene(bp, 400, 400);
		setScene(s);
		try {
			
			System.out.println("Getting access to the registry");
			// get access to the RMI registry on the remote server
			Registry registry = LocateRegistry.getRegistry("localhost"); // if server on another machine: provide that machine's IP address. Default port  1099				
			System.out.println("Getting the Calculator stub from registry");
            Freem freem = (Freem) registry.lookup("Frame"); // get remote Calculator object from registry
            b.setOnAction(e -> {
					//b.setText("wot");
					naam = tf.getText();
					/*b.setDisable(true);
					try {
						freem.clickok(naam);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}*/
					client.Thread t = new client.Thread(naam, freem);
					t.run();
            });
		} catch(Exception e) {
			System.out.println(e);
		} 
		label = new Label();
		label.setTextAlignment(TextAlignment.CENTER);
		bp.setTop(label);
		bp.setBottom(tf);
		show();
	}
	/*
	public static void setNumber(int integer) {
		tf.setText(Integer.toString(integer));
	}*/
/*
	@Override
	public void clickok() {
		f.clickok();
	}

	@Override
	public void printkaas() throws RemoteException {
		
	}

	@Override
	public void zegiets(String text) throws RemoteException {
		
	}
*/
}