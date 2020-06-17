package by.epam.pronovich;


import by.epam.pronovich.controller.CommandProvider;
import by.epam.pronovich.controller.Controller;
import by.epam.pronovich.controller.command.Command;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.service.sorting.impl.NameAscSorting;
import by.epam.pronovich.service.sorting.impl.NameDescSorting;
import by.epam.pronovich.service.sorting.impl.PriceAscSorting;
import by.epam.pronovich.service.sorting.impl.PriceDescSorting;

import java.math.BigDecimal;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Product byId = ServiceProvider.getINSTANCE().getProductService().getById(1);
        System.out.println(byId.getPrice());

        BigDecimal bigDecimal = new BigDecimal(10.10);
        BigDecimal bigDecimal1 = bigDecimal.setScale(10, 2);


        System.out.println(bigDecimal);
    }

    }


