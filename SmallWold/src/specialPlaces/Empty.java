package specialPlaces;

import playBoard.Map;
import player.Player;

/**
 * Deze klasse bestaat zodat de specialplace op "leeg" gezet kan worden.
 * @author Jeroen Zandvliet
 */
public class Empty extends SpecialPlace{

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	public void processSpecialPlace(Player selfPlayer, Map map) {
	}

}
