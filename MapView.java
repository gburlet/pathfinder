//
// MapView.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

import java.util.*;

public class MapView {

    // map from terrain type to visual ASCII representation
    private static Map<MapCell.Terrain, Character> terrainMap;
    
    public MapView() {
        // construct terrain map
        terrainMap = new HashMap<>();
        terrainMap.put(MapCell.Terrain.GROUND, '_');
        terrainMap.put(MapCell.Terrain.ROCK, '^');
        terrainMap.put(MapCell.Terrain.WATER, '~');
    }

    public void render(MapCell[][] grid, int width, int height, List<Agent> agents) {
        // pause for a given amount of time to see frame in "animation"
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        this.clearConsole();

        for (int i = 0; i < width; i++) {
            String row = "";
            for (int j = 0; j < height; j++) {
                Location loc = new Location(i,j);
                boolean agentHere = false;
                for (Agent a : agents) {
                    if (a.getCurrentLocation().equals(loc)) {
                        row += a.getName().substring(0,1);
                        agentHere = true;
                    }
                }

                if (!agentHere) {
                    row += terrainMap.get(grid[i][j].getTerrain());
                }

                if (j < height-1) {
                    row += ' ';
                }
            }
            System.out.println('[' + row + "]\n");
        }
        System.out.println("\n");
    }

    public final static void clearConsole()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
