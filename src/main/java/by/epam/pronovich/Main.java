package by.epam.pronovich;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.dao.impl.BookingDAOImpl;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.model.Product;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ServiceProvider;
import by.epam.pronovich.util.Validator;
import org.apache.log4j.Logger;


import java.util.List;
import java.util.Objects;


public class Main {


    public static void main(String[] args) {
        List<Booking> all = ServiceProvider.getINSTANCE().getBookingService().getAll();
        all.forEach(System.out::println);


    }

}


