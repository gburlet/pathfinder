//
// MapView.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

import java.util.*;

public class MapView {

    // map from terrain type to visual ASCII representation
    Map<MapCell.Terrain, Character> terrainMap;
    
    public MapView() {
        // construct terrain map
        terrainMap = new HashMap<>();
        terrainMap.put(MapCell.Terrain.GROUND, '_');
        terrainMap.put(MapCell.Terrain.ROCK, '^');
        terrainMap.put(MapCell.Terrain.WATER, '~');
    }

    public void render(MapCell[][] grid, int width, int height) {
        for (int i = 0; i < width; i++) {
            String row = "";
            for (int j = 0; j < height; j++) {
                row += terrainMap.get(grid[i][j].getTerrain());
                if (j < height-1) {
                    row += ' ';
                }
            }
            System.out.println('[' + row + "]\n");
        }
    }
}
