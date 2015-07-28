//
// MapView.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class MapView {
    public MapView() {}

    public void render(MapCell[][] grid, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.println(grid[i][j].getTerrain());
            }
        }
    }
}
