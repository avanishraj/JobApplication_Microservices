package com.avanish.reviewMS.Review;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
    public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public boolean addReview(ReviewEntity review, Long companiesId) {
        if(companiesId != null) {
            review.setCompanyID(companiesId);
            reviewRepository.save(review);
        }
        return false;
    }


    @Override
    public List<ReviewEntity> getAllReviews(Long companiesId) {
        return reviewRepository.findByCompanyId(companiesId);
    }

    @Override
    public ReviewEntity getReview(Long companiesId, Long reviewId) {
        List<ReviewEntity> reviews = reviewRepository.findByCompanyId(companiesId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview( Long reviewId, ReviewEntity updatedReview) {
        ReviewEntity review = reviewRepository.findById(reviewId).orElse(null);
        if(review != null){
            review.setTitle(updatedReview.getTitle());
            review.setDescription(updatedReview.getDescription());
            review.setRating(updatedReview.getRating());
            review.setCompanyID(updatedReview.getCompanyID());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(company.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            ReviewEntity review = reviewRepository.findById(reviewId).orElse(null);
            assert review != null;
            CompanyEntity companyEntity = review.getCompany();
            companyEntity.getReview().remove(review);
            review.setCompany(null);
            company.updateCompanyById(companyId, companyEntity);
            reviewRepository.deleteById(reviewId);
            return  true;
        }
        return  false;
    }
}
