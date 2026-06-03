package org.example.planetmodel;

import javafx.fxml.FXML;
import org.example.DataManager;

public class SunControllerUI {

    private  Planets planet;
    private PlanetView view;





    public void setPlanetView(PlanetView view) {
        this.view = view;
        this.planet = DataManager.getInstance().findByName(view.data.name);
        showCurrentPlanetInfo();

    }

    public void PauseScene(){

    }




    @FXML
    public void initialize() {









    }

    public void showCurrentPlanetInfo(){


    }


}
