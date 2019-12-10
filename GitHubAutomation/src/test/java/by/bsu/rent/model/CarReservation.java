package by.bsu.rent.model;

import java.util.Objects;
import java.util.Optional;

public class CarReservation {
    private String placeFrom;
    private String placeTo;
    private ReservationDates reservationDates;

    public CarReservation(String placeFrom,
                          String placeTo,
                          ReservationDates reservationDates) {
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
        this.reservationDates = reservationDates;
    }

    public CarReservation() {
    }

    public Optional<String> getPlaceFrom() {
        return Optional.ofNullable(placeFrom);
    }

    public CarReservation setPlaceFrom(String placeFrom) {
        this.placeFrom = placeFrom;
        return this;
    }

    public Optional<String> getPlaceTo() {
        return Optional.ofNullable(placeTo);
    }

    public CarReservation setPlaceTo(String placeTo) {
        this.placeTo = placeTo;
        return this;
    }

    public Optional<ReservationDates> getReservationDates() {
        return Optional.ofNullable(reservationDates);
    }

    public CarReservation setReservationDates(ReservationDates reservationDates) {
        this.reservationDates = reservationDates;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarReservation that = (CarReservation) o;
        return Objects.equals(placeFrom, that.placeFrom) &&
                Objects.equals(placeTo, that.placeTo) &&
                Objects.equals(reservationDates, that.reservationDates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeFrom, placeTo, reservationDates);
    }

    @Override
    public String toString() {
        return "HotelReservation{" +
                "placeFrom='" + placeFrom + '\'' +
                "placeTo='" + placeTo + '\'' +
                ", reservationDates=" + reservationDates +
                '}';
    }
}
