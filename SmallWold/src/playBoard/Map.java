package playBoard;

import java.util.ArrayList;
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

	private List<Terrain> terrains = new ArrayList<Terrain>();
	private Die die;
	private Player selfPlayer;
	private int playerAmount;

	public Map(Player selfPlayer, int playerAmount){
		this.die = new Die();
		this.selfPlayer = selfPlayer;
		this.playerAmount = playerAmount;
		this.terrains = createMap(playerAmount);
	}

	private List<Terrain> createMap(int playerAmount) {
		switch (playerAmount) {
		case 2:
			return create2PlayerMap();
		default:
			return null;
		}
	}


	public List<Terrain> create2PlayerMap(){

			int[] terrainOne = new int[] {11, 12, 21, 22};				//Make the terrain have its own value and the other values
			int[] terrainTwo = new int[] {12, 11, 13, 22, 23};
			int[] terrainThree = new int[] {13, 12, 14, 23, 24, 32, 33, 44};
			int[] terrainFour = new int[] {14, 13, 15, 24, 25};
			int[] terrainFive = new int[] {15, 14, 16, 25};
			int[] terrainSix = new int[] {16, 15, 25, 35, 36};
			int[] terrainSeven = new int[] {21, 11, 22, 31, 41, 51};
			int[] terrainEight = new int[] {22, 11, 12, 21, 23, 31};
			int[] terrainNine = new int[] {23, 12, 13, 22, 31, 32};
			int[] terrainTen = new int[] {24, 13, 14, 25, 33, 34};
			int[] terrainEleven = new int[] {25, 14, 15, 16, 24, 34, 35, 36};
			int[] terrainTwelve = new int[] {31, 21, 22, 23, 32, 41, 42};
			int[] terrainThirteen = new int[] {32, 13, 23, 31, 33, 42, 44, 52};
			int[] terrainFourteen = new int[] {33, 13, 24, 34, 44, 45};
			int[] terrainFifteen = new int[] {34, 24, 25, 33, 35, 45};
			int[] terrainSixteen = new int[] {35, 16, 25, 34, 36, 23, 24};
			int[] terrainSeventeen = new int[] {36, 16, 35, 46};
			int[] terrainEighteen = new int[] {51, 21, 41, 42, 52};
			int[] terrainNineteen = new int[] {41, 21, 31, 42, 51};
			int[] terrainTwenty = new int[] {42, 31, 32, 41, 43, 51, 52};
			int[] terrainTwentyOne = new int[] {43, 32, 42, 44, 52};
			int[] terrainTwentyTwo = new int[] {44, 13, 32, 33, 43, 45, 52, 53};
			int[] terrainTwentyThree = new int[] {45, 33, 34, 35, 44, 46, 53, 54};
			int[] terrainTwentyFour = new int[] {46, 35, 36, 45, 54, 55};
			int[] terrainTwentyFive = new int[] {52, 42, 43, 44, 51, 53};
			int[] terrainTwentySix = new int[] {53, 44, 45, 52, 54};
			int[] terrainTwentySeven = new int[] {54, 45, 46, 53, 55};
			int[] terrainTwentyEight = new int[] {55, 46, 54};

			terrains.add(new Chasm(terrainOne));
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



}
