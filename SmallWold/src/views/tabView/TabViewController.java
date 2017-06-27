package views.tabView;


import java.rmi.RemoteException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.StackedAreaChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import models.JoinedPlayers;
import models.Set;
import models.StackSet;
import player.Player;

import views.bottomBarView.BottomBarController;
import views.settingView.SettingController;
import views.sideBarView.SideBarController;
/**
 * Deze klasse regelt de updates van de tabview en krijgt de input van die view.
 * @author Wim van der Putten
 */
public class TabViewController {

	private StackSet stackset;
	private Player selfPlayer;

	@FXML
	private Label gain_1;
	@FXML
	private Label gain_2;
	@FXML
	private Label gain_3;
	@FXML
	private Label gain_4;
	@FXML
	private Label gain_5;
	@FXML
	private Label gain_6;

	@FXML
	private Label costs_1;
	@FXML
	private Label costs_2;
	@FXML
	private Label costs_3;
	@FXML
	private Label costs_4;
	@FXML
	private Label costs_5;
	@FXML
	private Label costs_6;

	@FXML
    private StackPane mainPane;

	@FXML
    private Label player_1;
	@FXML
    private Label player_2;
	@FXML
    private Label player_3;
	@FXML
    private Label player_4;

	@FXML
    private ImageView pick_race_1;

	@FXML
    private ImageView pick_race_2;

	@FXML
    private ImageView pick_race_3;

	@FXML
    private ImageView pick_race_4;

	@FXML
    private ImageView pick_race_5;

	@FXML
    private ImageView pick_race_6;

	@FXML
    private ImageView pick_ability_1;

	@FXML
    private ImageView pick_ability_2;

	@FXML
    private ImageView pick_ability_3;

	@FXML
    private ImageView pick_ability_4;

	@FXML
    private ImageView pick_ability_5;

	@FXML
    private ImageView pick_ability_6;

	@FXML
    private ImageView activePlayer1Race;

	@FXML
    private ImageView activePlayer1Ability;

	@FXML
    private ImageView activePlayer2Race;

	@FXML
    private ImageView activePlayer2Ability;

	@FXML
    private ImageView activePlayer3Race;

	@FXML
    private ImageView activePlayer3Ability;

	@FXML
    private ImageView activePlayer4Race;

	@FXML
    private ImageView activePlayer4Ability;

	private BottomBarController bottomBarController;
	private SettingController settingBarController;
	private SideBarController sidebarController;



	public TabViewController(){

	}

	/**
	 * Handelt het kiezen van een nieuwe set af.
	 * @param ev, de muisklik op een set in de tabview.
	 * @throws RemoteException
	 */
	public void pickSet(MouseEvent ev) throws RemoteException
	{

			if(this.selfPlayer.isMyTurn() && this.selfPlayer.isRedeploy() == false){
				if(selfPlayer.getActiveSet() == null){
					sidebarController.showButton();
					sidebarController.updateButtonText("End Conquer");
					sidebarController.showDeclineButton();
					}

			ImageView test = (ImageView) ev.getTarget();
			System.out.println(test.getId());
			char [] iets = test.getId().toCharArray();

			int choice = Character.getNumericValue(iets[iets.length-1]);
			System.out.println(choice);
			stackset.getStackController().chooseSet(choice-1);


			}
	}


	/**
	 * Maakt de mainPane zichtbaar.
	 * Bijzonderheden: Wordt opgeroepen in de fieldviewcontroller.
	 */
    public void showView(){
    	mainPane.setVisible(true); //activate on TAB key pressed - called in FieldViewController
    }
    public void setActive()
    {
    	//for(int x=0;x<2;x++)
    	//{
    	//for(int x=0;x<stackset.getPlayerName().size();x++)
    	//{
    		//System.out.println(stackset.getPlayerName().get(x));
    		//System.out.println(stackset.getPlayerName().size());
    	//}

	    	System.out.println(stackset.getActiveAbility());
	    	System.out.println(stackset.getPlayerName());
	    	System.out.println(stackset.getActiveRace());
	    	//System.out.println(selfPlayer.getActiveSet().getRace().getName());
	    	//if(stackset.getActiveRace2() == null && stackset.getActiveAbility2() ==null)
			//{
	    		activePlayer1Race.setImage(new Image("/images/races/server/"+stackset.getActiveRace()+".png"));
				activePlayer1Ability.setImage(new Image("/images/abilitys/server/"+stackset.getActiveAbility()+".png"));
			//}
			//if(stackset.getActiveRace2() != null && stackset.getActiveAbility2() !=null)
			//{
				activePlayer2Race.setImage(new Image("/images/races/server/"+stackset.getActiveRace2()+".png"));
				activePlayer2Ability.setImage(new Image("/images/abilitys/server/"+stackset.getActiveAbility2()+".png"));
			//}
			//activePlayer1Ability.setImage(new Image("/images/abilitys/active/"+stackset.getActiveAbility()+".png"));
    	//}
    }
    /**
	 * Maakt de mainPane onzichtbaar.
	 * Bijzonderheden: Wordt opgeroepen in de fieldviewcontroller.
	 */
    public void hideView(){
    	mainPane.setVisible(false); //activate on TAB key release - called in FieldViewController

    }
    public void ShowName(){
    	try{
    	   player_1.setText(stackset.getPlayerName());
    	   player_2.setText(stackset.getPlayerName2());
    	   //player_2.setText(String.valueOf(stackset.getPlayerName2()));
    	}catch(java.lang.NullPointerException e)
		{
			System.out.println(e.getMessage());
		}

    }

