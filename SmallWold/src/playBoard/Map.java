package playBoard;

import java.util.ArrayList;
/**
 * Klasse die het speelbord initieert en in een list zet.
 */
import java.util.List;

import player.Player;
import terrain.Chasm;
import terrain.Mine;
import terrain.Mud;
import terrain.Mystic;
import terrain.River;
import terrain.Shroom;
import terrain.Stone;
import terrain.Terrain;

public class Map {

	/**
	 * Klasse die het speelbord initieert en in een list zet.
	 */

	private List<Terrain> terrains = new ArrayList<Terrain>();
	private Die die;
	private Player selfPlayer;
	private int playerAmount;

	/**
	 * Ophalen van de speler en het aantal spelers.
	 *
	 * @param selfPlayer, de actieve speler.
	 * @param playerAmount, totaal aantal spelers.
	 *
	 * @author Marinus van den Oever;
	 */
	public Map(Player selfPlayer, int playerAmount){
		this.setDie(new Die());
		this.setSelfPlayer(selfPlayer);
		this.playerAmount = playerAmount;
		this.terrains = createMap(playerAmount);
	}
	/**
	 * Het speelbord wordt gemaakt door het aantal spelers mee te geven.
	 * Bijzonderheid: Als er geen playerAmount wordt meegegeven wordt er geen speelbord aangemaakt.
	 *
	 * @param playerAmount, totaal aantal spelers voor het bordspel.
	 *
	 * @return null
	 * @author Marinus van den Oever;
	 */
	private List<Terrain> createMap(int playerAmount) {
		switch (playerAmount) {
		case 2:
			System.out.println("client: creating map for 2 players");
			return createBPlayerMap();
		default:
			return null;
		}
	}

	/**
	 * De specifieke tereinen worden in de list geplaatst met eigen ID en ID van de omringende terreinen.
	 * Bijzonderheid: Elk terrein krijgt naast een ID ook het type van het terrein mee.
	 *
	 *
	 * @return terrains.
	 * @author Marinus van den Oever
	 */
	private List<Terrain> createBPlayerMap(){

			String[] AA = new String[] {"AA", "AB", "BA", "BB"};				//Make the terrain have its own value and the other values
			String[] terrainTwo = new String[] {"AB", "AA", "AC", "BB", "BC"};
			String[] terrainThree = new String[] {"AC", "AB", "AD", "BC", "BD", "CB", "CC", "DD"};
			String[] terrainFour = new String[] {"AD", "AC", "AE", "BD", "BE"};
			String[] terrainFive = new String[] {"AE", "AD", "AF", "BE"};
			String[] terrainSix = new String[] {"AF", "AE", "BE", "CE", "CF"};
			String[] terrainSeven = new String[] {"BA", "AA", "BB", "CA", "DA", "EA"};
			String[] terrainEight = new String[] {"BB", "AA", "AB", "BA", "BC", "CA"};
			String[] terrainNine = new String[] {"BC", "AB", "AC", "BB", "CA", "CB"};
			String[] terrainTen = new String[] {"BD", "AC", "AD", "BE", "CC", "CD"};
			String[] terrainEleven = new String[] {"BE", "AD", "AE", "AF", "BD", "CD", "CE", "CF"};
			String[] terrainTwelve = new String[] {"CA", "BA", "BB", "BC", "CB", "DA", "DB"};
			String[] terrainThirteen = new String[] {"CB", "AC", "BC", "CA", "CC", "DB", "DD", "EB"};
			String[] terrainFourteen = new String[] {"CC", "AC", "BD", "CD", "DD", "DE"};
			String[] terrainFifteen = new String[] {"CD", "BD", "BE", "CC", "CE", "DE"};
			String[] terrainSixteen = new String[] {"CE", "AF", "BE", "CD", "CF", "BC", "BD"};
			String[] terrainSeventeen = new String[] {"CF", "AF", "CE", "DF"};
			String[] terrainEighteen = new String[] {"EA", "BA", "DA", "DB", "EB"};
			String[] terrainNineteen = new String[] {"DA", "BA", "CA", "DB", "EA"};
			String[] terrainTwenty = new String[] {"DB", "CA", "CB", "DA", "DC", "EA", "EB"};
			String[] terrainTwentyOne = new String[] {"DC", "CB", "DB", "DD", "EB"};
			String[] terrainTwentyTwo = new String[] {"DD", "AC", "CB", "CC", "DC", "DE", "EB", "EC"};
			String[] terrainTwentyThree = new String[] {"DE", "CC", "CD", "CE", "DD", "DF", "EC", "ED"};
			String[] terrainTwentyFour = new String[] {"DF", "CE", "CF", "DE", "ED", "EE"};
			String[] terrainTwentyFive = new String[] {"EB", "DB", "DC", "DD", "EA", "EC"};
			String[] terrainTwentySix = new String[] {"EC", "DD", "DE", "EB", "ED"};
			String[] terrainTwentySeven = new String[] {"ED", "DE", "DF", "EC", "EE"};
			String[] terrainTwentyEight = new String[] {"EE", "DF", "ED"};

			terrains.add(new Chasm(AA));
			terrains.add(new Mud(terrainTwo));
			terrains.add(new River(terrainThree));
			terrains.add(new Mystic(terrainFour));
			terrains.add(new Shroom(terrainFive));
			terrains.add(new Stone(terrainSix));
			terrains.add(new Mystic(terrainSeven));
			terrains.add(new Shroom(terrainEight));
			terrains.add(new Shroom(terrainNine));
			terrains.add(new Shroom(terrainTen));
			terrains.add(new Mine(terrainEleven));
			terrains.add(new Stone(terrainTwelve));
			terrains.add(new Mystic(terrainThirteen));
			terrains.add(new Stone(terrainFourteen));
			terrains.add(new Chasm(terrainFifteen));
			terrains.add(new Stone(terrainSixteen));
			terrains.add(new Chasm(terrainSeventeen));
			terrains.add(new Chasm(terrainEighteen));
			terrains.add(new Mine(terrainNineteen));
			terrains.add(new Mine(terrainTwenty));
			terrains.add(new Mud(terrainTwentyOne));
			terrains.add(new River(terrainTwentyTwo));
			terrains.add(new Mystic(terrainTwentyThree));
			terrains.add(new Mud(terrainTwentyFour));
			terrains.add(new River(terrainTwentyFive));
			terrains.add(new Mine(terrainTwentySix));
			terrains.add(new Mud(terrainTwentySeven));
			terrains.add(new Chasm(terrainTwentyEight));


		return terrains;

	}

	public List<Terrain> getTerrains(){
			return this.terrains;
	}

	/**
	 * Als het terrein ID wordt meegegeven zal de methode teruggeven wat het type is.
	 *
	 * @param id, bijvoorbeeld AA, AB, BB.
	 * @return terrain type
	 */

	public Terrain getTerrainById(String id) {
		for (Terrain terrain : terrains) {
			if(terrain.getElement(0).equals(id) ){
				System.out.println("test:  " + id + "   -    " +  terrain.getElement(0));
				return terrain;
			}
		}
		return null;

	}

	public Player getSelfPlayer() {
		return selfPlayer;
	}

	public void setSelfPlayer(Player selfPlayer) {
		this.selfPlayer = selfPlayer;
	}

	public Die getDie() {
		return die;
	}

	public void setDie(Die die) {
		this.die = die;
	}




}
