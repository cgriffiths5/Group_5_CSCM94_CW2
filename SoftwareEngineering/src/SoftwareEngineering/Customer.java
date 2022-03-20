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
		
	}
	
	public /*-showProfile(customerID)*/ void login(String username, String password) {
		
	}
	
	public /*-showProfile(customerID)*/ void problemWithOrder(int orderID) {
		
	}
	
	public String[] requestBooking(int numOfGuests, int[] dateTime,
			int customerID ,int bookingLength) {
		
		return null;
	}
	
	public String[]/*event info*/ requestEvent(String eventName, String[] menu, int[] dateTime, 
			int numOfTables, int maxGuests, String description) {
		
		return null;
	}
	
	public String checkExistingBooking() {
		return "";
	}
	
	public /*cancel booking*/ void requestCancelBooking(/*[booking data]*/ int customerID) {
		
	}
	
	public int[] orders(int table, boolean delivery, boolean takeaway,
			String address, String[] menu) {
		
		return null;
	}
	
	//Do we want this a string?
	public int getCustomerID() {
		return 0;
	}
}
