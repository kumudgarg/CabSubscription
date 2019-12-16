import invoiceservice.CabSubscriptions;
import invoiceservice.InvoiceService;
import invoiceservice.InvoiceSummary;
import invoiceservice.Ride;
import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.NORMAL);
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.NORMAL);
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.NORMAL);
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2.0, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRides_ShouldReturnInvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.NORMAL);
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        invoiceService.addRide(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2.0, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenDistanceAndTimeForPremiumSubscription_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.PREMIUM);
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenDistanceAndTimeForPremiumSubscription_ShouldReturnMinimumFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.PREMIUM);
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(20, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesForPremiumSubscription_ShouldReturnTotalFare() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.PREMIUM);
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2.0, 60);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIdAndRidesForPremiumSubscription_ShouldReturnInvoiceSummary() {
        InvoiceService invoiceService = new InvoiceService(CabSubscriptions.PREMIUM);
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        invoiceService.addRide(userId, rides);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2.0, 60);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    
}
