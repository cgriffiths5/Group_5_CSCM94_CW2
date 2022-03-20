package SoftwareEngineering;

public class Driver extends Staff {
	private String role = "driver";
	
	public Driver(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
	//does this need to be public as well and should it be void
	private boolean markOrderDelivered(int orderID) {
		/*
		 * when food is delivered mark food as delivered 
		 * by boolean then update the database
		 */
		return false;
	}
	
	private int[] checkOrderStatus(int orderID) {
		/*
		 * Gather orderID from database to see if order
		 * has been cooked
		 */
		return null;
	}
	
	private String getCustomerAddress(int orderID) {
		/*
		 * gather orderID value from the database and 
		 * retrieve the address from the orderID value and 
		 * database information for that ID
		 *
		 */
		return "";
	}
}
