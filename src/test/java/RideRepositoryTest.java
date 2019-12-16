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
            Ride[] summary = new Ride[0];
            summary = rideRepository.getRides(userId);
            Assert.assertEquals(rides[0], summary[0]);
        } catch (RideRepositoryException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        try {
            RideRepository rideRepository = new RideRepository();
            String userId = "";
            Ride[] rides = {new Ride(2.0, 5),
                    new Ride(0.1, 1)
            };
            rideRepository.addRides(userId, rides);
            Ride[] summary = new Ride[0];
            summary = rideRepository.getRides(userId);
        } catch (RideRepositoryException e) {
            Assert.assertEquals(RideRepositoryException.ExceptionType.NULL_VALUE, e.type);
        }
    }

}
