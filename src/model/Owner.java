package model;

public class Owner {
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String email;
	private Address address;
	
	
	public Owner(String firstname, String lastname, String phonenumber, String email, Address address ) {
		
		this.firstname= firstname;
		this.lastname= lastname;
		this.phonenumber= phonenumber;
		this.email= email;
		this.address= address;
	}
		
	public String getFullName() {
		return firstname + " " +lastname;
	}	
	public String toString() {
		return getFullName() + " Telefon:" + phonenumber + " " + address ;
	}
	}
	
