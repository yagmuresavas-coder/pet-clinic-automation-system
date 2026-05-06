package staff;
import İnterfaces.Manageable;

public abstract class StaffMember implements Manageable {

	protected String name;
	protected String email;
	protected String phone;

	public StaffMember( String name , String email , String phone) {
		this.name= name;
		this.email= email;
		this.phone = phone;
	}
	   @Override
	public String toString() {
		return "\nAdı: " + name +
			   "\nE posta adresi: " + email +
			   "\nTelefon numarası: " + phone ;
	}
	   
	//---GETTER ve SETTER---//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public abstract void listAppointments();
	
	    @Override
	 public void register() {
		 System.out.println( " --- Kayıt işlemi başarıyla tamamlandı. --- ");
	 }
	    @Override
		 public void displayInfo() {
			 System.out.println(this.toString());
		 }
}
	


