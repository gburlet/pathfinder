//
// MapCell.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

class MapCell {
    
    public enum Terrain { GROUND, ROCK, WATER }

    private Terrain type;
    private Location location;

    public MapCell(Location l) {
        this.type = Terrain.GROUND;
        this.location = l;
    }

    public MapCell(Terrain type, Location l) {
        this.type = type;
        this.location = l;
    }

    // getters and setters
    public Terrain getTerrain() {
        return this.type;
    }

    public void setTerrain(Terrain type) {
        this.type = type;
    }

    public Location getLocation() {
        return this.location;
    }
}
