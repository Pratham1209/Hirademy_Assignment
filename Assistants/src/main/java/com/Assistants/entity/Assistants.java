package com.Assistants.entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Email;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Assistant")
public class Assistants{
	
	@Id
    private String Id;
    private String name;
    private String mobile;
    
    @Email(regexp = "(?i)[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String email;
    
    //Using BigDecimal avoids issues related to floating-point precision inherent in float or double data types
    private BigDecimal salary;
    
    private String country;
    private String city;
    private String department;
    private String role;

    @DateTimeFormat
    Date JoiningDate;

    @DateTimeFormat
    Date lastActivity;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getJoiningDate() {
		return JoiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		JoiningDate = joiningDate;
	}

	public Date getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}
    
    
	
}