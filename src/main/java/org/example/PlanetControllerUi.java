package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import org.example.planetmodel.PlanetView;
import org.example.planetmodel.Planets;

import java.io.IOException;
import java.util.List;


public class PlanetControllerUi {
        private  Planets planet;
        private PlanetView view;

        @FXML
        Slider AgeSlider;
        @FXML
        Slider RadianSlider;
        @FXML
        Slider SpeedSlider;

        @FXML
        ChoiceBox<String> ParentChoice;
        /// Choice<String> gopalota </String>


        @FXML
        ColorPicker colorPicker;

    @FXML Label CurrentName;
    @FXML Label CurrentAge;
    @FXML Label CurrentSize;
    @FXML Label CurrentRadian;
    @FXML Label CurrentSpeed;
    @FXML Label CurrentAngle;
    @FXML Label CurrentColor;
    @FXML Label CurrentParent;




        public void setPlanetView(PlanetView view) {
            this.view = view;
            this.planet = view.data;
            showCurrentPlanetInfo();
            if (planet != null)
                ParentChoice.setValue(planet.parent);
        }



        private String toHex(Color color) {
            return String.format("#%02X%02X%02X",
                    (int)(color.getRed()*255),
                    (int)(color.getGreen()*255),
                    (int)(color.getBlue()*255));
        }

    @FXML
    public void initialize() {

        org.example.DataManager dm = org.example.DataManager.getInstance();
        dm.load();
        List<Planets> planetsList = dm.getPlanets();
        ParentChoice.getItems().clear();
        ParentChoice.getItems().add("sun");
        for (Planets p : planetsList) {
            ParentChoice.getItems().add(p.name);

        }



        AgeSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();

            planet.age = value;
            showCurrentPlanetInfo();
        });

        RadianSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            int value = newVal.intValue();

            planet.radian = value;
            showCurrentPlanetInfo();
        });

        SpeedSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            float value = newVal.floatValue();

            planet.speed = (float) value;
            showCurrentPlanetInfo();
        });

        ParentChoice.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            planet.parent = newVal;
        });




        }










    public void changeColor(ActionEvent e) throws IOException {
        Color newColor = colorPicker.getValue();

        view.circle.setFill(newColor);   // UI update (instant)
        planet.color = toHex(newColor);

        DataManager.getInstance().save();
        showCurrentPlanetInfo();
    }







    public void showCurrentPlanetInfo(){
        CurrentName.setText("Name:"+planet.name);
        CurrentAge.setText(String.valueOf("Age:"+planet.age));
        CurrentSize.setText(String.valueOf("Size:"+planet.size));
        CurrentRadian.setText(String.valueOf("Radian:"+planet.radian));
        CurrentSpeed.setText(String.valueOf("Speed:"+planet.speed));
        CurrentAngle.setText(String.valueOf("Angle:"+planet.angle));
        CurrentColor.setText("Color:"+planet.color);
        CurrentParent.setText("Parent:"+planet.parent);

    }


}
