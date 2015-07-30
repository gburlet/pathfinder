//
// MapController.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

import java.util.*;

public class MapController {
    
    private MapModel mm;
    private MapView mv;

    public MapController(MapModel model, MapView view) {
        this.mm = model;
        this.mv = view;
    }

    // update terrain densities and randomly generate new map
    public void randomizeMap(double rockDensity, double waterDensity) {
        // update model
        this.mm.setRockDensity(rockDensity);
        this.mm.setWaterDensity(waterDensity);
        this.randomizeMap();
    }

    // member overload for no update of terrain densities
    public void randomizeMap() {
        this.mm.randomizeTerrain();
        this.draw();
    }

    public void dropAgent(Agent a) {
        // update model
        this.mm.addAgent(a);

        // update view
        this.draw();
    }

    public void pathAgent(Agent a, ArrayList<Location> path) {
        for (Location l : path) {
            this.moveAgent(a, l);
        }
    }

    // move agent on the map to a given location
    public void moveAgent(Agent a, Location l) {
        a.teleport(l);

        // update view
        this.draw();
    }

    // Helper function to redraw the view
    private void draw() {
        this.mv.render(this.mm.getCells(), this.mm.getWidth(), this.mm.getHeight(), this.mm.getAgents());
    }
}
