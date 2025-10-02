package logic;

import java.util.ArrayList;

public class Region {
    private String name;
    private ArrayList<Player> playerList;
    private ArrayList<Quest> questList;

    //constructor

    public Region(String name){
        setName(name);
        this.playerList = new ArrayList<>();
        this.questList = new ArrayList<>();
    }
    //method
    public  void setName(String name){
        if(name.isBlank()) name = "Nowhere";
        this.name = name;
    }

    public int getPlayerCount(){
        return playerList.size();
    }

    public double getRegionRank(){
        double avg = 0;
        for(Player player : playerList){
            avg += player.getRank();
        }
        avg /= playerList.size();
        return Math.round(avg * 100.0) / 100.0;
    }

    public ArrayList<Quest> getAvailableQuests(Player viewer){
        ArrayList<Quest> availableQuests = new ArrayList<>();
        for(Quest availableQuest : questList){
            if(availableQuest.getStatus().equals(Status.AVAILABLE) &&
                    !availableQuest.getAuthor().getName().equals(viewer.getName())){
                availableQuests.add(availableQuest);
            }
        }
        return availableQuests;
    }

    public void addPlayerToRegion(Player p){
        getPlayerList().add(p);
    }

    public void addQuestToRegion(Quest q){
        getQuestList().add(q);
    }

    public ArrayList<Quest> getQuestList() {
        return questList;
    }

    public void setQuestList(ArrayList<Quest> questList) {
        this.questList = questList;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public String getName() {
        return name;
    }
}
