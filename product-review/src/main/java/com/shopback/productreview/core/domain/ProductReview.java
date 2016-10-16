package com.shopback.productreview.core.domain;

import java.util.Date;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReview {

	private long id;
	private String skuId;
	private float rating;// out of 5
	private String reviewedBy;
	private Date reviewedOn;
	private String reviewComment;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the skuId
	 */
	public String getSkuId() {
		return skuId;
	}

	/**
	 * @param skuId
	 *            the skuId to set
	 */
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	/**
	 * @return the rating
	 */
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the reviewedBy
	 */
	public String getReviewedBy() {
		return reviewedBy;
	}

	/**
	 * @param reviewedBy
	 *            the reviewedBy to set
	 */
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	/**
	 * @return the reviewedOn
	 */
	public Date getReviewedOn() {
		return reviewedOn;
	}

	/**
	 * @param reviewedOn
	 *            the reviewedOn to set
	 */
	public void setReviewedOn(Date reviewedOn) {
		this.reviewedOn = reviewedOn;
	}

	/**
	 * @return the reviewComment
	 */
	public String getReviewComment() {
		return reviewComment;
	}

	/**
	 * @param reviewComment
	 *            the reviewComment to set
	 */
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

}
