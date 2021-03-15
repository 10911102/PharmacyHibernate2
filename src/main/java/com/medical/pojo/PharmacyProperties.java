package com.medical.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "Pharmacy_properties")
public class PharmacyProperties {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name", length = 50)
	private String name;
	@Column(name = "lic_no", length = 50)
	private String licNo;
	@Column(name = "address", length = 50)
	private String address;
	@Column(name = "contact", length = 12)
	private String contact;
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLicNo() {
		return licNo;
	}
	public void setLicNo(String licNo) {
		this.licNo = licNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Pharmacy detials name=" + name + ", lic_no=" + licNo + "\n            address=" + address + ", mobile=" + contact
				+ "]";
	}
	
	
}
