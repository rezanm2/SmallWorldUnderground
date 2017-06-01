package mapInitializer;

import java.util.ArrayList;
import java.util.List;

import playBoard.Die;
import playBoard.Map;
import terrain.Chasm;
import terrain.Mine;
import terrain.Mud;
import terrain.Mystic;
import terrain.River;
import terrain.Shroom;
import terrain.Stone;
import terrain.Terrain;

public class FourPlayer extends Initializer
{
	List<Terrain> terrains = new ArrayList<Terrain>();

	public void initialize()								// Initializing the map
	{
		int [] terrainOne = new int[] {11, 12, 21, 22};				//Make the terrain have its own value and the other values
		int [] terrainTwo = new int[] {12, 13, 22, 23, 24, 25};
		int [] terrainThree = new int[] {13, 12, 14, 25, 26};
		int [] terrainFour = new int[] {14, 13, 26};
		int [] terrainFive = new int[] {15, 14, 16, 2,7};
		int [] terrainSix = new int [] {16, 15, 27, 28};

		int[] terrainSeven = new int[] {21, 11, 22, 31};
		int[] terrainEight = new int[] {22, 11, 12, 21, 23, 31, 32};
		int[] terrainNine = new int[] {23, 12, 21, 24, 32, 33};
		int[] terrainTen = new int[] {24, 12, 23, 25, 26};
		int[] terrainEleven = new int[] {25, 12, 13, 24, 26};
		int[] terrainTwelve = new int[] {26, 13, 14, 24, 25};
		int[] terrainThirteen = new int[] {27, 14, 15, 16, 26, 28, 37};
		int[] terrainFourteen = new int[] {28, 16, 27, 37, 38};

		int[] terrainFifteen = new int[] {31, 21, 22, 32};
		int[] terrainSixteen = new int[] {32, 22, 23, 31, 33};
		int[] terrainSeventeen = new int[] {34, 23, 24, 34, 35, 43, 44};
		int[] terrainEighteen = new int[] {35, 24, 34, 36, 44, 45};
		int[] terrainNineteen = new int[] {36, 24, 35, 37, 38, 45, 46, 47, 48};
		int[] terrainTwenty = new int[] {37, 24, 26, 27, 28, 36, 38};
		int[] terrainTwentyOne = new int[] {38, 28, 36, 37, 48};

		int[] terrainTwentyTwo = new int[] {41, 31, 42, 51, 52};
		int[] terrainTwentyThree = new int[] {42, 31, 32, 41, 43, 52};
		int[] terrainTwentyFour = new int[] {43, 32, 34, 42, 44, 52, 53};
		int[] terrainTwentyFive = new int[] {44, 34, 35, 43, 45, 53, 54};
		int[] terrainTwentySix = new int[] {45, 35, 36, 44, 46, 54};
		int[] terrainTwentySeven = new int[] {46, 36, 45, 47, 54, 55, 65, 66, 67};
		int[] terrainTwentyEight = new int[] {47, 36, 46, 48, 55, 56};
		int[] terrainTwentyNine = new int[] {48, 36, 38, 47, 56};

		int[] terrainThirty = new int[] {51, 41, 52, 61, 62};
		int[] terrainThirtyOne = new int[] {52, 41, 42, 43, 51, 53, 62};
		int[] terrainThirtyTwo = new int[] {53, 43, 44, 52, 54, 62, 63, 65};
		int[] terrainThirtyThree = new int[] {54, 44, 45, 46, 53, 65};
		int[] terrainThirtyFour = new int[] {55, 46, 47, 56, 67, 68};
		int[] terrainThirtyFive = new int[] {56, 47, 48, 55, 67, 69};

		int[] terrainThirtySix = new int[] {61, 51, 62, 64};
		int[] terrainThirtySeven = new int[] {62, 51, 52, 53, 61, 63, 64};
		int[] terrainThirtyEight = new int[] {63, 53, 62, 64, 65};
		int[] terrainThirtyNine = new int[] {64, 61, 62, 63, 65};
		int[] terrainForty = new int[] {65, 46, 53, 54, 63, 64, 66};
		int[] terrainFortyOne = new int[] {66, 46, 65, 67};
		int[] terrainFortyTwo = new int[] {67, 46, 55, 66, 67};
		int[] terrainFortyThree = new int[] {68, 55, 56, 67, 69};
		int[] terrainFortyFour = new int[] {69, 45, 56, 68};

		terrains.add(new Chasm(terrainOne));						//Link the arrays to the terrains
		terrains.add(new River(terrainTwo));
		terrains.add(new Mud(terrainThree));
		terrains.add(new Stone(terrainFour));
		terrains.add(new Mystic(terrainFive));
		terrains.add(new Mine(terrainSix));

		terrains.add(new Mystic(terrainSeven));
		terrains.add(new Stone(terrainEight));
		terrains.add(new Stone(terrainNine));
		terrains.add(new River(terrainTen));
		terrains.add(new Mine(terrainEleven));
		terrains.add(new Shroom(terrainTwelve));
		terrains.add(new Chasm(terrainThirteen));
		terrains.add(new Stone(terrainFourteen));

		terrains.add(new Shroom(terrainFifteen));
		terrains.add(new Mud(terrainSixteen));
		terrains.add(new Mystic(terrainSeventeen));
		terrains.add(new Mystic(terrainEighteen));
		terrains.add(new River(terrainNineteen));
		terrains.add(new Shroom(terrainTwenty));
		terrains.add(new Mud(terrainTwentyOne));

		terrains.add(new Shroom(terrainTwentyTwo));
		terrains.add(new Mud(terrainTwentyThree));
		terrains.add(new Mine(terrainTwentyFour));
		terrains.add(new Stone(terrainTwentyFive));
		terrains.add(new Mine(terrainTwentySix));
		terrains.add(new River(terrainTwentySeven));
		terrains.add(new Mystic(terrainTwentyEight));
		terrains.add(new Mine(terrainTwentyNine));

		terrains.add(new Mystic(terrainThirty));
		terrains.add(new Chasm(terrainThirtyOne));
		terrains.add(new Mine(terrainThirtyTwo));
		terrains.add(new Mud(terrainThirtyThree));
		terrains.add(new Stone(terrainThirtyFour));
		terrains.add(new Shroom(terrainThirtyFive));

		terrains.add(new Stone(terrainThirtySix));
		terrains.add(new Mud(terrainThirtySeven));
		terrains.add(new Mystic(terrainThirtyEight));
		terrains.add(new Shroom(terrainThirtyNine));
		terrains.add(new River(terrainForty));
		terrains.add(new Shroom(terrainFortyOne));
		terrains.add(new Mud(terrainFortyTwo));
		terrains.add(new Mine(terrainFortyThree));
		terrains.add(new Chasm(terrainFortyFour));
	}

}
