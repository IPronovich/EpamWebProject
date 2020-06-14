package by.epam.pronovich.dao;

import by.epam.pronovich.model.Review;

import java.util.List;

public interface ReviewDAO {

    List<Review> getAll();

    List<Review> getByProductId(Integer id);

    void add(Review review);
}
