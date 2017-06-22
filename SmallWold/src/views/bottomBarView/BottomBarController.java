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
import models.Set;
import player.Player;
import races.Drow;
import races.Kraken;
import races.Liches;
import races.Mudmen;
import races.Shrooms;
import relics.FlyingDoormat;
import relics.KillerRabbitSword;
import specialPlaces.DiamondFields;
import specialPlaces.MineOfTheLostDwarf;

public class BottomBarController {


	private boolean visible;
	private boolean firstTime = true;

	private Player selfPlayer;

	@FXML
	private ImageView activeRace;

	@FXML
	private ImageView declineAbility;
	
	@FXML
	private ImageView declineRace;

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
	private ImageView relicOnePicture;

	@FXML
	private ImageView relicTwoPicture;

	@FXML
	private ImageView specialPlaceOnePicture;

	@FXML
	private ImageView specialPlaceTwoPicture;




	@FXML
	private HBox relicOneHBox;

	@FXML
	private Label relicOne;

	@FXML
	private HBox relicTwoHBox;

	@FXML
	private Label relicTwo;

	@FXML
	private Label specialPlaceOne;

	@FXML
	private HBox specialPlaceOneHBox;

	@FXML
	private Label specialPlaceTwo;

	@FXML
	private HBox specialPlaceTwoHBox;




	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

	public void setActiveSet() {
		if(selfPlayer.getActiveSet() != null)
		{
			activeRace.setImage(new Image("/images/races/active/"+selfPlayer.getActiveSet().getRace().getName()+".png"));
			activeAbility.setImage(new Image("/images/abilitys/active/"+selfPlayer.getActiveSet().getAbility().getName()+".png"));
		}
		else
		{
			activeRace.setImage(new Image("/images/races/placeHolder.png"));
			activeAbility.setImage(new Image("/images/abilitys/placeHolder.png"));
		}

	}
	public void setDeclineSet() {
		declineRace.setImage(new Image("/images/races/decline/"+selfPlayer.getDeclineSet().getRace().getName()+".png"));
		declineAbility.setImage(new Image("/images/abilitys/decline/"+selfPlayer.getDeclineSet().getAbility().getName()+".png"));

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
			selfPlayer.setActiveSet(new Set(new Shrooms(), new Fisher()));


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
			selfPlayer.setActiveSet(new Set(new Shrooms(), new Fisher()));

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
			selfPlayer.setDeclineSet(new Set(new Mudmen(), new Flocking()));

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
			selfPlayer.setDeclineSet(new Set(new Mudmen(), new Flocking()));

			declineAbilityTextField.setText(selfPlayer.getDeclineSet().getAbility().getDeclineTraitText());
			declineAbilityTextFieldHBox.setVisible(true);
		}

		else
		{
			declineAbilityTextFieldHBox.setVisible(false);
		}
	}

	public void showRelicOneTraitText()
	{
		if(relicOneHBox.isVisible() == false)
		{
			relicOne.setText(new FlyingDoormat().getTraitText());
			relicOneHBox.setVisible(true);
		}

		else
		{
			relicOneHBox.setVisible(false);
		}
	}

	public void showRelicTwoTraitText()
	{
		if(relicTwoHBox.isVisible() == false)
		{
			relicTwo.setText(new KillerRabbitSword().getTraitText());
			relicTwoHBox.setVisible(true);
		}

		else
		{
			relicTwoHBox.setVisible(false);
		}
	}

	public void showSpecialPlaceOneTraitText()
	{
		if(specialPlaceOneHBox.isVisible() == false)
		{
			specialPlaceOne.setText(new DiamondFields().getTraitText());
			specialPlaceOneHBox.setVisible(true);
		}

		else
		{
			specialPlaceOneHBox.setVisible(false);
		}
	}

	public void showSpecialPlaceTwoTraitText()
	{
		if(specialPlaceTwoHBox.isVisible() == false)
		{
			specialPlaceTwo.setText(new MineOfTheLostDwarf().getTraitText());
			specialPlaceTwoHBox.setVisible(true);
		}

		else
		{
			specialPlaceTwoHBox.setVisible(false);
		}
	}


}
