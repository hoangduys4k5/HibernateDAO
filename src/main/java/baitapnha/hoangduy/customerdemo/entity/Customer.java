package baitapnha.hoangduy.customerdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;
	@NotNull(message = "is required")
	@Size(min = 3, message = "must be greater than or equal to 3 characters")
	private String passWord;
	
	private String fullName;
	
	private int age;
	
	private String address;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Customer(int id, String userName, String passWord, String fullName, int age, String address) {
	
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}
	public Customer(String userName, String passWord, String fullName, int age, String address) {
		
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.age = age;
		this.address = address;
	}
	public Customer() {
		
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", fullName=" + fullName
				+ ", age=" + age + ", address=" + address + "]";
	}
	
	
}
