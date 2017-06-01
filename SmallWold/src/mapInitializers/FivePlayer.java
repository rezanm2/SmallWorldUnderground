package mapInitializers;

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

public class FivePlayer extends Initializer
{

	public void initialize()								// Initializing the map
	{
		int [] terrainOne = new int[] {11, 12, 21, 22};				//Make the terrain have its own value and the other values
		int [] terrainTwo = new int[] {12, 11, 13, 22, 23};
		int [] terrainThree = new int[] {13, 12, 14, 23, 24};
		int [] terrainFour = new int[] {14, 13, 15, 24, 25};
		int [] terrainFive = new int[] {15, 14, 16, 25, 26};
		int [] terrainSix = new int [] {16, 15, 17, 26, 27};
		int[] terrainSeven = new int[] {17, 16, 27, 28};

		int[] terrainEight = new int[] {21, 11, 22, 31};
		int[] terrainNine = new int[] {22, 11, 12, 21, 23, 31, 32};
		int[] terrainTen = new int[] {23, 12, 13, 22, 24, 32, 33};
		int[] terrainEleven = new int[] {13, 14, 23, 25, 33, 34};
		int[] terrainTwelve = new int[] {25, 14, 15, 24, 26, 34};
		int[] terrainThirteen = new int[] {26, 15, 16, 25, 27, 34, 35};
		int[] terrainFourteen = new int[] {27, 16, 17, 26, 28, 35, 36};
		int[] terrainFifteen = new int[] {28, 17, 27, 36};

		int[] terrainSixteen = new int[] {31, 21, 22, 32, 81};
		int[] terrainSeventeen = new int[] {32, 22, 23, 31, 33, 81, 82};
		int[] terrainEighteen = new int[] {33, 23, 24, 32, 34, 82, 83};
		int[] terrainNineteen = new int[] {34, 24, 25, 26, 33, 35, 83, 84, 85, 86};
		int[] terrainTwenty = new int[] {35, 26, 27, 34, 36, 86, 87};
		int[] terrainTwentyOne = new int[] {36, 27, 28, 35, 87, 88};

		int[] terrainTwentyTwo = new int[] {81, 31, 32, 82, 41, 51};
		int[] terrainTwentyThree = new int[] {82, 32, 33, 81, 83, 41};
		int[] terrainTwentyFour = new int[] {83, 33, 34, 82, 84, 41, 42, 51};
		int[] terrainTwentyFive = new int[] {84, 34, 83, 85, 42, 43};
		int[] terrainTwentySix = new int[] {85, 34, 84, 86, 43};
		int[] terrainTwentySeven = new int[] {86, 34, 35, 85, 87, 43, 44, 55, 56};
		int[] terrainTwentyEight = new int[] {87, 35, 36, 86, 88, 44};
		int[] terrainTwentyNine = new int[] {88, 36, 87, 44};

		int[] terrainThirty = new int[] {41, 81, 82, 83, 51};
		int[] terrainThirtyOne = new int[] {42, 83, 84, 43, 52, 53};
		int[] terrainThirtyTwo = new int[] {43, 84, 85, 86, 42, 53, 54, 55};
		int[] terrainThirtyThree = new int[] {44, 86, 87, 56};

		int[] terrainThirtyFour = new int[] {51, 81, 83, 41, 52, 61, 62};
		int[] terrainThirtyFive = new int[] {52, 83, 42, 51, 53, 62, 63, 64};
		int[] terrainThirtySix = new int[] {53, 42, 43, 52, 54, 64};
		int[] terrainThirtySeven = new int[] {54, 43, 53, 55, 64, 65, 76, 78};
		int[] terrainThirtyEight = new int[] {55, 86, 43, 54, 56, 65};
		int[] terrainThirtyNine = new int[] {56, 86, 44, 55, 65, 66};

		int[] terrainForty = new int[] {61, 51, 62, 71, 72};
		int[] terrainFortyOne = new int[] {62, 51, 52, 61, 63, 72, 73};
		int[] terrainFortyTwo = new int[] {63, 52, 62, 64, 73, 74};
		int[] terrainFortyThree = new int[] {64, 52, 53, 54, 63, 74, 75, 76};
		int[] terrainFortyFour = new int[] {65, 54, 55, 56, 66, 78 , 79};
		int[] terrainFortyFive = new int [] {66, 56, 65, 78, 79, 80};

		int[] terrainFortySix = new int [] {71, 62, 72, 73};
		int[] terrainFortySeven = new int [] {72, 61, 62, 73};
		int[] terrainFortyEight = new int [] {73, 62, 63, 71, 72, 74};
		int[] terrainFortyNine = new int [] {74, 63, 64, 73, 75};
		int[] terrainFifty = new int [] {75, 64, 74, 76};
		int[] terrainFiftyOne = new int [] {76, 54, 64, 75, 77, 78};
		int[] terrainFiftyTwo = new int [] {77, 76, 78, 79, 81};
		int[] terrainFiftyThree = new int [] {78, 54, 65, 76, 77, 79};
		int[] terrainFiftyFour = new int [] {79, 65, 66, 77, 78, 81};
		int[] terrainFiftyFive = new int [] {81, 66, 77, 79};

		terrains.add(new Mud(terrainOne));						//Link the arrays to the terrains
		terrains.add(new Chasm(terrainTwo));
		terrains.add(new Shroom(terrainThree));
		terrains.add(new Shroom(terrainFour));
		terrains.add(new Stone(terrainFive));
		terrains.add(new Mud(terrainSix));
		terrains.add(new Mine(terrainSeven));

		terrains.add(new Mystic(terrainEight));
		terrains.add(new Mine(terrainNine));
		terrains.add(new Mine(terrainTen));
		terrains.add(new Mud(terrainEleven));
		terrains.add(new Mystic(terrainTwelve));
		terrains.add(new Stone(terrainThirteen));
		terrains.add(new Chasm(terrainFourteen));
		terrains.add(new Mystic(terrainFifteen));

		terrains.add(new Shroom(terrainSixteen));
		terrains.add(new Stone(terrainSeventeen));
		terrains.add(new Mud(terrainEighteen));
		terrains.add(new River(terrainNineteen));
		terrains.add(new Mine(terrainTwenty));
		terrains.add(new Mud(terrainTwentyOne));

		terrains.add(new Stone(terrainTwentyTwo));
		terrains.add(new Shroom(terrainTwentyThree));
		terrains.add(new River(terrainTwentyFour));
		terrains.add(new Mystic(terrainTwentyFive));
		terrains.add(new Stone(terrainTwentySix));
		terrains.add(new River(terrainTwentySeven));
		terrains.add(new Shroom(terrainTwentyEight));
		terrains.add(new Stone(terrainTwentyNine));

		terrains.add(new Mine(terrainThirty));
		terrains.add(new Shroom(terrainThirtyOne));
		terrains.add(new Mud(terrainThirtyTwo));
		terrains.add(new Mystic(terrainThirtyThree));

		terrains.add(new River(terrainThirtyFour));
		terrains.add(new Stone(terrainThirtyFive));
		terrains.add(new Mine(terrainThirtySix));
		terrains.add(new Stone(terrainThirtySeven));
		terrains.add(new Mud(terrainThirtyEight));
		terrains.add(new River(terrainThirtyNine));

		terrains.add(new Mud(terrainForty));
		terrains.add(new Mystic(terrainFortyOne));
		terrains.add(new Chasm(terrainFortyTwo));
		terrains.add(new Mine(terrainFortyThree));
		terrains.add(new Mystic(terrainFortyFour));
		terrains.add(new Mine(terrainFortyFive));

		terrains.add(new Chasm(terrainFortySix));
		terrains.add(new Stone(terrainFortySeven));
		terrains.add(new Shroom(terrainFortyEight));
		terrains.add(new Mud(terrainFortyNine));
		terrains.add(new Mystic(terrainFifty));
		terrains.add(new Mystic(terrainFiftyOne));
		terrains.add(new Mine(terrainFiftyTwo));
		terrains.add(new Shroom(terrainFiftyThree));
		terrains.add(new Shroom(terrainFiftyFour));
		terrains.add(new Chasm(terrainFiftyFive));

	}

}
