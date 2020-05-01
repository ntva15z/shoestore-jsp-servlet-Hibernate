package com.myweb.shoptuti.HibernateEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ProductId;
	
	@Column(name = "Name",length = 255,nullable = true)
	private String Name;
	
	@Column(name = "Image",length = 255,nullable = true)
	private String Image;
	
	@Column(name = "Quantity",nullable = true)
	private Integer Quantity;
	
	@Column(name = "Price",nullable = true)
	private Double Price;
	
	@Column(name = "ManufacturedDate",nullable = true)
	private Date ManufacturedDate;
	
	@Column(name = "Status",length = 20,nullable = true)
	private String Status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoryId")
	private Category category;
	
	@Column(name = "Description")
	private String Description;

	@OneToMany(mappedBy = "product" , fetch = FetchType.LAZY)
	private List<CartDetail> cartdetailList;


	public Integer getProductId() {
		return ProductId;
	}

	public void setProductId(Integer productId) {
		ProductId = productId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
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

	public Date getManufacturedDate() {
		return ManufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		ManufacturedDate = manufacturedDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public List<CartDetail> getCartdetailList() {
		return cartdetailList;
	}

	public void setCartdetailList(List<CartDetail> cartdetailList) {
		this.cartdetailList = cartdetailList;
	}




	
	
}
