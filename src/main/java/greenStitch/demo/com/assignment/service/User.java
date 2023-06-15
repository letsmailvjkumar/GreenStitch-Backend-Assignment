package greenStitch.demo.com.assignment.service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String dob;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public String getDob() {
		return dob;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
  
}
