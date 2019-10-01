import java.util.ArrayList;

public class DistanceCalculator {

    /**
     * Distance between starting location to end location(Unit in meters)
     * @param distanceFrom
     * @return Distance between two points in earth in meters
     */
    public double distanceFromLocation(MyLocation distanceFrom){
        initialConditions(distanceFrom);
        MyLocation currentLocation = getCurrentLocation();
        double lambda1 = currentLocation.getLng();
        double phi1 = currentLocation.getLat();

        double lambda2 = distanceFrom.getLng();
        double phi2 = distanceFrom.getLat();

        double deltaLambda = Math.abs(lambda1 - lambda2);

        double radius = 6371000;

        return radius * Math.atan(Math.sqrt(Math.pow(Math.cos(phi2)*Math.sin(deltaLambda),2) + Math.pow(((Math.cos(phi1) * Math.sin(phi2)) - (Math.sin(phi1) * Math.cos(phi2) * Math.cos(deltaLambda))),2))) /
                (Math.sin(phi1)*Math.sin(phi2)) + (Math.cos(phi1) * Math.cos(phi2) * deltaLambda);
    }

    /**
     * Converting degrees to radians
     * @param requested
     * @return Location lat/lng parameters as object converted to radians
     */

    public MyLocation degreesToRadians(MyLocation requested){
        requested.setLat(Math.toRadians(requested.getLat()));
        requested.setLng(Math.toRadians(requested.getLng()));
        return requested;
    }

    private MyLocation getCurrentLocation(){
        MyLocation currentLocation = new MyLocation();
        currentLocation.setLat(53.339428);
        currentLocation.setLng(-6.257664);
        return degreesToRadians(currentLocation);
    }

    private void initialConditions(MyLocation distanceFrom){
        degreesToRadians(distanceFrom);
    }

    public void calculateDistances(ArrayList<Data> objectArray){
        if(objectArray.size() == 0){
            return;
        }
        for(Data data : objectArray){
            MyLocation current = new MyLocation();
            current.setLng(Double.parseDouble(data.getLongitude()));
            current.setLat(Double.parseDouble(data.getLatitude()));
            data.setDistance(distanceFromLocation(current));
        }
    }
}
