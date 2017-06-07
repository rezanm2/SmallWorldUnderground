package setup;

import controllers.MapTester;
import main.Ammy;
import player.Player;

public class RedeployAreas
{
	Ammy ammy;
	Player activePlayer;
	MapTester test;

	public RedeployAreas(Ammy ammy)
	{
		this.ammy = ammy;
		this.activePlayer = ammy.getActivePlayer();
		this.test = ammy.getTest();

	}

	public void start()
	{
		System.out.println("Ammy: ~~~~~~~~~I'm changing towards the Redeployment phase. ~~~~~~~~~ \n\n");
		System.out.println("A: All right. Let's allow " + activePlayer.getName() + " to redeploy his stuff. \n");

		System.out.println(activePlayer.getName() + " has currently got " + activePlayer.getHand().getCurrentTokens()
							+ " " + activePlayer.getActiveSet().getAbility().getType() + " " + activePlayer.getActiveSet().getRace().getTokenType()
							+ " tokens to redeploy on the following areas: ");

		test.whichAreReinforcable();
	}
}
