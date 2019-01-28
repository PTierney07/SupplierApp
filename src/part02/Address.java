package part02;

public class Address {

	private int bldNum;
	private String bldStreet;
	private String bldTown;
	private String bldPCode;
	private String bldCountry;

	/**
	 * I created this class using the old specification
	 * 
	 * This constructor creates the address object
	 * @param bldNum - the number of the suppliers building
	 * @param bldStreet - the street the supplier is on
	 * @param bldTown - the town the supplier is in
	 * @param bldPCode - the postcode for the supplier
	 * @param bldCountry - the country the supplier is in
	 */
	public Address(int bldNum, String bldStreet, String bldTown, String bldPCode, String bldCountry) {
		super();
		this.bldNum = bldNum;
		this.bldStreet = bldStreet;
		this.bldTown = bldTown;
		this.bldPCode = bldPCode;
		this.bldCountry = bldCountry;
	}

	public String getFullAddress() {
		
		String address = "-----Address Details-----" + "\n" + this.bldNum + " " + this.bldStreet;
		address += "\n" + this.bldTown + "\n" + this.bldPCode + "\n" + this.bldCountry;
		
		return address;
	}

	/**
	 * @return the bldNum - This returns the bldNum variable
	 */
	public int getBldNum() {
		return bldNum;
	}

	/**
	 * @return the bldStreet - This returns the bldStreet variable
	 */
	public String getBldStreet() {
		return bldStreet;
	}

	/**
	 * @return the bldTown - This returns the bldTown variable
	 */
	public String getBldTown() {
		return bldTown;
	}

	/**
	 * @return the bldPCode - This returns the bldPCode variable
	 */
	public String getBldPCode() {
		return bldPCode;
	}

	/**
	 * @return the bldCountry - This returns the bldCountry variable
	 */
	public String getBldCountry() {
		return bldCountry;
	}

	/**
	 * @param bldNum - this sets the bldNum variable
	 */
	public void setBldNum(int bldNum) {
		this.bldNum = bldNum;
	}

	/**
	 * @param bldStreet - this sets the bldStreet variable
	 */
	public void setBldStreet(String bldStreet) {
		this.bldStreet = bldStreet;
	}

	/**
	 * @param bldTown - this sets the bldTown variable
	 */
	public void setBldTown(String bldTown) {
		this.bldTown = bldTown;
	}

	/**
	 * @param bldPCode - this sets the bldPCode variable
	 */
	public void setBldPCode(String bldPCode) {
		this.bldPCode = bldPCode;
	}

	/**
	 * @param bldCountry - this sets the bldCountry variable
	 */
	public void setBldCountry(String bldCountry) {
		this.bldCountry = bldCountry;
	}	
	
}
