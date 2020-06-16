package by.epam.pronovich.service.sorting;

public enum SortingName {


    PRICEASC("Дешевые"),
    PRICEDESC("Дорогие"),
    NAMEASC("Имя A-Я"),
    NAMEDESC("Имя Я-А");

    private final String description;

    SortingName(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
