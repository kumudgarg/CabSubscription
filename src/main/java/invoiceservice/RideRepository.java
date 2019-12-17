package invoiceservice;

import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRides = null;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) throws RideRepositoryException {
        if(rides != null)
            this.userRides.put(userId, new ArrayList<>(Arrays.asList(rides)));
        throw new RideRepositoryException("Rides are Empty", RideRepositoryException.ExceptionType.NO_RIDE_FOUND);
    }

    public Ride[] getRides(String userId) throws RideRepositoryException {
        if (userId != "")
            return this.userRides.get(userId).toArray(new Ride[0]);
        else
            throw new RideRepositoryException("Null value passed", RideRepositoryException.ExceptionType.NULL_VALUE);
    }
}
