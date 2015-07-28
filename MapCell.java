//
// MapCell.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

class MapCell {
    enum Terrain { GROUND, ROCK, WATER }

    private Terrain type;

    public MapCell() {
        this.type = Terrain.GROUND;
    }

    public MapCell(Terrain type) {
        this.type = type;
    }

    // getters
    public Terrain getTerrain() {
        return this.type;
    }
}
