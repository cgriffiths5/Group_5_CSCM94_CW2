package SoftwareEngineering;

/*
 * opening many windows at run time
 * 
 * thinking through how each screen would update itself
 * when another window had recieved an input
 */



public class Waiter extends Staff {
	private String role = "waiter";
	
	public Waiter(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
	
	public boolean approveBooking(/*booking data*/) {
		/*
		 * gather information about booking and then compare
		 * to database bookings
		 * if date is free then booking is allowed. update database
		 */
		return false;
	}
	
	public int assignTable(int guests, int tableNum) {
		/*
		 * check number of people and assign table.
		 * then update database with what table has been used
		 */
		return 0;
	}
	
	public int orders(int table, int[] menu) {
		/*
		 * take table number and nemu item and send to chef 
		 * update database with what they ordered
		 */
		return 0;
	}
	
	public boolean notifiesCustomerOrderReady(/*OrderID*/) {
		/*
		 * for takeway and delivery
		 * get values from database about orderId and 
		 * find contact details to update drivers and chef
		 * and customer
		 */
		return false;
	}
	
	public void customerRejectsOrder(/*OrderID*/) {
		/*
		 * customer informs member of stadd that order 
		 * is wrong
		 */
	}
}
