package by.epam.pronovich.model;

import lombok.Getter;

@Getter
public enum BookingStatus {

    INPROCESSING("Обрабатывается"),
    PROCESSED("Обработан"),
    DELIVERED("Доставлен");

    private final String description;

    BookingStatus(String description) {
        this.description = description;
    }
}
