package mapInitializers;

import terrain.Chasm;
import terrain.Mine;
import terrain.Mud;
import terrain.Mystic;
import terrain.River;
import terrain.Shroom;
import terrain.Stone;

public class ThreePlayer extends Initializer{
	public void initialize()								// Initializing the map
	{
		int [] terrainOne = new int[] {11, 12, 21};				//Make the terrain have its own value and the other values
		int [] terrainTwo = new int[] {12, 11, 13, 21, 22};
		int [] terrainThree = new int[] {13, 12, 14, 22, 23};
		int [] terrainFour = new int[] {14, 13, 15,23};
		int [] terrainFive = new int[] {15, 14, 16, 23, 24, 33, 34};
		int [] terrainSix = new int [] {16, 15, 17, 24, 25};

		int[] terrainSeven = new int[] {17, 16, 18, 25};
		int[] terrainEight = new int[] {18, 17, 25, 36, 37};
		int[] terrainNine = new int[] {21, 11, 12, 22, 31};
		int[] terrainTen = new int[] {22, 12, 13, 21, 23, 31, 32};
		int[] terrainEleven = new int[] {23, 13, 14, 15, 22, 32, 33};
		int[] terrainTwelve = new int[] {24, 15, 16, 25, 34, 35};
		int[] terrainThirteen = new int[] {25, 16, 17, 18, 24, 35, 36};
		int[] terrainFourteen = new int[] {31, 21, 22, 32, 41, 42};

		int[] terrainFifteen = new int[] {32, 22, 23, 31, 33, 42, 43};
		int[] terrainSixteen = new int[] {33, 15, 23, 32, 43, 44, 45};
		int[] terrainSeventeen = new int[] {34, 15, 24, 35, 45, 46};
		int[] terrainEighteen = new int[] {35, 24, 25, 34, 36, 46};
		int[] terrainNineteen = new int[] {36, 18, 25, 35, 37, 46, 47};
		int[] terrainTwenty = new int[] {37, 18, 36, 47};
		int[] terrainTwentyOne = new int[] {41, 31, 42, 51};

		int[] terrainTwentyTwo = new int[] {42, 31, 32, 41, 43, 51, 52};
		int[] terrainTwentyThree = new int[] {43, 32, 33, 22, 24, 52, 53};
		int[] terrainTwentyFour = new int[] {44, 33, 43, 45, 53};
		int[] terrainTwentyFive = new int[] {45, 15, 33, 34, 44, 46, 53, 54};
		int[] terrainTwentySix = new int[] {46, 34, 35, 36, 45, 47, 54, 55};
		int[] terrainTwentySeven = new int[] {47, 36, 37, 46, 55, 56};
		int[] terrainTwentyEight = new int[] {51, 41, 42, 52};
		int[] terrainTwentyNine = new int[] {52, 42, 43, 51, 53};

		int[] terrainThirty = new int[] {53, 43, 44, 45, 52, 54};
		int[] terrainThirtyOne = new int[] {54, 45, 46, 53, 55};
		int[] terrainThirtyTwo = new int[] {55, 46, 47, 54, 56};
		int[] terrainThirtyThree = new int[] {56, 47, 55};

		terrains.add(new Chasm(terrainOne));						//Link the arrays to the terrains
		terrains.add(new Stone(terrainTwo));
		terrains.add(new Mystic(terrainThree));
		terrains.add(new Mine(terrainFour));
		terrains.add(new River(terrainFive));
		terrains.add(new Mud(terrainSix));
		terrains.add(new Shroom(terrainSeven));
		terrains.add(new Stone(terrainEight));
		
		terrains.add(new Mud(terrainNine));
		terrains.add(new Shroom(terrainTen));
		terrains.add(new Shroom(terrainEleven));
		terrains.add(new Shroom(terrainTwelve));
		terrains.add(new Mud(terrainThirteen));
		
		terrains.add(new Mystic(terrainFourteen));
		terrains.add(new Stone(terrainFifteen));
		terrains.add(new Mystic(terrainSixteen));
		terrains.add(new Stone(terrainSeventeen));
		terrains.add(new Chasm(terrainEighteen));
		terrains.add(new Stone(terrainNineteen));
		terrains.add(new Mine(terrainTwenty));
		
		terrains.add(new Mud(terrainTwentyOne));
		terrains.add(new Chasm(terrainTwentyTwo));
		terrains.add(new Mine(terrainTwentyThree));
		terrains.add(new Mud(terrainTwentyFour));
		terrains.add(new River(terrainTwentyFive));
		terrains.add(new Mystic(terrainTwentySix));
		terrains.add(new Mystic(terrainTwentySeven));
		
		terrains.add(new Stone(terrainTwentyEight));
		terrains.add(new Mine(terrainTwentyNine));
		terrains.add(new River(terrainThirty));
		terrains.add(new Mine(terrainThirtyOne));
		terrains.add(new Shroom(terrainThirtyTwo));
		terrains.add(new Chasm(terrainThirtyThree));
	}
}
