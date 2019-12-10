package by.bsu.rent.test;

import by.bsu.rent.model.PageError;
import by.bsu.rent.page.HomePage;
import by.bsu.rent.service.CarReservationCreator;
import by.bsu.rent.service.PageErrorCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends CommonConditions {
    @Test(testName = "testcase 1: Search car for negative rental period")
    public void searchCarsForNegativeRentalPeriodTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withNegativeRentalPeriodFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForNegativeRentalPeriodFromProperty();
        Assert.assertTrue(page.checkTimeErrorMessage(expectedError));
    }

    @Test(testName = "testcase 2: Search car for rental period more than year")
    public void searchCarsForRentalPeriodMoreThanYearTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withRentalPeriodMoreThanYearFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForRentalPeriodMoreThanYearFromProperty();
        Assert.assertTrue(page.checkTimeErrorMessage(expectedError));
    }

    @Test(testName = "testcase 3: Search car at no available place")
    public void searchCarsAtNotAvailablePlaceTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withNotAvailablePlaceFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForNotAvailablePlaceFromProperty();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test(testName = "testcase 4: Search car for current pick-up date")
    public void searchCarsForCurrentPickUpDateTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withCurrentPickUpDateFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForCurrentPickUpDateFromProperty();
        Assert.assertTrue(page.checkTimeErrorMessage(expectedError));
    }

    @Test(testName = "testcase 5: Search car for past pick-up date")
    public void searchCarsForPastPickUpDateTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withPastPickUpDateFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForPastPickUpDateFromProperty();
        Assert.assertTrue(page.checkTimeErrorMessage(expectedError));
    }

    @Test(testName = "testcase 6: Search car for pick-up and return places across continents")
    public void searchCarsForPickUpAndReturnPlacesAcrossContinentsTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withPickUpAndReturnPlacesAcrossContinentsFromProperty()).search();
        PageError expectedError = PageErrorCreator.errorForPickUpAndReturnPlacesAcrossContinentsFromProperty();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

    @Test(testName = "testcase 7: Search car with empty fields")
    public void searchCarsWithEmptyFieldsTest() {
        HomePage page = new HomePage(driver);
        page.openPage().fillFromParams(CarReservationCreator.withEmptyFields()).search();
        PageError expectedError = PageErrorCreator.errorForEmptyFieldsFromProperty();
        Assert.assertTrue(page.checkPlaceErrorMessage(expectedError));
    }

}
