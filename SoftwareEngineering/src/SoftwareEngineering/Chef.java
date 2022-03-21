package SoftwareEngineering;

public class Chef extends Staff {
	private String role = "chef";
	
	public Chef(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
	
	private boolean markOrderComplete(/*int orderID*/) {
		/*
		 * get order number from the database and 
		 * display the food order to see if its done or not
		 */
		return false;
	}
	
	
	private String alertWaiter() {
		/*
		 * see if markOrderComplete is ready and then
		 * message waiter to collect the food
		 */
		return "orderReadyMessage";
	}
	
	private void outstandingOrders(int[] dateTime) {
		/*
		 * compare order time and the actual time to see
		 * if its taken to long. if the food has taken a while
		 * notify the waiter
		 */
		/*String message, [orders]*/
	}
	
	//I think needs to be public so we can put it on the menu
	public String dailySpecial(String menuItem) {
		/*
		 * Add a string value to then be put on the database
		 * link this the the GUI
		 */
		return "daily special";
	}
}
















