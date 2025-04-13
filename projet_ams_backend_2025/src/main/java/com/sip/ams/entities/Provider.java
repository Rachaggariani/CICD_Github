package com.sip.ams.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
@Entity
public class Provider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank(message = "Name is mandatory")
    @Column(name = "name")
	private String name;
	
	
    @NotBlank(message = "Address is mandatory")
    @Column(name = "address")
    private String address;
    
    @NotBlank(message = "Email is mandatory")
    @Column(name = "email")
    private String email;
    
    @NotBlank(message = "Logo is mandatory")
    @Column(name = "logo")
    private String logo;


	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	@Override
	public String toString() {
		return "Provider [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", logo=" + logo
				+ "]";
	}

	public Provider(long id, @NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Address is mandatory") String address,
			@NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "Logo is mandatory") String logo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.logo = logo;
	}
	
	public Provider(@NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "Address is mandatory") String address,
			@NotBlank(message = "Email is mandatory") String email,
			@NotBlank(message = "Logo is mandatory") String logo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.logo = logo;
	}

	public Provider() {
	}

}
