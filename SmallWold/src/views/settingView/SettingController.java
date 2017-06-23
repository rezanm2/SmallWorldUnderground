package views.settingView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import player.Player;
import races.Empty;
import save.Save;
import views.bottomBarView.BottomBarController;

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

	/**
	 * Zet het actieve ras op decline.
	 */
	public void setDecline()
	{
		//setControllers(bottomBarController);
		player.setDeclineSet(player.getActiveSet());
		System.out.println("Set is now declined");
		System.out.println(player.getDeclineSet().getRace().getName());
		bottomBarController.setDeclineSet();
		bottomBarController.updateDeclineTokens();
		player.setActiveSet(null);
		bottomBarController.setActiveSet();
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


}
