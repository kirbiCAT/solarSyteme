package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.planetmodel.FavorableProperties;
import org.example.planetmodel.Planets;

import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileManager {

    static ObjectMapper mapper = new ObjectMapper();
    static File file = new File("src/main/resources/Planets.json");
    FavorableProperties favorableProperties = mapper.readValue(new File("src/main/resources/PlanetsFavorable.json"), FavorableProperties.class);

    public FileManager() throws IOException {
    }

    public static List<Planets> JsonFileReader() throws IOException {


            List<Planets> planetList;

            // After (checks if file exists AND has content):
            if (file.exists() && file.length() > 0) {
                planetList = mapper.readValue(file, new TypeReference<List<Planets>>() {});
            } else {
                planetList = new ArrayList<>();
            }


            for(Planets planet : planetList) {
                System.out.println(mapper.writeValueAsString(planet));
                }
            return planetList;
        };

        public static void JsonFileWriter(List<Planets> planetList) throws IOException {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(file,planetList);
        }

//
//
//            for(Planets planet : planetList) {
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
        }


