package by.epam.pronovich;

import by.epam.pronovich.dao.impl.BookingDAOImpl;
import by.epam.pronovich.model.Booking;
import by.epam.pronovich.service.ServiceProvider;
import org.apache.log4j.Logger;


import java.util.List;


public class Main {
    static Logger logger = Logger.getLogger(Main.class);


    public static void main(String[] args) {
        ServiceProvider.getINSTANCE().getBrandService().getAll();

        System.out.println();


        logger.info("ddsds");
        logger.error("dsds");


    }
}


