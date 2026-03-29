package model;

public class Address {
	private String street;
	private String city;
	private String postalcode;
	
	public Address(String street, String city, String postalcode) {
		this.street= street;
		this.city= city;
		this.postalcode= postalcode;
	}
	public 	String getStreet() {
		return street;
		
	}
	public String getCity() {
		return city;
	}
	public String getpostalcode() {
		return postalcode;
	}
	public String toString() {
		return street  +  city   +   postalcode;
	}
}
