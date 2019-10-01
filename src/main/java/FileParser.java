import com.google.gson.Gson;
import jdk.internal.jline.internal.Nullable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {

    /**
     * For given input contains lines of json files,converts to ArrayList<String>
     * @param fileName
     * @return Array of strings contains,needs to be parsed as object later
     * @throws Exception
     */
    public @Nullable ArrayList<String> parseFileAsString(@Nullable String fileName) throws IOException {
        if(fileName == null || fileName.isEmpty()){
            return null;
        }
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> jsonList = new ArrayList<>();
        try {
            String line = reader.readLine();
            while (line != null) {
                jsonList.add(line);
                line = reader.readLine();
            }
        } finally {
            reader.close();
        }
        return jsonList;
    }

    public ArrayList<Data> parseData(ArrayList<String> parsedValue){
        Gson gson = new Gson();
        ArrayList<Data> objectArray = new ArrayList<>();
        for(String data : parsedValue){
            objectArray.add(gson.fromJson(data,Data.class));
        }
        return objectArray;
    }
}
