package by.epam.pronovich;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.dao.impl.BookingDAOImpl;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;
import org.apache.log4j.Logger;


import java.util.List;


public class Main {


    public static void main(String[] args) {

        List<Product> horizont = DAOProvider.getINSTANCE().getProductDAO().seach("horizont");
        for (Product product : horizont) {
            System.out.println(product);
        }
    }
}


