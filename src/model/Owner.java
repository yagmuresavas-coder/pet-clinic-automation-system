package model;

public class Owner { //Evcil havyan sahibinin bilgileri sınıfı
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String email;
	private Address address;
	
	public Owner(String firstname, String lastname, String phonenumber, String email, Address address) { //girdi olarak alınan değerleri kendi belirlediğimiz değişkenlere atıyoruz
		this.firstname= firstname;
		this.lastname= lastname;
		this.phonenumber= phonenumber;
		this.email= email;
		this.address= address;
	}
		
	public String getFullName() { 
		return firstname + " " +lastname;
	}	
	
	public String toString() { //atadığımız değişkenleri kullanıcının görmesi için yazdırıyoruz
		return getFullName() + " Telefon:" + phonenumber + "\nAdres: " + address;
	}
}
