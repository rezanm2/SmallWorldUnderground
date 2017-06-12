package views.lobbyView;

import java.rmi.ConnectException;
import java.rmi.RemoteException;

import client.ClientMain;
import client.RemoteClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.JoinedPlayers;

public class lobbyController {

	@FXML private Button joinButton;
	@FXML private TextField username;
	@FXML private TextField serverIP;
	@FXML private Label player1;
	@FXML private Label player2;
	@FXML private Label player3;
	@FXML private Label player4;
	@FXML private Label player5;

	private RemoteClient client;


	public void joinServer() throws RemoteException {

		if(username.getText().isEmpty()){
			client.setImplName("player");				//case name is empty give default name (player)
		}else{
			client.setImplName(username.getText());		//case name is filled set name
		}
		if(serverIP.getText().isEmpty()){
			serverIP.setPromptText("Enter an ip.");		//case ip is empty give prompt
		}else{
			client.setHost(serverIP.getText());			//case ip is filled set ip
			client.loadServer();  						//loads the server
			//client.register();
			joinButton.setDisable(true);
		}


	/*	initLabel();
		ClientMain.loadServer(serverIP.getText(), username.getText());
//	ClientMain.joinServer();
		setOtherPlayers();
		joinButton.setDisable(true);
		-*/


	}
	public void setRemoteClient(RemoteClient client){
		this.client  = client;
	}

    @FXML
    private void initialize() {

    }
	public void initLabel() {
		ObservableList<JoinedPlayers> playerList = client.getPlayers();

		player1.textProperty().bind(playerList.get(0).getPlayerNameProperty());
		player2.textProperty().bind(playerList.get(1).getPlayerNameProperty());
		player3.textProperty().bind(playerList.get(2).getPlayerNameProperty());
		player4.textProperty().bind(playerList.get(3).getPlayerNameProperty());
		player5.textProperty().bind(playerList.get(4).getPlayerNameProperty());

	}

	public void setOtherPlayers() throws RemoteException {
		for(int j = 0; j < ClientMain.getamountPlayers(); j++)
		{
			//players[j].setText(ClientMain.getUsername(j));
		}
	}

}
