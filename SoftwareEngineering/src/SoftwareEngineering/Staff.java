package SoftwareEngineering;

public abstract class Staff extends Person {
	private String role = null;
	
	public Staff(String firstName, String lastName, String role) {
		super(firstName, lastName);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
	private void showStaffProfile(int staffID) {
		int a =0;
		/*
		 * But gathering the staff unique id we can us
		 * the database to retrieve the staff profile
		 * then we can display the profile and connect it to 
		 * GUI
		 */
	}
}
