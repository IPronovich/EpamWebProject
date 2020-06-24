package by.epam.pronovich.service.sorting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SortingName {

    PRICEASC("Дешевые"),
    PRICEDESC("Дорогие"),
    NAMEASC("Имя A-Я"),
    NAMEDESC("Имя Я-А");

    private final String description;

}
