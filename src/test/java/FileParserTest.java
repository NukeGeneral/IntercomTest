import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class FileParserTest {

    private FileParser fileParser;

    @Before
    public void init(){
        fileParser = new FileParser();
    }

    @Test(expected = IOException.class)
    public void parseCorruptFile() throws IOException {
        ArrayList<String> data = fileParser.parseFileAsString(getClass().getResource("").getFile());
        Assert.assertEquals(0,data.size());
    }

    @Test(expected = Exception.class)
    public void parseCorruptData() throws IOException {
        ArrayList<String> data = fileParser.parseFileAsString(getClass().getResource("customer_broken.txt").getFile());
        fileParser.parseData(data);
    }

    @Test
    public void parseRegularData() throws Exception{
        ArrayList<String> data = fileParser.parseFileAsString(getClass().getResource("customer.txt").getFile());
        Assert.assertNotEquals(0,data.size());
        ArrayList<Data> objectList = fileParser.parseData(data);
        Assert.assertEquals(12,objectList.get(0).getUserId().intValue());
    }
}
