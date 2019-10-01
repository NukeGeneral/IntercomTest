import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DistanceCalculatorTest {

    private DistanceCalculator distanceCalculator;

    @Before
    public void init(){
        distanceCalculator = new DistanceCalculator();
    }

    @Test
    public void calculateDistance(){
        ArrayList<Data> testData = new ArrayList<>();
        Data data = new Data();
        data.setUserId(12);
        data.setName("Christina McArdle");
        data.setLatitude("52.986375");
        data.setLongitude("-6.043701");
        testData.add(data);
        distanceCalculator.calculateDistances(testData);
        Assert.assertEquals(65207,Math.round(data.getDistance()));
    }

    @Test
    public void degreesToRadians(){
        MyLocation location = new MyLocation();
        location.setLng(100);
        location.setLat(-60);
        distanceCalculator.degreesToRadians(location);
        Assert.assertEquals(-1.047,location.getLat(),0.001);
    }

    @Test
    public void distanceFromLocation(){
        MyLocation location = new MyLocation();
        location.setLat(53.008769);
        location.setLng(-6.1056711);
        Assert.assertEquals(59521,distanceCalculator.distanceFromLocation(location),1);
    }

    @After
    public void clean(){
        distanceCalculator = null;
    }

}
