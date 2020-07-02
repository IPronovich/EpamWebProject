package by.epam.pronovich.dao;

import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.model.Review;

import java.util.List;

public interface ReviewDAO {

    List<Review> getByProductId(Integer id) throws DAOException;

    void add(Review review) throws DAOException;
}
