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

import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<Product> all = ServiceProvider.getINSTANCE().getProductService().getByCategoryId(56);
        for (Product product : all) {
            System.out.println(product.getBrand().getName()+ " "+ product.getModel()+" "+product.getPrice());
        }
        System.out.println("________");
        NameAscSorting nameAscSorting= new NameAscSorting();
        all = nameAscSorting.sort(all);
        for (Product product : all) {
            System.out.println(product.getBrand().getName()+ " "+ product.getModel()+" "+product.getPrice());
        }
        System.out.println("________");
        NameDescSorting nameDescSorting = new NameDescSorting();
        all = nameDescSorting.sort(all);
        for (Product product : all) {
            System.out.println(product.getBrand().getName()+ " "+ product.getModel()+" "+product.getPrice());
        }

    }

}
