import jdk.internal.jline.internal.Nullable;

import java.io.File;
import java.nio.file.FileSystems;

public class FileCreator {

    public @Nullable File createFile(){
        File file = new File(FileSystems.getDefault().getPath("output.txt").toAbsolutePath().toString());
        try{
            file.delete();
            boolean isCreated = file.createNewFile();
            if(isCreated){
                return file;
            }
            return null;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
