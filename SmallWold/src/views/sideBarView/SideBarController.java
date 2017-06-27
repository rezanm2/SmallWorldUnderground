package views.sideBarView;

import java.rmi.RemoteException;

import controllers.TurnController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import player.Player;
import views.bottomBarView.BottomBarController;
import views.manualView.ManualController;
import views.settingView.SettingController;
import views.tabView.TabViewController;

/**
 * Deze klasse regelt de updates van de sidebarview en krijgt de input van die view.
 * @author Wim van der Putten, Reza Naser
 */

public class SideBarController {

    private TabViewController tabViewControl;
    private ManualController manualController;
    private Player selfPlayer;
    private TurnController turnControl;
    private SettingController settingController;
    private BottomBarController bottomBarController;

    @FXML
    private ImageView tabImage;

    @FXML
    private Label turn_label;
    @FXML
    private Label endButtonLabel;
    @FXML
   private StackPane buttonPane;

    @FXML
    private ImageView endTurnButton;


    @FXML
    private StackPane declinePane;



    /**
     * Zet de text van de endturnbutton op leeg.
     */
    @FXML
    public void initialize() {
       //greyout button.
    	endButtonLabel.setText("");
    }


    public void setControllers(TabViewController controller){
    	tabViewControl = controller;
    }
    public void setControllers(ManualController controller){
    	manualController = controller;
    }
    public void setControllers(SettingController controller){
    	settingController = controller;
    }

    public void changeImagePressed(){
    	tabImage.setImage(new Image("/images/icons/tab-bar-stripes-pressed.png"));
    }
    public void changeImageReleased(){
    	tabImage.setImage(new Image("/images/icons/tab-bar-stripes.png"));
    }

    /**
     * Verbergt of laat de tabview zien.
     */
    @FXML
    private void tabButtonPress() {
    	if(!tabViewControl.isVisible()){
    		tabImage.setImage(new Image("/images/icons/tab-bar-stripes-pressed.png"));
    		tabViewControl.showView();
    	}else{
    		tabViewControl.hideView();
    		tabImage.setImage(new Image("/images/icons/tab-bar-stripes.png"));
    	}

    }
    @FXML
	public void setDecline() throws RemoteException
	{
		selfPlayer.setDeclineSet(selfPlayer.getActiveSet());
		System.out.println("Set is now declined");
	//	System.out.println(selfPlayer.getDeclineSet().getRace().getName());
		bottomBarController.setDeclineSet();
		bottomBarController.updateDeclineTokens();
		selfPlayer.setActiveSet(null);
		bottomBarController.setActiveSet();
		turnControl.setPhase(2);
		turnControl.endPhase();

	}



    /**
     * Laat het manualscherm zien.
     */
    public void openManual()
    {
    	manualController.openManual();
    }
    /**
     * Laat het settingscreen zien.
     */
    public void openSetting()
    {
    	settingController.openSetting();
    }


    /**
     * Update het turn_label.
     * @param message, een string die laat zien wie zijn beurt het is.
     */
	public void UpdateText(String message) {
		turn_label.setText(message);
	}


	public void setPlayer(Player selfPlayer) {
		this.selfPlayer = selfPlayer;

	}
	public void setTurnController(TurnController turnController){
		this.turnControl = turnController;
	}
	public void setBottomBarCOntroll( BottomBarController bottomBarController){
		this.bottomBarController = bottomBarController;
	}

	/**
	 * Beeindigt de beurt voor de speler.
	 * @throws RemoteException, de error die optreedt als er iets verkeerd is gegaan met de communicatie.
	 */
	public void endTurn() throws RemoteException{
		System.out.println("pressed");
		turnControl.endPhase();
		//turnControl.calculateNewBalance();
	}
	public void startTurn(){
	//	turnControl
	}

	/**
	 * Update of de buttonPane zichtbaar is of niet.
	 */
	public void updateVisibleButton(){
		if(buttonPane.isVisible()){
			buttonPane.setVisible(false);
		}else{
			buttonPane.setVisible(true);
		}
	}

	public void showButton(){
		buttonPane.setVisible(true);
	}
	public void hideButton(){
		buttonPane.setVisible(false);
	}
	public void showDeclineButton(){
		declinePane.setVisible(true);
	}
    /**
     * Verbergt de declineknop.
     */
    public void hideDeclineButton(){
    		this.declinePane.setVisible(false);
    }

	/**
	 * Update de text die op de endturn button staat.
	 * @param string, het bericht die op de button moet staan.
	 */
	public void updateButtonText(String string) {
		this.endButtonLabel.setText(string);

	}

}
