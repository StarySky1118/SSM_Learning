package com.zzy.DI.bean;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Team {
    private String name;
//    private Player[] players;

//    private List<Player> players;

    private Set<Player> players;
    public void setName(String name) {
        this.name = name;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}
