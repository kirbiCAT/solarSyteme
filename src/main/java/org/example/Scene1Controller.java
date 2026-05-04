package org.example;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import org.example.planetmodel.PlanetView;
import org.example.planetmodel.Planets;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Scene1Controller implements Initializable {

    @FXML
    AnchorPane mainroot;







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Circle sun = new Circle(50, Color.YELLOW);
        sun.setLayoutX(500);
        sun.setLayoutY(280);
        mainroot.getChildren().add(sun);

        mainroot.setStyle(
                "-fx-background-color: radial-gradient(center 50% 50%, radius 100%, #020111, #000000);"
        );

        org.example.DataManager dm = org.example.DataManager.getInstance();
        dm.load();
        List<Planets> planets = dm.getPlanets();

        List<PlanetView> planetViewList = new ArrayList<>();
        Map<String, PlanetView> map = new HashMap<>();

        // CREATE PLANETS
        for (Planets p : planets) {

            Circle c = new Circle();

            c.setFill(Color.valueOf(p.color.toUpperCase()));
            c.setStroke(Color.WHITE);
            c.setStrokeWidth(1);
            c.setRadius(p.size);

            // random start angle
            p.angle = (float) (Math.random() * Math.PI * 2);

            PlanetView view = new PlanetView(p, c);

            map.put(p.name, view);
            planetViewList.add(view);

            mainroot.getChildren().add(c);

            // optional click
            c.setOnMouseClicked(e -> {
                try {
                    FXMLLoader loader = new FXMLLoader(
                            getClass().getResource("/planet-view.fxml")
                    );

                    Parent root = loader.load();

                    PlanetControllerUi controller = loader.getController();
                    controller.setPlanetView(view);
                    //controller.setPlanets(planets);



                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle(p.name);
                    //show current planet info


                    stage.show();

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }

        // ANIMATION LOOP
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                // PASS 1: compute positions
                for (PlanetView v : planetViewList) {

                    v.data.angle += v.data.speed;

                    double cx, cy;

                    if (v.data.parent == null || v.data.parent.equals("sun")) {
                        cx = sun.getLayoutX();
                        cy = sun.getLayoutY();
                    } else {
                        PlanetView parent = map.get(v.data.parent);

                        if (parent == null) continue;

                        cx = parent.data.x;
                        cy = parent.data.y;
                    }

                    v.data.x = cx + Math.cos(v.data.angle) * v.data.radian;
                    v.data.y = cy + Math.sin(v.data.angle) * v.data.radian;
                }

                // PASS 2: render
                for (PlanetView v : planetViewList) {
                    v.circle.setCenterX(v.data.x);
                    v.circle.setCenterY(v.data.y);
                }
            }
        };

        timer.start();
    }
}