package client;

import java.io.IOException;
import java.rmi.RemoteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import views.fieldView.FieldViewController;
import views.lobbyView.lobbyController;
import views.sideBarView.SideBarController;
import views.tabView.TabViewController;

public class ClientApplication extends Application{

	private static RemoteClient client;
	private Stage primaryStage;



	public ClientApplication() throws RemoteException {
		client = new RemoteClient(this);
	}


	public static void main(String[] args) throws RemoteException {


		launch(args);
	}

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

	}
	public void StartGameScreen(int playerAmount) throws IOException{
        primaryStage.setTitle("SmallWorld - Underground");

        //set the layout of the view. fielView
        FXMLLoader rootLayoutLoader = new FXMLLoader(getClass().getResource("../views/fieldView/fieldView.fxml"));	//get xml file
        BorderPane rootLayout = (BorderPane) rootLayoutLoader.load();										//load xml file to object
        FieldViewController fieldController = rootLayoutLoader.getController();								//set controller

        //add bottomBar to the rootLayout
        FXMLLoader bottomBarLoader = new FXMLLoader(getClass().getResource("../views/bottomBarView/bottomBarView.fxml"));	//get xml file
        StackPane bottomBar =  bottomBarLoader.load();														//load xml file to object																								//set controller
        rootLayout.setBottom(bottomBar);																	//bind pane to layout

        //add SideBar to the rootLayout
		FXMLLoader sideBarLoader = new FXMLLoader(getClass().getResource("../views/sideBarView/sideBarView.fxml"));			//get xml file
		StackPane sideBar = sideBarLoader.load(); 															//load xml file to object
		SideBarController sidebarController = sideBarLoader.getController();
       rootLayout.setRight(sideBar);

        //add tabview thats hidden to rootLayout

        FXMLLoader tabViewLoader = new FXMLLoader(getClass().getResource("../views/tabView/tabView.fxml"));			//get xml file
        StackPane tabView = tabViewLoader.load();																//load xml file to object
        StackPane tabPane = (StackPane)rootLayoutLoader.getNamespace().get("stackPane"); 						//get stackPane from fieldView
        tabPane.getChildren().add(tabView);																	//add tabview to stackpane from Fieldview
        TabViewController tabController = tabViewLoader.getController();										//set controller tabView

        //give controllers objects of controllers
        fieldController.setControllers(tabController, sidebarController);
        sidebarController.setControllers(tabController);



        //show the scene with the root layout
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.show();
        rootLayout.requestFocus();



	}



}