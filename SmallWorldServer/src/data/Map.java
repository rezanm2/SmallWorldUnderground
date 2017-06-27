package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import server.ServerTerrain;


public class Map implements Serializable{

	private List<ServerTerrain> terrains = new ArrayList<ServerTerrain>();
	private int playerAmount;

	public Map(int playerAmount){
		this.playerAmount = playerAmount;
		this.terrains = createMap(playerAmount);
	}

	private List<ServerTerrain> createMap(int playerAmount) {
		switch (playerAmount) {
		case 2:
			System.out.println("Server: creating map for 2 players");
			return create2PlayerMap();
		default:
			return null;
		}
	}


	private List<ServerTerrain> create2PlayerMap(){
			terrains.add(new ServerTerrain("AA"));
			terrains.add(new ServerTerrain("AB"));
			terrains.add(new ServerTerrain("AC"));
			terrains.add(new ServerTerrain("AD"));
			terrains.add(new ServerTerrain("AE"));
			terrains.add(new ServerTerrain("AF"));

			terrains.add(new ServerTerrain("BA"));
			terrains.add(new ServerTerrain("BB"));
			terrains.add(new ServerTerrain("BC"));
			terrains.add(new ServerTerrain("BD"));
			terrains.add(new ServerTerrain("BE"));

			terrains.add(new ServerTerrain("CA"));
			terrains.add(new ServerTerrain("CB"));
			terrains.add(new ServerTerrain("CC"));
			terrains.add(new ServerTerrain("CD"));
			terrains.add(new ServerTerrain("CE"));
			terrains.add(new ServerTerrain("CF"));

			terrains.add(new ServerTerrain("DA"));
			terrains.add(new ServerTerrain("DB"));
			terrains.add(new ServerTerrain("DC"));
			terrains.add(new ServerTerrain("DD"));
			terrains.add(new ServerTerrain("DE"));
			terrains.add(new ServerTerrain("DF"));

			terrains.add(new ServerTerrain("EA"));
			terrains.add(new ServerTerrain("EB"));
			terrains.add(new ServerTerrain("EC"));
			terrains.add(new ServerTerrain("ED"));
			terrains.add(new ServerTerrain("EE"));

		return terrains;

	}
	public List<ServerTerrain> getTerrains(){
			return this.terrains;
	}

	public ServerTerrain getTerrainById(String id) {
		for (ServerTerrain terrain : terrains) {
			if(terrain.getId().equals(id) ){
				return terrain;
			}
		}
		System.out.println("Server: ERROR SOMETHING WENT WRONG: terrain couldnt be found. terrain: " + id);
		return null;

	}





}
