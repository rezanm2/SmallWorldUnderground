package views.settingView;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import models.StackSet;
import player.Player;
import races.Empty;
import save.Save;
import views.bottomBarView.BottomBarController;
import views.fieldView.FieldViewController;

/**
 * Verzorgt het updaten en de input van de settingView.
 * @author Reza Naser
 */
public class SettingController {
	private Save save = new Save();
	@FXML
	private StackPane mainPane;
	@FXML
	private Label lable;
	private Player player;
	private BottomBarController bottomBarController;
	private int count = 0;
	private FieldViewController field;
	private StackSet stackset;
	public void setControllers(BottomBarController bottomBarControl) {
		bottomBarController = bottomBarControl;
	}
	/**
	 * Opent en sluit de settingview.
	 */
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
    public void setStackRef(StackSet stack){
    	this.stackset = stack;
    }

	/**
	 * Zet het actieve ras op decline.
	 * @throws RemoteException 
	 */
	public void setDecline() throws RemoteException
	{
		stackset.getStackController().setDecline();
		//setControllers(bottomBarController);
		player.setDeclineSet(player.getActiveSet());
		System.out.println("Set is now declined");
		System.out.println(player.getDeclineSet().getRace().getName());
		bottomBarController.setDeclineSet();
		for(int x=0;x<field.getMap().getTerrains().size();x++)
		{
			if(field.getMap().getTerrains().get(x).getRace() == player.getDeclineSet().getRace())
			{
				count++;
			}
		}
		player.getHand().setDeclineTokens(count);
		bottomBarController.updateDeclineTokens();
		player.setActiveSet(null);
		player.getHand().setCurrentTokens(0);
		bottomBarController.setActiveSet();
		count = 0;
		//JOptionPane.showMessageDialog(null, "Active set now declined");
	}

	/**
	 * Slaat het spel op.
	 */
	
	public void SaveGame()
	{
		save.SaveNames(player);
	}

	public void setPlayerRef(Player selfPlayer) {
		this.player = selfPlayer;
	}
	public void setControllers(FieldViewController fieldController) {
		this.field = fieldController;
	}


}
