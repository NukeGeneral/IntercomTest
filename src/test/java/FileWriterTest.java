import org.junit.*;
import org.junit.rules.ExpectedException;

import java.io.*;
import java.util.ArrayList;

public class FileWriterTest {

    private FileWriter fileWriter;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void init(){
        fileWriter = new FileWriter();
    }

    @Test(expected = IOException.class)
    public void corruptFileTest() throws FileNotFoundException,UnsupportedEncodingException{
        fileWriter.writeDataToFile(null,new File(""));
    }

    @Test()
    public void regularFileTest() throws IOException{
        ArrayList<Data> testData = new ArrayList<>();
        Data data = new Data();
        data.setUserId(12);
        data.setName("Christina McArdle");
        data.setLatitude("52.986375");
        data.setLongitude("-6.043701");
        testData.add(data);
        File file = new File("test.txt");
        fileWriter.writeDataToFile(testData,file);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        Assert.assertNotNull(br.readLine());
    }

    @After
    public void clean(){
        fileWriter = null;
    }
}
