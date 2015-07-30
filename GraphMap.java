//
// GraphMap.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

import java.util.*;
import org.jgrapht.*;
import org.jgrapht.graph.*;
import org.jgrapht.alg.*;

// Graph representation of the MapModel 
public class GraphMap {

    private MapModel mm;
    private int gWeight, rWeight, wWeight; // edge weights for ground, rocks, water
    private DefaultDirectedWeightedGraph<Location, DefaultWeightedEdge> g;
    private static Map<MapCell.Terrain, Integer> edgeMap;

    public GraphMap(MapModel mm, int gWeight, int rWeight, int wWeight) {
        this.mm = mm;
        this.gWeight = gWeight;
        this.rWeight = rWeight;
        this.wWeight = wWeight;

        this.g = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);

        MapCell[][] grid = mm.getCells();
        // add vertices
        for (int i = 0; i < mm.getWidth(); i++) {
            for (int j = 0; j < mm.getHeight(); j++) {
                g.addVertex(grid[i][j].getLocation());
            }
        }

        // add edges
        int[] surroundings = {-1, 0, 1};
        edgeMap = new HashMap<>();
        edgeMap.put(MapCell.Terrain.GROUND, this.gWeight);
        edgeMap.put(MapCell.Terrain.ROCK, this.rWeight);
        edgeMap.put(MapCell.Terrain.WATER, this.wWeight);

        for (int i = 0; i < mm.getWidth(); i++) {
            for (int j = 0; j < mm.getHeight(); j++) {
                for (int iSur : surroundings) {
                    for (int jSur : surroundings) {
                        // bound checking
                        if (i+iSur < 0 || i+iSur >= mm.getWidth() || j+jSur < 0 || j+jSur >= mm.getHeight() || (iSur == 0 && jSur == 0)) {
                            continue;
                        }

                        int edgeWeight = edgeMap.get(grid[i][j].getTerrain()) + edgeMap.get(grid[i+iSur][j+jSur].getTerrain());
                        DefaultWeightedEdge e = g.addEdge(grid[i][j].getLocation(), grid[i+iSur][j+jSur].getLocation());
                        g.setEdgeWeight(e, (double) edgeWeight);
                    }
                }
            }
        }
    }

    // get the shortest path between two locations on the map
    // uses Dijkstra's Algorithm
    public ArrayList<Location> shortestPath(Location start, Location target) {
        List<DefaultWeightedEdge> edges = DijkstraShortestPath.findPathBetween(this.g, start, target);
        ArrayList<Location> path = new ArrayList<>();
        for (DefaultWeightedEdge e : edges) {
            path.add(this.g.getEdgeTarget(e));
        }

        return path;
    }
}
