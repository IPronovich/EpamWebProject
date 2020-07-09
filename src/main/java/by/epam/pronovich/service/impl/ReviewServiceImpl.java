package by.epam.pronovich.service.impl;

import by.epam.pronovich.dao.DAOProvider;
import by.epam.pronovich.exception.DAOException;
import by.epam.pronovich.exception.ServiceException;
import by.epam.pronovich.model.Review;
import by.epam.pronovich.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final Logger logger = LoggerFactory.getLogger(ReviewServiceImpl.class);

    @Override
    public List<Review> getByProductId(Integer id) {
        List<Review> reviews = null;
        try {
            reviews = DAOProvider.getINSTANCE().getReviewDAO().getByProductId(id);
        } catch (DAOException e) {
            logger.warn("Failed get reviews by product id", e);
            throw new ServiceException(e);
        }
        return reviews;
    }

    @Override
    public void add(Review review) {
        try {
            DAOProvider.getINSTANCE().getReviewDAO().add(review);
        } catch (DAOException e) {
            logger.warn("Failed adding review",e);
            throw new ServiceException(e);
        }
    }
}
