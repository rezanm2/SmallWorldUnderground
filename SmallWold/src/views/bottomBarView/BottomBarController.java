package views.bottomBarView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import player.Player;

public class BottomBarController {



	private boolean firstTime = true;





	private Player selfPlayer;

	@FXML
	private ImageView activeRace;

	@FXML
	private ImageView activeAbility;

	@FXML
	private Label currentTokens;

	@FXML
	private Label declineTokens;

	@FXML
	private Label ownCoins;

	@FXML
	private Label label;

	public void setPlayerRef(Player selfPlayer) {
	//	this.selfPlayer = selfPlayer;
	}

	public void setActiveSet() {
		activeRace.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
		activeRace.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));

	}

	public void updateCurrentTokens()
	{
		currentTokens.setText(String.valueOf(selfPlayer.getHand().getCurrentTokens()) + "/" +
				String.valueOf(selfPlayer.getActiveSet().getRace().getMaxTokens()));
	}

	public void updateDeclineTokens()
	{

	}

	public void updatePlayerCoins()
	{
		if(firstTime == true)
		{
			this.selfPlayer = new Player();
			firstTime = false;
		}
		else
		{
		selfPlayer.setCoins(selfPlayer.getCoins() // + tokenController.getDeclineTokens
				);
		ownCoins.setText(String.valueOf(selfPlayer.getCoins()));
		}
	}

}
