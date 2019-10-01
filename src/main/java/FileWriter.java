import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileWriter {

    public void writeDataToFile(ArrayList<Data> objectArray, File file) throws FileNotFoundException, UnsupportedEncodingException{
        String filesToWrite = new Gson().toJson(objectArray);
        PrintWriter writer = new PrintWriter(file.getName(), "UTF-8");
        writer.println(filesToWrite);
        writer.close();
    }
}
