	package client;

import java.io.IOException;
import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import models.JoinedPlayers;
import player.Player;
import views.bottomBarView.BottomBarController;
import views.fieldView.FieldViewController;
import views.lobbyView.lobbyController;
import views.manualView.ManualController;
import views.settingView.SettingController;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

/**
 * Deze class is de clientApplicatie die een javafx applicatie extends.
 * 
 * @author Groep13
 *
 */

public class ClientApplication extends Application{

	private static RemoteClient client;
	private Stage primaryStage;
	private TabViewController tabController;
	private SideBarController sidebarController;
	private FieldViewController fieldController;

	private Player selfPlayer;



	/**
	 * Maakt een clientApplication en maakt hierbij een remoteClient aan en een player.
	 *
	 * @throws RemoteException
	 */
	public ClientApplication() throws RemoteException {

		client = new RemoteClient(this);
		selfPlayer = new Player();
	}

	/**
	 * Start de start methode van de clientApplication en toont daarmee dus de javaFx omgeving.
	 *
	 * @param args
	 * @throws RemoteException
	 */
	public static void main(String[] args) throws RemoteException {

		launch(args);
	}

	/**
	 * Start de applicatie op. Eerst wordt de view geladen met daarbij de controller vervolgens wordt de view geshowd.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage; //make primarystage global

		FXMLLoader lobbyLoader = new FXMLLoader(getClass().getResource("../views/lobbyView/lobbyView.fxml"));	//get xml file
		Parent View  = lobbyLoader.load();																		//load the xml in view
		lobbyController lobbyControl = lobbyLoader.getController();												//get ref to controller
		lobbyControl.setRemoteClient(client);																	//give the controller a ref to the client object
		lobbyControl.initLabel();


		Scene scene = new Scene(View);
		primaryStage.setScene(scene);
		primaryStage.show();

		//StartGameScreen(2, null);

	}
	/**
	 * Deze methode start uiteindelijk het gehele spel. 
	 * Allereerst wordt de layout geset van de view. 
	 * Vervolgens worden de componenten bottomBar, sideBar, tabView, manualView en settingView daarop geplaast. 
	 * Daarna krijgen controllers toegang tot de controllers en/of andere objecten die zij nodig hebben. 
	 * Als laatste wordt de view gestart.
	 *
	 * @param playerAmount, het aantal spelers wat meespeelt bij het spel.
	 * @param players, de lijst van spelers die meedoen.
	 * @throws IOException
	 */

	public void StartGameScreen(int playerAmount , ObservableList<JoinedPlayers> players ) throws IOException{
        primaryStage.setTitle("SmallWorld - Underground");


        //set the layout of the view. fielView
        FXMLLoader rootLayoutLoader = new FXMLLoader(getClass().getResource("../views/fieldView/fieldView"+playerAmount+".fxml"));	//get xml file
        BorderPane rootLayout = (BorderPane) rootLayoutLoader.load();										//load xml file to object
        this.fieldController = rootLayoutLoader.getController();								//set controller

        //add bottomBar to the rootLayout
        FXMLLoader bottomBarLoader = new FXMLLoader(getClass().getResource("../views/bottomBarView/bottomBarView.fxml"));	//get xml file
        StackPane bottomBar =  bottomBarLoader.load();														//load xml file to object																								//set controller
        BottomBarController bottomBarControl = bottomBarLoader.getController();
        rootLayout.setBottom(bottomBar);																	//bind pane to layout

        //add SideBar to the rootLayout
		FXMLLoader sideBarLoader = new FXMLLoader(getClass().getResource("../views/sideBarView/sideBarView.fxml"));			//get xml file
		StackPane sideBar = sideBarLoader.load(); 															//load xml file to object
		this.sidebarController = sideBarLoader.getController();
       rootLayout.setRight(sideBar);

        //add tabview thats hidden to rootLayout
       FXMLLoader tabViewLoader = new FXMLLoader(getClass().getResource("../views/tabView/tabView.fxml"));			//get xml file
       StackPane tabView = tabViewLoader.load();																//load xml file to object
       this.tabController = tabViewLoader.getController();										//set controller tabView


       //add manualView thats hidden to rootLayout
      FXMLLoader manualViewLoader = new FXMLLoader(getClass().getResource("../views/manualView/manualView.fxml"));			//get xml file
      StackPane manualView = manualViewLoader.load();																//load xml file to object
      ManualController manualController = manualViewLoader.getController();


      //add settingView thats hidden to rootLayout
      FXMLLoader settingViewLoader = new FXMLLoader(getClass().getResource("../views/settingView/settingView.fxml"));			//get xml file
      StackPane settingView = settingViewLoader.load();																//load xml file to object
      SettingController settingController = settingViewLoader.getController();

        StackPane tabPane = (StackPane)rootLayoutLoader.getNamespace().get("stackPane"); 						//get stackPane from fieldView
        tabPane.getChildren().add(tabView);																	//add tabview to stackpane from Fieldview
        tabPane.getChildren().add(manualView);
        tabPane.getChildren().add(settingView);




        //give controllers objects of controllers
        this.fieldController.setControllers(this.tabController, sidebarController);
        sidebarController.setControllers(tabController);

        this.tabController.setBottomController(bottomBarControl);
        this.tabController.setSettingBarController(settingController);

        sidebarController.setControllers(manualController);
        sidebarController.setControllers(settingController);
        settingController.setControllers(bottomBarControl);



        //give controller acces to player
        this.tabController.setPlayerRef(selfPlayer);
        settingController.setPlayerRef(selfPlayer);
        bottomBarControl.setPlayerRef(selfPlayer);
        sidebarController.setPlayer(selfPlayer);
        fieldController.setPlayer(selfPlayer);

        //show the scene with the root layout
        Scene Scene = new Scene(rootLayout);
        primaryStage.setScene(Scene);
        primaryStage.setFullScreen(false);
        rootLayout.requestFocus();
        rootLayout.setFocusTraversable(true);



	}
	public TabViewController getTabController(){
		return this.tabController;
	}
	public SideBarController getSidebarController(){
		return this.sidebarController;
	}
	public FieldViewController getFieldController(){
		return this.fieldController;
	}
	public Player getPlayer(){
		return this.selfPlayer;
	}




}
