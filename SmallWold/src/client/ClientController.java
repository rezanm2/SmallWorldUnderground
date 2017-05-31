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
	
	private Label [] spelers = new Label [5];
	private int aantSpelersatm = 1;
	
	public void joinServer() throws RemoteException {
		initLabel();
		joinButton.setDisable(true);
		ClientMain.loadServer(serverIP.getText(), username.getText());
		ClientMain.joinServer();
		setOtherPlayers();
	}
	
	public void initLabel() {
		spelers [0] = player1;
		spelers [1] = player2;
		spelers [2] = player3;
		spelers [3] = player4;
		spelers [4] = player5;
	}
	
	public void setOtherPlayers() throws RemoteException {
		for(int j = 0; j < aantSpelersatm; j++)
		{
			spelers[j].setText(ClientMain.getUsername(j));
		}
		aantSpelersatm++;
		
	}

}