	public void setPlayerRef(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

    public boolean isVisible(){
    	return mainPane.visibleProperty().get();
    }
    public void setStackRef(StackSet stack){
    	this.stackset = stack;
    }

    /**
     * Laat de kiesbare sets zien op de view.
     * @param sets, de totaalcollectie van alle sets bij elkaar.
     */
	public void setStack(ObservableList<Set> sets) {
		//player_1.setText(String.valueOf(stackset.getPlayerName()));
		pick_race_1.setImage(new Image("/images/races/active/"+sets.get(0).getRace().getName()+".png"));
		pick_race_2.setImage(new Image("/images/races/active/"+sets.get(1).getRace().getName()+".png"));
		pick_race_3.setImage(new Image("/images/races/active/"+sets.get(2).getRace().getName()+".png"));
		pick_race_4.setImage(new Image("/images/races/active/"+sets.get(3).getRace().getName()+".png"));
		pick_race_5.setImage(new Image("/images/races/active/"+sets.get(4).getRace().getName()+".png"));
		pick_race_6.setImage(new Image("/images/races/active/"+sets.get(5).getRace().getName()+".png"));

		pick_ability_1.setImage(new Image("/images/abilitys/active/"+sets.get(0).getAbility().getName()+".png"));
		pick_ability_2.setImage(new Image("/images/abilitys/active/"+sets.get(1).getAbility().getName()+".png"));
		pick_ability_3.setImage(new Image("/images/abilitys/active/"+sets.get(2).getAbility().getName()+".png"));
		pick_ability_4.setImage(new Image("/images/abilitys/active/"+sets.get(3).getAbility().getName()+".png"));
		pick_ability_5.setImage(new Image("/images/abilitys/active/"+sets.get(4).getAbility().getName()+".png"));
		pick_ability_6.setImage(new Image("/images/abilitys/active/"+sets.get(5).getAbility().getName()+".png"));

		setActive();
		try{

			ShowName();

		}catch(java.lang.NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		catch(java.lang.RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
		//ShowName();




	}

	public void setBottomController(BottomBarController bottomBarController) {

		this.bottomBarController = bottomBarController;
	}
	public void setSettingBarController(SettingController settingController) {
		this.settingBarController = settingController;
	}
	public SettingController getSettingBarController()
	{
		return this.settingBarController;
	}
	public void updateActiveSet()
	{
		bottomBarController.setActiveSet();
	}
	public void updateDeclineSet() throws RemoteException
	{
		settingBarController.setDecline();
	}

	public void setSideBarController(SideBarController sidebarController) {
		this.sidebarController = sidebarController;

	}
	public StackSet getStackSet()
	{
		return this.stackset;
	}

	////// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ en dan via deze methode die shit updaten.
	public void updateCoinCost(ArrayList<Integer> gains) {
//		if(coinAmount == 0) {
//			gain_1.setText("0");
//			gain_1.setText(String.valueOf(stackset.getSets().get(0).getGains()));
//		}
//		if(coinAmount == 1) {
//			gain_1.setText(gain_2.getText());
//			gain_2.setText("0");
//			gain_2.setText(String.valueOf(stackset.getSets().get(1).getGains()));
//		}
//		if(coinAmount == 2) {
//			gain_1.setText(gain_2.getText());
//			gain_2.setText(gain_3.getText());
//			gain_3.setText("0");
//		}
//		if(coinAmount == 3) {
//			gain_1.setText(gain_2.getText());
//			gain_2.setText(gain_3.getText());
//			gain_3.setText(gain_4.getText());
//			gain_4.setText("0");
//		}
//		if(coinAmount == 4) {
//			gain_1.setText(gain_2.getText());
//			gain_2.setText(gain_3.getText());
//			gain_3.setText(gain_4.getText());
//			gain_4.setText(gain_5.getText());
//			gain_5.setText("0");
//		}
//		if(coinAmount == 5) {
//			gain_1.setText(gain_2.getText());
//			gain_2.setText(gain_3.getText());
//			gain_3.setText(gain_4.getText());
//			gain_4.setText(gain_5.getText());
//			gain_5.setText(gain_6.getText());
//			gain_6.setText("0");
//		}

		gain_1.setText(String.valueOf(gains.get(0)));
		gain_2.setText(String.valueOf(gains.get(1)));
		gain_3.setText(String.valueOf(gains.get(2)));
		gain_4.setText(String.valueOf(gains.get(3)));
		gain_5.setText(String.valueOf(gains.get(4)));
		gain_6.setText("0");

		stackset.getStackController().setGains(gains);

	}






}
