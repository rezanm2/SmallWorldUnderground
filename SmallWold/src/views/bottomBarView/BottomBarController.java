package views.bottomBarView;





import abilities.Fisher;
import abilities.Flocking;
import abilities.Magic;
import abilities.Mining;
import abilities.Muddy;
import abilities.Reborn;
import abilities.Stone;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import main.Set;
import player.Player;
import races.Drow;
import races.Kraken;
import races.Liches;
import races.Mudmen;
import races.Shrooms;

public class BottomBarController {


	private boolean visible;
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
	private HBox abilityTextFieldHBox;

	@FXML
	private Label abilityTextField;

	@FXML
	private HBox raceTextFieldHBox;

	@FXML
	private Label raceTextField;

	@FXML
	private HBox declineAbilityTextFieldHBox;

	@FXML
	private Label declineAbilityTextField;

	@FXML
	private HBox declineRaceTextFieldHBox;

	@FXML
	private Label declineRaceTextField;

	@FXML
	private ImageView relicOne;

	@FXML
	private ImageView relicTwo;

	@FXML
	private ImageView specialPlaceOne;

	@FXML
	private ImageView specialPlaceTwo;


	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

	public void setActiveSet() {
		activeRace.setImage(new Image("/images/races/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
		activeAbility.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));

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
		if(abilityTextFieldHBox.isVisible() == false)
		{
			selfPlayer.setActiveSet(new Set(new Fisher(), new Shrooms()));


			abilityTextField.setText(selfPlayer.getActiveSet().getAbility().getTraitText());
			abilityTextFieldHBox.setVisible(true);
		}

		else
		{
			abilityTextFieldHBox.setVisible(false);
		}
	}

	@FXML
	public void showRaceTraitText()
	{
		if(raceTextFieldHBox.isVisible() == false)
		{
			selfPlayer.setActiveSet(new Set(new Fisher(), new Shrooms()));

			raceTextField.setText(selfPlayer.getActiveSet().getRace().getTraitText());
			raceTextFieldHBox.setVisible(true);
		}

		else
		{
			raceTextFieldHBox.setVisible(false);
		}
	}

	@FXML
	public void showDeclineRaceTraitText()
	{
		if(declineRaceTextFieldHBox.isVisible() == false)
		{
			selfPlayer.setDeclineSet(new Set(new Flocking(), new Mudmen()));

			declineRaceTextField.setText(selfPlayer.getDeclineSet().getRace().getDeclineTraitText());
			declineRaceTextFieldHBox.setVisible(true);
		}

		else
		{
			declineRaceTextFieldHBox.setVisible(false);
		}
	}

	@FXML
	public void showDeclineAbilityTraitText()
	{
		if(declineAbilityTextFieldHBox.isVisible() == false)
		{
			selfPlayer.setDeclineSet(new Set(new Flocking(), new Mudmen()));

			declineAbilityTextField.setText(selfPlayer.getDeclineSet().getAbility().getDeclineTraitText());
			declineAbilityTextFieldHBox.setVisible(true);
		}

		else
		{
			declineAbilityTextFieldHBox.setVisible(false);
		}
	}


}
