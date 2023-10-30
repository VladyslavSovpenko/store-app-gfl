package services;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import entity.Producer;
import entity.Souvenir;
import utils.Utils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ReadWriteService {

    private String filePath = "newFile.txt";
    private static ReadWriteService readWriteService = new ReadWriteService();
    private static Warehouse warehouse = Warehouse.getInstance();
    ObjectMapper objectMapper = new ObjectMapper();

    private ReadWriteService() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static ReadWriteService getInstance() {
        return readWriteService;
    }

    public void saveToFile() {
        File file = createFile();

        ObjectNode parentObject = objectMapper.createObjectNode();
        objectMapper.registerModule(new JavaTimeModule());
        parentObject.put("producer", objectMapper.valueToTree(warehouse.getAllProducers()));
        parentObject.put("souvenir", objectMapper.valueToTree(warehouse.getAllSouvenirs()));

        try {
            objectMapper.writeValue(file, parentObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Utils.INFO_SAVED);
    }

    public void readFromFile() {
        try {
            File file = new File(filePath);

            JsonNode parentObject = objectMapper.readTree(file);

            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));

            Producer[] producersArray = objectMapper.treeToValue(parentObject.get("producer"), Producer[].class);
            Souvenir[] souvenirsArray = objectMapper.treeToValue(parentObject.get("souvenir"), Souvenir[].class);

            Arrays.stream(producersArray).forEach(producer -> warehouse.saveToProducers(producer));
            Arrays.stream(souvenirsArray).forEach(souvenir -> warehouse.saveToSouvenirs(souvenir));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Utils.INFO_READ);
    }

    private File createFile() {
        File file = null;
        try {
            file = new File(filePath);
            file.createNewFile();
        } catch (IOException e) {
        }
        return file;
    }
}
