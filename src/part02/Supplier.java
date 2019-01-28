package part02;

import java.util.ArrayList;

public class Supplier {

	
	private int supCode;
	private String supName;
	private Address supAddress;
	private SupRegion supRegion;
	private ArrayList<Product> supProducts;
	private ArrayList<Feedback> feedback;
	
	/**
	 * I created this class using the old specification
	 * 
	 * This constructor creates the Supplier object
	 * @param supCode - The suppliers code
	 * @param supName - The name of the supplier
	 * @param supAddress - The supplier's address
	 * @param supRegion - The region the supplier is in
	 * @param supProducts - The product's the supplier sells
	 * @param feedback - This is the feedback given about this supplier
	 */
	public Supplier(int supCode, String supName, Address supAddress, SupRegion supRegion,
			ArrayList<Product> supProducts, ArrayList<Feedback> feedback) {
		super();
		this.supCode = supCode;
		this.supName = supName;
		this.supAddress = supAddress;
		this.supRegion = supRegion;
		this.supProducts = supProducts;
		this.feedback = feedback;
	}

	public  void printProductList() {
		for (Product item : supProducts) {				//This method prints all instances of any products associated with a supplier
			System.out.println(item.getProductDetails());
		}
	}
	
	//This method prints the supplier's address as a string
	public String getSupAddressAsString() {
		
	return supAddress.getFullAddress();				
			
	}
	
	//This method prints the supplier's details as a string
	public String getSupDetails() {
		String supDetails = "-----Supplier Details------";
		supDetails += "\nSupplier Code: " + this.supCode + "\nSupplier Name: " + this.supName  + "\n" + this.getSupAddressAsString();
		supDetails += "\nSupplier Region: " + this.supRegion.getSupRegionAsString();
		return supDetails;
	}
	
	public ArrayList<Feedback> getFeedback() {
			return feedback;
		}
	/**
	 * @return the supCode - This returns the supCode variable
	 */
	public int getSupCode() {
		return supCode;
	}

	/**
	 * @return the supName - This returns the supName variable
	 */
	public String getSupName() {
		return supName;
	}

	/**
	 * @return the supAddress - This returns the supAddress variable
	 */
	public Address getSupAddress() {
		return supAddress;
	}

	/**
	 * @return the supRegion - This returns the supRegion variable
	 */
	public SupRegion getSupRegion() {
		return supRegion;
	}

	/**
	 * @return the supProducts - This returns the supProducts variable
	 */
	public ArrayList<Product> getSupProducts() {
		return supProducts;
	}

	/**
	 * @param supName - This sets the supName variable
	 */
	public void setSupName(String supName) {
		this.supName = supName;
	}

	/**
	 * @param supAddress - This sets the supAddress variable
	 */
	public void setSupAddress(Address supAddress) {
		this.supAddress = supAddress;
	}

	/**
	 * @param supRegion - This sets the supRegion variable
	 */
	public void setSupRegion(SupRegion supRegion) {
		this.supRegion = supRegion;
	}

	/**
	 * @param supProducts - This sets the supProducts variable
	 */
	public void setSupProducts(ArrayList<Product> supProducts) {
		this.supProducts = supProducts;
	}
	
}
