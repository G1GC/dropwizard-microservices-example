package com.shopback.productcatalog.api;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Karthik Jayaraman
 *
 */
public class ProductDescription {

	private String language;
	private String desc;

	@JsonProperty
	public String getLanguage() {
		return language;
	}

	@JsonProperty
	public void setLanguage(String language) {
		this.language = language;
	}

	@JsonProperty
	public String getDesc() {
		return desc;
	}

	@JsonProperty
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDescription other = (ProductDescription) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductDescription [language=").append(language).append(", desc=").append(desc).append("]");
		return builder.toString();
	}

}
