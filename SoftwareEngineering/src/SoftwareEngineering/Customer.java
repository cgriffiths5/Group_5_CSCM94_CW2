package SoftwareEngineering;

public class Customer extends Person{
	/*public int customerID = getCustomerProfileData(): || enterCustomerProfileData():*/
	private String role = "customer";
	private String username = null;
	private String password = null;
	
	public Customer(String firstName, String lastName, String role, String username, String password) {
		super(firstName, lastName);
		this.role = role;
		this.username = username;
		this.password = password;
	}
	
	//SETTERS AND GETTERS
	public void setRole(String role) {
		this.role = role;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return this.role;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	
	
	public /*-showProfile()*/ void register(String username, String password) {
		/*
		 * Input strings into the method to then be saved
		 * on the database as a new customer/staff
		 */
	}
	
	public /*-showProfile(customerID)*/ void login(String username, String password) {
		/*
		 * input values as string. check string values against values 
		 * already stored on the database and if theres a match 
		 * connect through to the right webpage
		 */
	}
	
	//Do we need to enter a string as well to know whats the problem??
	public /*-showProfile(customerID)*/ void problemWithOrder(int orderID, String orderProblem) {
		/*
		 */
	}
	
	//does request a booking just need to be a boolean return? 
	//as it'll just be a "yes booking confirmed" or "no space
	// available"??
	public String[] requestBooking(int numOfGuests, int[] dateTime,
			int customerID ,int bookingLength) {
		/*
		 * All inputs are sent to the database to be checked with current bookings
		 * and number of people.
		 */
		return null;
	}
	
	//Can this also be a boolean?
	public String[]/*event info*/ requestEvent(String eventName, String[] menu, int[] dateTime, 
			int numOfTables, int maxGuests, String description) {
		/*
		 * compare input data with data on database to see if there has been a reservation
		 * already. This is sent off to be checked by the manager or can we do it automatically
		 */
		return null;
	}
	
	public String checkExistingBooking() {
		/*
		 * grab information about booking from database
		 * then show customer
		 */
		return "";
	}
	
	public /*cancel booking*/ void requestCancelBooking(/*[booking data]*/ int customerID) {
		/*
		 * gather unique customer id then grab booking from database.
		 * ask again if they are sure they want to cancel the booking then
		 * delete entry in the database but keep customer id
		 */
	}
	
	//do we need address or can it be customer Id as that'll already have address?
	//but for first time 
	public int[] orders(int table, boolean delivery, boolean takeaway,
			String address, String[] menu) {
		/*
		 * if delivery and takeaway are null then its a restaurant booking
		 * not sure how to return so many items
		 */
		return null;
	}
	
	//Do we want this a string?
	public int getCustomerID() {
		/*
		 * be able to go into the database and an gather the id
		 * and display it 
		 */
		return 0;
	}
}
