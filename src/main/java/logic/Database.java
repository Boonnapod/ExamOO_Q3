package logic;

import java.util.ArrayList;

public class Database {
    private ArrayList<Player> playerList;
    private ArrayList<Region> regionList;

    //constructor

    public Database(){
        this.playerList = new ArrayList<>();
        this.regionList = new ArrayList<>();
    }

    public Database(ArrayList<Player> playerList,ArrayList<Region> regionList){
        setPlayerList(playerList);
        setRegionList(regionList);
    }
    //method
    public Player addPlayer(String name, Region region) throws Exception{
        if(!DatabaseUtil.isPlayerExists(getPlayerList(),name)){
            Player newPlayer = new Player(name);
            playerList.add(newPlayer);
            region.addPlayerToRegion(newPlayer);
            return newPlayer;
        }
        throw new Exception("Player with name '" + name + "' already exists.");
    }

    public boolean addRegion(String name){
        for(Region region : regionList){
            if(region.getName().equals(name)) return false;
        }
        Region region = new Region(name);
        regionList.add(region);
        return true;
    }
    public Region getRegionByName(String name){
        for(Region region : regionList){
            if(region.getName().equals(name)) return region;
        }
        return null;
    }

    public void addQuest(Player author, Region region, String name, String description){
        Quest quest = new Quest(author, region, name, description);
        region.addQuestToRegion(quest);
    }
    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public ArrayList<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(ArrayList<Region> regionList) {
        this.regionList = regionList;
    }
}
