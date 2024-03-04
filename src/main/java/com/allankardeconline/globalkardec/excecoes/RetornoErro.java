package com.allankardeconline.globalkardec.excecoes;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RetornoErro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2373276971056846821L;

	private Date timestamp;

	private String message;

	private Object details;

	public RetornoErro(Date timestamp, String message, Object details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public RetornoErro(String message, Object details) {
		super();
		this.timestamp = new Date();
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

	@Override
	public int hashCode() {
		return Objects.hash(details, message, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetornoErro other = (RetornoErro) obj;
		return Objects.equals(details, other.details) && Objects.equals(message, other.message)
				&& Objects.equals(timestamp, other.timestamp);
	}

}
