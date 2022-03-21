package SoftwareEngineering;

public class Profile {

	//maybe we need to add address as well?
	public String[] createStafProfile(String role, String firstName, String lastName, String address) {
		/*
		 * put information into the db and add the staff member
		 */
		return null;
	}
	
	//Maybe all we need is staff id as when they make a profile they get one
	public String deleteStafProfile(int staffID /*String role, String firstName, String lastName*/) {
		/*
		 * find staff id number and delte their record
		 */
		return "staff member deleted" + staffID;
	}
	
	public String[] allStaffProfiles(String role) {
		/*
		 * gather all information about staff from db and display it
		 */
		return null;
	}
	
	public String[] availableStaff(String role) {
		/*
		 * find staff members that are not working and by 
		 * all looking for members of staff with the exact role given
		 * as input
		 */
		return null;
	}
	
	private String[] createCustomerProfile(String role, String username, String password,
			String firstName, String lastName, String address) {
		/*
		 * add details onto database
		 * check all details have been inputted correctly
		 */
		return null;
	}
	
	private String[] /*profile[]*/ showCustomerProfile(int customerID) {
		/*
		 * find customer id and get info from db
		 */
		return null;
	}
}
