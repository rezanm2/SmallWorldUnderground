package mapInitializer;

import java.util.ArrayList;
import java.util.List;
import terrain.Chasm;
import terrain.Mine;
import terrain.Mud;
import terrain.Mystic;
import terrain.River;
import terrain.Shroom;
import terrain.Stone;
import terrain.Terrain;

public class MapInitializer
{
	List<Terrain> terrains = new ArrayList<Terrain>();
	public void initialize()
	{
		terrains.add(new Chasm("AA;","AB; BA; BB;"));
		terrains.add(new River("AB;", "AC; BB; BC; BD; BE;"));
		terrains.add(new Mud("AC;", "AB; AD; BE; BF;"));
		terrains.add(new Stone("AD;", "AC; BF;"));

		terrains.add(new Mystic("BA;", "AA; BB; CA;"));
		terrains.add(new Stone("BB;", "AA; AB; BA; BC; CA; CB"));
		terrains.add(new Stone("BC;", "AB; BA; BD; CB; CC;"));
		terrains.add(new River("BD;", "AB; BC; BE; BF"));
		terrains.add(new Mine("BE;", "AB; AC; BD; BF;"));
		terrains.add(new Shroom("BF;", "AC; AD; BD; BE;"));

		terrains.add(new Shroom("CA;", "BA; BB; CB;"));
		terrains.add(new Mud("CB;", "BB; BC; CA; CC;"));
		terrains.add(new Mystic("CC;", "BC; BD; CD;"));
	}

	public Terrain getMap(int x)
	{
		return terrains.get(x);
	}
}
