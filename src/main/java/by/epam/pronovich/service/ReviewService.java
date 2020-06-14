package by.epam.pronovich.service;

import by.epam.pronovich.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getByProductId(Integer id);

    void add(Review review);
}
