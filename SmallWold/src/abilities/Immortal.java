package abilities;

import listCreators.RaceListCreator;
import main.Ammy;
import playBoard.Map;
import player.Player;

public class Immortal extends Ability implements CalculatableIncome
{
	Map map;
	private int abilityIncome;
	RaceListCreator raceList;

	public Immortal()
	{
		amountOfTokens = 4;
		name = "Immortal";
		traitText = "Keep all conquered tokens in your hand to redeploy at the end of the turn.";
	}

	@Override
	public void processAbility(Ammy ammy) {
		this.activePlayer = ammy.getActivePlayer();

			for(int terrainCounter=0;terrainCounter<map.getAllTerrains().size();terrainCounter++)		//As long as there are terrains
			{
				if (activePlayer.getActiveSet().getRace().equals(map.getTerrain(terrainCounter).getRace()))
				{
					abilityIncome = abilityIncome + map.getTerrain(terrainCounter).getAmountOfTokens();
					map.getTerrain(terrainCounter).setRace(raceList.getListElement(0));
				}
			}
	}

	public int getAbilityIncome() {
		return abilityIncome;
	}

	public void setAbilityIncome(int abilityIncome) {
		this.abilityIncome = abilityIncome;
	}
}
