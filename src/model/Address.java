package model;

public class Address {   //Adres sınıfını oluşturduk özelliklerini belirtiyoruz
	private String street; // neden private?
	private String city;   
	private int postalcode; //postakodu neden string
	
	public Address(String street, String city, int postalcode) { //girdi olarak alınan değerleri kendi belirlediğimiz değişkenlere atıyoruz
		this.street= street;
		this.city= city;
		this.postalcode= postalcode;
	}
	public 	String getStreet() { //?
		return street;
		
	}
	public String getCity() {  //?
		return city;
	}
	public int getpostalcode() {  //?
		return postalcode;
	}
	public String toString() {  
		return "SOKAK:" + street  +" ŞEHİR:"+  city   +" POSTAKODU:"+  postalcode;
	}
}