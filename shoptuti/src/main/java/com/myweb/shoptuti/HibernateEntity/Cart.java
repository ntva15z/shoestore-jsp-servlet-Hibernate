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
@Table(name = "Carts")
public class Cart implements Serializable{


	private static final long serialVersionUID = 772545071818487748L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CartId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId")
	private Customers customer;
	
	@Column(name = "CreateDate")
	private Date CreateDate;
	
	@Column(name = "Total")
	private Double Total;
	
	@Column(name = "Status")
	private String Status;
	
	@OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
	private List<CartDetail> cartdetailList;

	public Integer getCartId() {
		return CartId;
	}

	public void setCartId(Integer cartId) {
		CartId = cartId;
	}

	public Customers getCustomer() {
		return customer;
	}

	public void setCustomer(Customers customer) {
		this.customer = customer;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public Double getTotal() {
		return Total;
	}

	public void setTotal(Double total) {
		Total = total;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public List<CartDetail> getCartdetailList() {
		return cartdetailList;
	}

	public void setCartdetailList(List<CartDetail> cartdetailList) {
		this.cartdetailList = cartdetailList;
	}
	
	
}
