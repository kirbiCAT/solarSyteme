package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class STORE2 {
//    package org.example;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.IOException;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//    public class Main {
//
//        public static class FavorableProperties {
//            public int water;
//            public int temperature;
//            public float gravity;
//            public int atmosphereDensity;
//            public int mineralDeposition;
//        }
//
//        public static class Planets {
//            public String name;
//            public int age;
//            public boolean active;
//
//
//            public org.example.Main.UserProperties userProperties = new org.example.Main.UserProperties(); // ← always ready
//            public org.example.Main.Composition composition    = new org.example.Main.Composition();
//        }
//
//        public static class UserProperties {
//            public int userWater;
//            public int userTemperature;
//            public float userGravity;
//            public int userAtmosphereDensity;
//            public int userMineralDeposition;
//        }
//
//        public static class Composition {
//            public boolean H2O;
//            public boolean CO2;
//            public boolean He;
//            public boolean O2;
//            public boolean Si;
//
//        }
//
//        private static double scoreProperty(double idealVal, double userVal) {
//            if (userVal == 0) return 0;
//            return Math.min(100, (userVal / idealVal) * 100);
//        }
//
//        public static double PropertiesCalculator(org.example.Main.Planets planets, org.example.Main.FavorableProperties favorableProperties) {
//            org.example.Main.FavorableProperties fp = favorableProperties;
//            org.example.Main.UserProperties up = planets.userProperties;
//
//            final int    MAX_WATER       = 100;
//            final int    MAX_TEMPERATURE = 60;
//            final float  MAX_GRAVITY     = 25;
//            final int    MAX_ATMOSPHERE  = 100;
//            final int    MAX_MINERAL     = 100;
//
//            double userWater       = Math.min(up.userWater,             MAX_WATER);
//            double userTemp        = Math.min(up.userTemperature,       MAX_TEMPERATURE);
//            double userGravity     = Math.min(up.userGravity,           MAX_GRAVITY);
//            double userAtmosphere  = Math.min(up.userAtmosphereDensity, MAX_ATMOSPHERE);
//            double userMineral     = Math.min(up.userMineralDeposition, MAX_MINERAL);
//
//            // Any zero value = immediately incompatible
//            if (up.userWater == 0)             return 0;
//            if (up.userTemperature == 0)       return 0;
//            if (up.userGravity == 0)           return 0;
//            if (up.userAtmosphereDensity == 0) return 0;
//            if (up.userMineralDeposition == 0) return 0;
//
//            double waterScore      = scoreProperty(fp.water,             up.userWater);
//            double tempScore       = scoreProperty(fp.temperature,       up.userTemperature);
//            double gravityScore    = scoreProperty(fp.gravity,           up.userGravity);
//            double atmosphereScore = scoreProperty(fp.atmosphereDensity, up.userAtmosphereDensity);
//            double mineralScore    = scoreProperty(fp.mineralDeposition, up.userMineralDeposition);
//
//            System.out.printf("  water:       %.1f%%\n", waterScore);
//            System.out.printf("  temperature: %.1f%%\n", tempScore);
//            System.out.printf("  gravity:     %.1f%%\n", gravityScore);
//            System.out.printf("  atmosphere:  %.1f%%\n", atmosphereScore);
//            System.out.printf("  mineral:     %.1f%%\n", mineralScore);
//
//            return (waterScore      * 0.35)
//                    + (tempScore       * 0.25)
//                    + (gravityScore    * 0.20)
//                    + (atmosphereScore * 0.10)
//                    + (mineralScore    * 0.10);
//        }
//
//
//
//        public static void main(String[] args) throws IOException {
//            ObjectMapper mapper = new ObjectMapper();
//            File file = new File("src/main/resources/Planets.json");
//            org.example.Main.FavorableProperties favorableProperties = mapper.readValue(new File("src/main/resources/PlanetsFavorable.json"), org.example.Main.FavorableProperties.class);
//
//            List<org.example.Main.Planets> planetList;
//
//            // After (checks if file exists AND has content):
//            if (file.exists() && file.length() > 0) {
//                planetList = mapper.readValue(file, new TypeReference<List<org.example.Main.Planets>>() {});
//            } else {
//                planetList = new ArrayList<>();
//            }
//
//
//            org.example.Main.Planets planets = new org.example.Main.Planets();
//
//            planets.userProperties.userWater             = 100;
//            planets.userProperties.userTemperature       = 1;
//            planets.userProperties.userGravity           = 1;
//            planets.userProperties.userAtmosphereDensity = 1;
//            planets.userProperties.userMineralDeposition = 1;
//
//            planets.composition.O2 = false;
//            planets.composition.H2O = true;
//
//            planetList.add(planets);
//
//            mapper.writerWithDefaultPrettyPrinter()
//                    .writeValue(file,planetList);
//
//            System.out.println("--- Property Scores ---");
//            double compatibilityScore = PropertiesCalculator(planets,favorableProperties);
//            System.out.printf("Planet compatibility: %.1f%%\n", compatibilityScore);
//
//
//
//            for(org.example.Main.Planets planet : planetList) {
//                if(Objects.equals(planet.name, "bob")){
//                    planet.name = "lucas";
//                    System.out.println(mapper.writeValueAsString(planet));
//                }
//
//
//            }
//            planetList.removeIf(planet -> Objects.equals(planet.name, "bob"));
//            mapper.writerWithDefaultPrettyPrinter()
//                    .writeValue(file,planetList);
//        }
//    }
}
