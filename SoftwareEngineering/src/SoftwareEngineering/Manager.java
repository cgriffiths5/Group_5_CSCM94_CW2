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
	
	
	//Are we bale to just use the staffID number to add and remove?
	private String addStaff(String chef, String waiter) {
		/*
		 * take values of staff memebrs and be able to add or remove them
		 * 
		 */
		return "";	
	}
	
	//maybe we need just the staff Id
	private String removeStaff(String chef, String waiter) {
		/*
		 * when a staff member leaves or is fired we need to remove them
		 * from the database
		 * find staff id and then delete 
		 */
		return "";
	}
	
	private int[] staffNeeded() {
		/*
		 * check database with how many staff are needed from capacity
		 * check database with how mant staff are needed from capacity
		 * 
		 */
		/*[chefsNeeded , waitersNeeded]*/
		return null;
	}
	
	//we need to change the names of these inpupts. too long
	private /*storage query*/ void getReports(String mostPopularItem, int busiestPeriods, 
			int mostActiveCustomer, String highestHoursWorkedStaff) {
		/*
		 * get db reports and oraginse certain information so
		 * we can use it
		 */
	}
	
	public /*storage query*/ void makeEvent(String eventName, String[] menu, String dateTime, 
			int numOfTables, int maxGuests, String description) {
		/*
		 * put event information into db to check if there is availability 
		 * 
		 */
	}
	
	private String eventDescription(String description) {
		/*
		 * input the description of event and add it to the database
		 */
		return "";
	}
	
	//int[] dateTime
	public int[] checkUnconfirmedEvents() {
		/*
		 * retrieve infor from database about events that have
		 * been made but not checked.
		 * if it hasnt been checked then look over it and cross check with 
		 * database
		 * 
		 */
		return null;
	}
	
	public boolean reviewCustomerEvent(int[] dateTime) {
		/*
		 * check database with customer events 
		 */
		return false;
	}
}
