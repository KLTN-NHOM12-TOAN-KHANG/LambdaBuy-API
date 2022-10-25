package com.example.kltn.SpringAPILambdaBuy.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailKey implements Serializable {
	@Column
	private String productId;
	
	@Column
	private String orderId;

	public OrderDetailKey() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailKey(String productId, String orderId) {
		super();
		this.productId = productId;
		this.orderId = orderId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailKey other = (OrderDetailKey) obj;
		return Objects.equals(orderId, other.orderId) && Objects.equals(productId, other.productId);
	}

	@Override
	public String toString() {
		return "OrderDetailKey [productId=" + productId + ", orderId=" + orderId + "]";
	}
}
