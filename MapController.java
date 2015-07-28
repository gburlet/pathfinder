//
// MapController.java
//
// Created by Greg Burlet.
// Copyright (c) 2015 Greg Burlet. All rights reserved.
//

public class MapController {
    private MapModel mm;
    private MapView mv;

    public MapController(MapModel model, MapView view) {
        this.mm = model;
        this.mv = view;
    }

    public void draw() {
        this.mv.render(this.mm.getCells(), this.mm.getWidth(), this.mm.getHeight());
    }
}
