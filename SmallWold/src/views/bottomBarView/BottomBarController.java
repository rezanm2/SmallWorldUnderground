package views.bottomBarView;



import com.sun.glass.events.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import player.Player;
import races.Drow;

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
	private TextField abilityTextField;

	int randomNumber = 0;

	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

	public void setActiveSet() {
//		activeRace.setImage(new Image("/images/races/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
	//	activeAbility.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));

	}

	@FXML
	public void updateCurrentTokens()
	{

		selfPlayer.getHand().setCurrentTokens((selfPlayer.getHand().getCurrentTokens() + 1)); 	//Remove the +1 when there's actual value
		currentTokens.setText(String.valueOf(selfPlayer.getHand().getCurrentTokens()) + "/14");	//Add player's race maxTokens

	}

	public void updateDeclineTokens()
	{

		selfPlayer.getHand().setDeclineTokens(selfPlayer.getHand().getDeclineTokens() + 1);


		declineTokens.setText(String.valueOf(selfPlayer.getHand().getDeclineTokens()));
	}

	public void updatePlayerCoins()
	{

		selfPlayer.setCoins(selfPlayer.getCoins() + 1 // + tokenController.getDeclineTokens
				);
		ownCoins.setText(String.valueOf(selfPlayer.getCoins()));

	}

	@FXML
	public void showAbilityTraitText()
	{
		abilityTextField.setVisible(true);
	}

	@FXML
	public void hideAbilityTraitText()
	{
		abilityTextField.setVisible(true);
	}



}
