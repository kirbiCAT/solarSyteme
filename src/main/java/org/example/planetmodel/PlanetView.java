package org.example.planetmodel;

import javafx.scene.shape.Circle;

public class PlanetView {
    public Planets data;
    public Circle circle;

    public PlanetView(Planets p, Circle c) {
        this.data = p;
        this.circle = c;
    }
}
