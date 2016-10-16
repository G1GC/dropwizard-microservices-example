package com.shopback.productreview.api;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductReviewRepresentation {

	private float rating;// out of 5
	private String reviewedBy;
	private Date reviewedOn;
	private String reviewComment;

	/**
	 * @return the rating
	 */
	@JsonProperty
	public float getRating() {
		return rating;
	}

	/**
	 * @param rating
	 *            the rating to set
	 */
	@JsonProperty
	public void setRating(float rating) {
		this.rating = rating;
	}

	/**
	 * @return the reviewedBy
	 */
	@JsonProperty
	public String getReviewedBy() {
		return reviewedBy;
	}

	/**
	 * @param reviewedBy
	 *            the reviewedBy to set
	 */
	@JsonProperty
	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	/**
	 * @return the reviewedOn
	 */
	@JsonProperty
	public Date getReviewedOn() {
		return reviewedOn;
	}

	/**
	 * @param reviewedOn
	 *            the reviewedOn to set
	 */
	@JsonProperty
	public void setReviewedOn(Date reviewedOn) {
		this.reviewedOn = reviewedOn;
	}

	/**
	 * @return the reviewComment
	 */
	@JsonProperty
	public String getReviewComment() {
		return reviewComment;
	}

	/**
	 * @param reviewComment
	 *            the reviewComment to set
	 */
	@JsonProperty
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

}
