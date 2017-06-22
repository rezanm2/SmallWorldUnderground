package views.settingView;

import java.util.ArrayList;

import client.ClientApplication;
import client.RemoteClient;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.JoinedPlayers;
import player.Player;
import save.Save;

public class SettingController {
	private Save save = new Save();
	@FXML
	private StackPane mainPane;
	private Player player;
	

	public void openSetting()
	{
		if(mainPane.isVisible())
		{
			this.mainPane.setVisible(false);
		}
		else
		{
			this.mainPane.setVisible(true);
		}
		//this.manualPage.setImage(new Image("/images/manual/manual1.jpg"));
	}

	public void SaveGame()
	{
		save.SaveNames(player);
	}

	public void setPlayerRef(Player selfPlayer) {
		this.player = selfPlayer;		
	}

}
