import invoiceservice.*;
import org.junit.Assert;
import org.junit.Test;

public class RideRepositoryTest {

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "a@b.com";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenDistanceAndTime_WithNullUserId_ShouldReturnCustomExceptionType() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NO_RIDE_FOUND, e.type);
        }
    }

    @Test
    public void givenDistanceAndTime_WithEmptyRide_ShouldReturnCustomExceptionType() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "";
            Ride[] rides = {
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = rideRepository.getRides(userId);
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NO_RIDE_FOUND, e.type);
        }
    }

    @Test
    public void givenDistanceAndTime_GetRides() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "";
            Ride[] summary = rideRepository.getRides(userId);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NO_RIDE_FOUND, e.type);
        }
    }
}
