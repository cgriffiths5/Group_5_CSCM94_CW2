package SoftwareEngineering;

public class Manager extends Waiter{
	private String role = "manager";
	
	public Manager(String firstName, String lastName, String role) {
		super(firstName, lastName, role);
		this.role = role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
	
	private String addStaff(String staffUsername) {
		/*
		 * take values of staff members and be able to add or remove them
		 */
		return "";	
	}
	
	
	private String removeStaff(String staffUsername) {
		/*
		 * when a staff member leaves or is fired we need to remove them
		 * from the database
		 * find staff id and then delete 
		 */
		return "";
	}
	
	//doesnt need to be implemented 
	private int[] staffNeeded() {
		/*
		 * check database with how many staff are needed from capacity
		 */
		/*[chefsNeeded , waitersNeeded]*/
		return null;
	}
	
	//got rid of staff hours most worked as we dont need to do staff cover
	private /*storage query*/ void getReports(String mostPopularItem, int busiestPeriods, 
			int mostActiveCustomer) {
		/*
		 * get db reports and oraginse certain information so
		 * we can use it
		 */
	}
	
	//dont have to do this for implementation
//	public /*storage query*/ void makeEvent(String eventName, String[] menu, String dateTime, 
//			int numOfTables, int maxGuests, String description) {
//		/*
//		 * put event information into db to check if there is availability 
//		 */
//	}
//	
//	
//	private String eventDescription(String description) {
//		/*
//		 * input the description of event and add it to the database
//		 */
//		return "";
//	}
//	
//	//int[] dateTime
//	public int[] checkUnconfirmedEvents() {
//		/*
//		 * retrieve infor from database about events that have
//		 * been made but not checked.
//		 * if it hasnt been checked then look over it and cross check with 
//		 * database
//		 * 
//		 */
//		return null;
//	}
//	
//	public boolean reviewCustomerEvent(int[] dateTime) {
//		/*
//		 * check database with customer events 
//		 */
//		return false;
//	}
}
