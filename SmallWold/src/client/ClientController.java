package client;

import java.rmi.ConnectException;
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
	
	private Label [] players = new Label [5];
	
	public void joinServer() throws RemoteException {
		initLabel();
		try {
			ClientMain.loadServer(serverIP.getText(), username.getText());
			ClientMain.joinServer();
		} catch (ConnectException f) {
			System.out.println("Cannot connect to server");
		}
		setOtherPlayers();
		joinButton.setDisable(true);
	}
	
	public void initLabel() {
		players [0] = player1;
		players [1] = player2;
		players [2] = player3;
		players [3] = player4;
		players [4] = player5;
	}
	
	public void setOtherPlayers() throws RemoteException {
		for(int j = 0; j < ClientMain.getamountPlayers(); j++)
		{
			players[j].setText(ClientMain.getUsername(j));
		}
	}

}
