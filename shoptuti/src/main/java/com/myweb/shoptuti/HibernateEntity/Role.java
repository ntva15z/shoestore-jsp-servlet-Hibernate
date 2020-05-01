package com.myweb.shoptuti.HibernateEntity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role")
public class Role implements Serializable{
	
	private static final long serialVersionUID = -653555116193630768L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer RoleId;
	
	@Column(name = "Name")
	private String Name;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<Customers> customerList ;

	public Integer getRoleId() {
		return RoleId;
	}

	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Customers> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customers> customerList) {
		this.customerList = customerList;
	}

	
	
	
}
