package views.bottomBarView;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import player.Player;

public class BottomBarController {
	private Player selfPlayer;
	
	@FXML
	private ImageView activeRace;
	
	@FXML
	private ImageView activeAbility;
	

	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}
	
	public void setActiveSet() {
		activeRace.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
		activeRace.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));

	}

}
