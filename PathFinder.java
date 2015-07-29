// 
// PathFinder.java
//
// Created by Greg Burlet
// Copyright (c) Greg Burlet. All rights reserved.
//

public class PathFinder {

    public static void main (String args[]) {
        // map default sizes
        int mapWidth = 10;
        int mapHeight = 10;
        double rockDensity = 0.1;
        double waterDensity = 0.1;

        if (args.length > 0) {
            try {
                mapWidth = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("First argument must be an integer (Map Width).");
                System.exit(1);
            }
            mapHeight = mapWidth;
        }
        if (args.length > 1) {
            try {
                mapHeight = Integer.parseInt(args[1]);
            } catch (NumberFormatException e2) {
                System.err.println("Second argument must be an integer (Map Height)");
            }
        }
        if (args.length > 2) {
            try {
                rockDensity = Double.parseDouble(args[2]);
            } catch (NumberFormatException e) {
                System.err.println("Third argument must be a float (Rock Density)");
            }
        }
        if (args.length > 3) {
            try {
                waterDensity = Double.parseDouble(args[3]);
            } catch (NumberFormatException e) {
                System.err.println("Third argument must be a float (Water Density)");
            }
        }

        // create map with given rock density
        MapModel mm = new MapModel(mapWidth, mapHeight, rockDensity, waterDensity);
        MapView mv = new MapView();
        MapController mc = new MapController(mm, mv);

        mc.randomizeMap();

        // create agent and air-drop on map
        Agent greg = new Agent("Greg", mm.getRandomLocation()); 
        mc.dropAgent(greg);
    }
}
