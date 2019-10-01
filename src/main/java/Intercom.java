import com.google.gson.Gson;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Comparator;

public class Intercom {

    public static void main(String[] args) {

        FileParser parser = new FileParser();
        ArrayList<String> parsedValue;

        try{
            parsedValue = parser.parseFileAsString(FileSystems.getDefault().getPath("customer.txt").toAbsolutePath().toString());
        }catch (Exception e){
            e.printStackTrace();
            return;
        }

        if(parsedValue.size() == 0){
            return;
        }

        ArrayList<Data> objectArray = parser.parseData(parsedValue);

        DistanceCalculator calculator = new DistanceCalculator();
        calculator.calculateDistances(objectArray);

        objectArray.removeIf(data -> data.getDistance() > 100000);
        objectArray.sort(Comparator.comparing(Data::getUserId));

        FileCreator fileCreator = new FileCreator();
        File file = fileCreator.createFile();

        if(file != null){
            try{
                FileWriter fileWriter = new FileWriter();
                fileWriter.writeDataToFile(objectArray,file);
            }catch (FileNotFoundException | UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
    }
}
