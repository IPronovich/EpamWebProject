package by.epam.pronovich.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    private Integer id;
    private Catalog catalog;
    private Brand brand;
    private String model;
    private String description;
    private Double price;
    private String img;
    private Integer quantity;


}
