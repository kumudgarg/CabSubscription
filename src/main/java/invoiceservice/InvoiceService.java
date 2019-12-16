package invoiceservice;

public class InvoiceService {

    private static final int COST_PER_TIME_FOR_NORMAL = 1;
    private static final int COST_PER_TIME_FOR_PREMIUM = 2;
    private static final double MINIMUM_COST_PER_KILOMETER_NORAMAL = 10;
    private static final Double MINIMUM_FARE_NORMAL = 5.0;
    private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;
    private static final Double MINIMUM_FARE_PREMIUM = 20.0;
    private CabSubscriptions cabSubscriptions;

    RideRepository rideRepository;

    public InvoiceService(CabSubscriptions cabSubscriptions) {
        this.rideRepository = new RideRepository();
        this.cabSubscriptions = cabSubscriptions;
    }

    public double calculateFare(double distance, int time) {
        if (CabSubscriptions.NORMAL.equals(this.cabSubscriptions)) {
            Double totalFare = distance * MINIMUM_COST_PER_KILOMETER_NORAMAL + time * COST_PER_TIME_FOR_NORMAL;
            if (totalFare < MINIMUM_FARE_NORMAL)
                return MINIMUM_FARE_NORMAL;
            return totalFare;

        }
        if (CabSubscriptions.PREMIUM.equals(this.cabSubscriptions)) {
            Double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_FOR_PREMIUM;
            if (totalFare < MINIMUM_FARE_PREMIUM)
                return MINIMUM_FARE_PREMIUM;
            return totalFare;
        }
        return 0.0;
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(rides.length, (int) totalFare);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) throws RideRepositoryException {
        try {
            return this.calculateFare(rideRepository.getRides(userId));
        } catch (RideRepositoryException e) {
            throw new RideRepositoryException(e.getMessage(), RideRepositoryException.ExceptionType.NULL_VALUE);
        }
    }
}
