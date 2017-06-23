package specialPlaces;

import main.Ammy;
/**
 * Deze klasse bestaat zodat de specialplace op "leeg" gezet kan worden.
 * @author Renkitty
 */
public class Empty extends SpecialPlace{

	public Empty(){
		name = "Empty";
		traitText = "Empty";
	}

	public void processSpecialPlace(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();
	}

}
