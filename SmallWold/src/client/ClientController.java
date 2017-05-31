package client;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ClientController {
	
	@FXML private Button joinButton;
	@FXML private TextField username;
	@FXML private TextField serverIP;
	
	public void joinServer() {
		joinButton.setDisable(true);
		ClientMain.loadServer(serverIP.getText(), username.getText());
	}

}
