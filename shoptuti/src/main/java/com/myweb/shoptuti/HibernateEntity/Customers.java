package com.myweb.shoptuti.HibernateEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customers implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CustomerId")
	private String CustomerId;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Gender")
	private Boolean Gender;
	
	@Column(name = "DOB")
	private String DOB;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "Phone")
	private String Phone;
	
	@Column(name = "Password")
	private String Password;
	
	@Column(name = "RegistereroledDate")
	private Date RegistereroledDate;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
	private List<Cart> cartList;
	
	@ManyToOne
	@JoinColumn(name = "RoleId" )
	private Role role;
	
	

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}


	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Date getRegistereroledDate() {
		return RegistereroledDate;
	}

	public void setRegistereroledDate(Date registereroledDate) {
		RegistereroledDate = registereroledDate;
	}

	public List<Cart> getCartList() {
		return cartList;
	}

	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
}
