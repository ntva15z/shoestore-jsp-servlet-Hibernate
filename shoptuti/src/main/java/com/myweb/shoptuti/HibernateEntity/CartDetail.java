package com.myweb.shoptuti.HibernateEntity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CartDetails")
public class CartDetail implements Serializable {
	private static final long serialVersionUID = -5625546042729347947L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartdetailId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CartId")
	private Cart cart;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductId")
	private Product product;
	
	@Column(name = "Quantity")
	private Integer Quantity;
	
	@Column(name = "Price")
	private Double Price;
	
	
	@Column(name = "Note")
	private String Note;
	
	
	
	public Integer getCartdetailId() {
		return CartdetailId;
	}
	public void setCartdetailId(Integer cartdetailId) {
		CartdetailId = cartdetailId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return Quantity;
	}
	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	}
