package model;
import İnterfaces.Manageable;
import model.Clinic;
// abstract class animal hayvanların ortak özelliklerini ( isim ,yaş , boy vb.) belirler.
// interface (manageable , comparable) : hayvanlara yetenek veya beceri kazandırır.
// Manageable ile yönetilebilir olma özelliği kazandırıldı.
// Comparable ile sıralanabilir olma özelliği kazandırıldı.

public abstract class Animal implements Manageable , Comparable < Animal > {
// Değişkenler(fields)//
// Değişkenleri 'protected' tanımlıyoruz böylece bu sınıftan miras alan alt sınıflar(dog,cat vb.) bu sınıflara doğrudan erişebilir, ancak dış 
//	dünyadan da korunmuş olurlar.
protected String name;             // Hayvanın adı.
protected String breed;            // Hayvanın ırkı (goldon vb.).
protected int age;                 // Hayvanın yaşı.
protected double weight;           // Hayvanın kilosu (kg).
protected double height;           // Hayvanın boyu (cm).
protected Owner owner;

// Constructor : Yeni bir hayvan nesnesi oluşturulurken temel bilgileri aldık.
public Animal(String name,  String breed,  int age, double weight, double height, Owner owner ) {
	super();
	this.name = name;
	this.breed = breed;
	this.age = age;
	this.weight = weight;
	this.height = height;
	this.owner=owner;
	Clinic.incrementCount();
}
// Hayvanların isimlerini alfabetik olarak sıralamak için kullanılır.
public int compareTo(Animal other) {
	return this.name.compareTo(other.getName());
	
}
public abstract String getType();
// getType() ile her sınıf kendi türünü yazdırır.

@Override
public String toString() {
	return "Adı:" + name +
			"\nTürü : " + getType() + 
			"\nIrkı:" + breed +
			"\nYaş:" + age +
			"\nKilo:" + weight + 
			"\nBoy:" + height ;
}			

// --GETTER ve SETTER --//
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBreed() {
	return breed;
}
public void setBreed(String breed) {
	this.breed = breed;
}

public int getAge() {
	return age;
}
public void setAge(int age) {
	if (age <= 0) {
		System.out.println("Hata, yaş 0 ve negatif değer olamaz !");
	}else {
		
	this.age = age;
	}
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	if (weight <0) {
		System.out.println("Hata, kilo negatif olamaz !");
	}else {
	this.weight = weight;
	}
}
public double getHeight() {
	return height;
}
public void setHeight(double height) {
	this.height = height;
}

//Manageable arayüzündeki kayıt etme metodu.
	public void register() {
		System.out.println("Başarıyla sisteme kaydedildi");
	}
	
// Hayvanın tüm bilgilerinin ekrana yazdırır.
public void displayInfo() {
System.out.println(this.toString() + "\n");
  }
	
}
