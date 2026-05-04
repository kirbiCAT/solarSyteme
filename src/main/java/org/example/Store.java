package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
//    ObjectMapper mapper = new ObjectMapper();
//    String json = "{\"name\":\"Alice\",\"age\":30}";
//
//    // Parse to a tree (flexible, no class needed)
//    JsonNode node = mapper.readTree(json);
//    String name = node.get("name").asText();   // "Alice"
//    int age  = node.get("age").asInt();        // 30
//
//    // Parse to a Map
//    Map<String, Object> map =
//            mapper.readValue(json, new TypeReference<>() {});
//
//    // Parse to a List of Maps
//    String jsonArr = "[{\"id\":1},{\"id\":2}]";
//    List<Map<String,Object>> list =
//            mapper.readValue(jsonArr, new TypeReference<>() {});
//    /// //////////////////////////////----------------------------------
//
//    JsonNode root = mapper.readTree(json);
//
//// Direct access
//        root.get("name").asText();
//
//// Nested object
//        root.get("address").get("city").asText();   // "Paris"
//
//// Array element by index
//        root.get("tags").get(0).asText() ;           // "admin"
//
//// Safe access — returns MissingNode, not null
//        root.path("missing").path("nested").asText("default");
//
//// Check if key exists
//        root.has("name") ;         // true
//        root.hasNonNull("score") ;  // false (key exists but is null)
//
//// Iterate all keys
//        root.fieldNames().forEachRemaining(k -> System.out.println(k));
//
//// Iterate array
//        for (JsonNode tag : root.get("tags")) {
//        System.out.println(tag.asText());
//    }
//
//
//    Map<String, Object> data = new HashMap<>();
//        data.put("name", "Alice");
//        data.put("age", 30);
//
//// Compact
//    json = mapper.writeValueAsString(data);
//
//    // Pretty-printed
//    String pretty = mapper
//            .writerWithDefaultPrettyPrinter()
//            .writeValueAsString(data);

}
