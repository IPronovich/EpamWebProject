package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    @Override
    public List<Review> getByProductId(Integer id) {
        return DAOProvider.getINSTANCE().getReviewDAO().getByProductId(id);
    }

    @Override
    public void add(Review review) {
        DAOProvider.getINSTANCE().getReviewDAO().add(review);
    }
}
