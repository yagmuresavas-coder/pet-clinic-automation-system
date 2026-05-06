package model;

public class Address {   //Adres sınıfını oluşturduk özelliklerini belirtiyoruz
	private String street; 
	private String city;   
	private String postalcode; 
	
	public Address(String street, String city, String postalcode) { //girdi olarak alınan değerleri kendi belirlediğimiz değişkenlere atıyoruz
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
	public String getPostalcode() {  
		return postalcode;
	}
	public String toString() {  
		return "SOKAK:" + street  +" ŞEHİR:"+  city   +" POSTAKODU:"+  postalcode;
	}
}