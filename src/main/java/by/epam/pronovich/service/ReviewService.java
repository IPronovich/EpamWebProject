package by.epam.pronovich.service;

import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getByProductId(Integer id) throws ServiceException;

    void add(Review review) throws ServiceException;
}
