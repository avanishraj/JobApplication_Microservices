package com.avanish.reviewMS.Review;

import java.util.List;

public interface ReviewService {
    boolean addReview(ReviewEntity review, Long companiesId);

    List<ReviewEntity> getAllReviews(Long companiesId);

    ReviewEntity getReview(Long companiesId, Long reviewId);

    boolean updateReview(Long reviewId, ReviewEntity updatedReview);

    boolean deleteReview(Long companyId, Long reviewId);
}
