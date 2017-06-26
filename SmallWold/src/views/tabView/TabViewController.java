package views.tabView;


import java.rmi.RemoteException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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
			if(this.selfPlayer.isMyTurn()){
			
			ImageView test = (ImageView) ev.getTarget();
			System.out.println(test.getId());
			char [] iets = test.getId().toCharArray();

			int choice = Character.getNumericValue(iets[iets.length-1]);
			System.out.println(choice);
			stackset.getStackController().chooseSet(choice-1);
			
			sidebarController.updateVisibleButton();
			sidebarController.updateButtonText("End Conquer");
			bottomBarController.updateCurrentTokens();
			
			
			
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
    	   player_1.setText(String.valueOf(stackset.getPlayerName()));

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







}
