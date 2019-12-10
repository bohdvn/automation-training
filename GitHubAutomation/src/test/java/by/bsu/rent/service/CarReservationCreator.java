package by.bsu.rent.service;

import by.bsu.rent.model.CarReservation;
import by.bsu.rent.model.ReservationDates;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CarReservationCreator {
    private static final String TESTDATA_CASE_1_PLACE_FROM = "testdata.case1.place-from";
    private static final String TESTDATA_CASE_1_PLACE_TO = "testdata.case1.place-to";
    private static final String TESTDATA_CASE_1_PICK_UP_PLUS_DAYS = "testdata.case1.pick-up.plus-days";
    private static final String TESTDATA_CASE_1_RETURN_PLUS_DAYS = "testdata.case1.return.plus-days";

    private static final String TESTDATA_CASE_2_PLACE_FROM = "testdata.case2.place-from";
    private static final String TESTDATA_CASE_2_PLACE_TO = "testdata.case2.place-to";
    private static final String TESTDATA_CASE_2_PICK_UP_PLUS_DAYS = "testdata.case2.pick-up.plus-days";
    private static final String TESTDATA_CASE_2_RETURN_PLUS_DAYS = "testdata.case2.return.plus-days";

    private static final String TESTDATA_CASE_3_PLACE_FROM = "testdata.case3.place-from";

    private static final String TESTDATA_CASE_4_PLACE_FROM = "testdata.case4.place-from";
    private static final String TESTDATA_CASE_4_PLACE_TO = "testdata.case4.place-to";
    private static final String TESTDATA_CASE_4_PICK_UP_PLUS_DAYS = "testdata.case4.pick-up.plus-days";
    private static final String TESTDATA_CASE_4_RETURN_PLUS_DAYS = "testdata.case4.return.plus-days";

    private static final String TESTDATA_CASE_5_PLACE_FROM = "testdata.case5.place-from";
    private static final String TESTDATA_CASE_5_PLACE_TO = "testdata.case5.place-to";
    private static final String TESTDATA_CASE_5_PICK_UP_PLUS_DAYS = "testdata.case5.pick-up.plus-days";
    private static final String TESTDATA_CASE_5_RETURN_PLUS_DAYS = "testdata.case5.return.plus-days";

    private static final String TESTDATA_CASE_6_PLACE_FROM = "testdata.case6.place-from";
    private static final String TESTDATA_CASE_6_PLACE_TO = "testdata.case6.place-to";


    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final LocalDate nowDate = LocalDate.now();


    public static CarReservation withNegativeRentalPeriodFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_1_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(TESTDATA_CASE_1_PLACE_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(TESTDATA_CASE_1_PICK_UP_PLUS_DAYS),
                        getDateStringWithPlusDays(TESTDATA_CASE_1_RETURN_PLUS_DAYS)));
    }

    public static CarReservation withRentalPeriodMoreThanYearFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_2_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(TESTDATA_CASE_2_PLACE_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(TESTDATA_CASE_2_PICK_UP_PLUS_DAYS),
                        getDateStringWithPlusDays(TESTDATA_CASE_2_RETURN_PLUS_DAYS)));
    }

    public static CarReservation withNotAvailablePlaceFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_3_PLACE_FROM));
    }

    public static CarReservation withCurrentPickUpDateFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_4_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(TESTDATA_CASE_4_PLACE_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(TESTDATA_CASE_4_PICK_UP_PLUS_DAYS),
                        getDateStringWithPlusDays(TESTDATA_CASE_4_RETURN_PLUS_DAYS)));
    }

    public static CarReservation withPastPickUpDateFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_5_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(TESTDATA_CASE_5_PLACE_TO))
                .setReservationDates(new ReservationDates(
                        getDateStringWithPlusDays(TESTDATA_CASE_5_PICK_UP_PLUS_DAYS),
                        getDateStringWithPlusDays(TESTDATA_CASE_5_RETURN_PLUS_DAYS)));
    }

    public static CarReservation withPickUpAndReturnPlacesAcrossContinentsFromProperty() {
        return (new CarReservation())
                .setPlaceFrom(TestDataReader.getTestData(TESTDATA_CASE_6_PLACE_FROM))
                .setPlaceTo(TestDataReader.getTestData(TESTDATA_CASE_6_PLACE_TO));
    }

    public static CarReservation withEmptyFields() {
        return (new CarReservation());
    }

    private static LocalDate getDateWithPlusDays(String plusDaysParamName) {
        return CarReservationCreator.nowDate.plusDays(Integer.parseInt(TestDataReader
                .getTestData(plusDaysParamName)));
    }

    private static String getDateString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    private static String getDateStringWithPlusDays(String plusDaysParamName) {
        return getDateString(getDateWithPlusDays(plusDaysParamName));
    }
}
