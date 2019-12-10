package by.bsu.rent.model;

import java.util.Objects;
import java.util.Optional;

public class ReservationDates {
    private String pickUpDate;
    private String returnDate;


    public ReservationDates(String checkInDate, String returnDate) {
        this.pickUpDate = checkInDate;
        this.returnDate = returnDate;
    }

    public ReservationDates() {
    }

    public Optional<String> getPickUpDate() {
        return Optional.ofNullable(pickUpDate);
    }

    public ReservationDates setPickUpDate(String checkInDate) {
        this.pickUpDate = checkInDate;
        return this;
    }

    public Optional<String> getReturnDate() {
        return Optional.ofNullable(returnDate);
    }

    public ReservationDates setReturnDate(String returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationDates that = (ReservationDates) o;
        return Objects.equals(pickUpDate, that.pickUpDate) &&
                Objects.equals(returnDate, that.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpDate, returnDate);
    }

    @Override
    public String toString() {
        return "ReservationDates{" +
                "pickUpDate='" + pickUpDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}