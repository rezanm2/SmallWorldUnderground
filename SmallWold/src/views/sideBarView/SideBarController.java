package views.sideBarView;

import java.rmi.RemoteException;

import controllers.TurnController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import player.Player;
import views.manualView.ManualController;
import views.settingView.SettingController;
import views.tabView.TabViewController;


public class SideBarController {

    private TabViewController tabViewControl;
    private ManualController manualController;
    private Player selfPlayer;
    private TurnController turnControl;
    private SettingController settingController;

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
    public void hideDeclineButton(){
    		this.declinePane.setVisible(false);
    }

    public void openManual()
    {
    	manualController.openManual();
    }
    public void openSetting()
    {
    	settingController.openSetting();
    }

	public void UpdateText(String message) {
		turn_label.setText(message);
	}


	public void setPlayer(Player selfPlayer) {
		this.selfPlayer = selfPlayer;

	}
	public void setTurnController(TurnController turnController){
		this.turnControl = turnController;
	}

	public void endTurn() throws RemoteException{
		System.out.println("pressed");
		turnControl.endPhase();
		//turnControl.calculateNewBalance();
	}
	public void startTurn(){
	//	turnControl
	}

	public void updateVisibleButton(){
		if(buttonPane.isVisible()){
			buttonPane.setVisible(false);
		}else{
			buttonPane.setVisible(true);
		}
	}

	public void updateButtonText(String string) {
		this.endButtonLabel.setText(string);

	}

}
