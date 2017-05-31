package client;

import java.rmi.RemoteException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientController {
	
	@FXML private Button joinButton;
	@FXML private TextField username;
	@FXML private TextField serverIP;
	@FXML private Label player1;
	@FXML private Label player2;
	@FXML private Label player3;
	@FXML private Label player4;
	@FXML private Label player5;
	
	public void joinServer() throws RemoteException {
		joinButton.setDisable(true);
		ClientMain.loadServer(serverIP.getText(), username.getText());
		ClientMain.joinServer();
		//setOtherPlayers();
	}
	/*
	public void setOtherPlayers() throws RemoteException {
		player1.setText(ClientMain.getUsername(0));
		player2.setText(ClientMain.getUsername(1));
	}*/

}
