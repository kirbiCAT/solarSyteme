package org.example;

import org.example.planetmodel.Planets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static DataManager instance;

    private List<Planets> planets;

    // private constructor → prevents new DataManager()
    private DataManager() {
        planets = new ArrayList<>();
    }

    // global access point
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    // load from JSON ONCE
    public void load() {
        try {
            planets = FileManager.JsonFileReader();
        } catch (IOException e) {
            planets = new ArrayList<>();
            System.out.println("Failed to load planets, using empty list");
        }
    }

    // save EVERYTHING back to JSON
    public void save() throws IOException {
        FileManager.JsonFileWriter(planets);
    }

    // get planets list (shared reference)
    public List<Planets> getPlanets() {
        return planets;
    }

    // optional helper: find planet
    public Planets findByName(String name) {
        for (Planets p : planets) {
            if (p.name.equals(name)) {
                return p;
            }
        }
        return null;
    }
}