package part02;

public class Product {

	private int proCode;
	private String proMake;
	private String proModel;
	private double proPrice;
	private int proQtyAvailable;
	private boolean proDiscontinued;
	//private boolean proInStock;

	/**
	 * I created this class using the old specification
	 * 
	 * This constructor creates the Product object
	 * @param proCode - The products code
	 * @param proMake - The products make
	 * @param proModel - The products model
	 * @param proPrice - The price of the product
	 * @param proInStock - Indicates if the item is in stock
	 */
	public Product(int proCode, String proMake, String proModel, double proPrice, boolean proInStock) {
		super();
		this.proCode = proCode;
		this.proMake = proMake;
		this.proModel = proModel;
		this.proPrice = proPrice;
		if(this.proQtyAvailable > 0 && this.proDiscontinued == false) {
			proInStock = true;
		}else {
			proInStock = false;
		}
	}
/**
 * 
 * @return productDetails - This method returns the product details as a String
 */
	public String getProductDetails() {
		String productDetails = "----Product Details----";
		productDetails += "\nProduct Code: " + this.proCode + "\nMake: " + this.proMake;
		productDetails += "\nModel: " + this.proModel + String.format("\nPrice: £%.2f",this.proPrice);
		if (this.isProDiscontinued() == true) {
			productDetails += "\nProduct is discontinued";
			productDetails += "\nAmount available to buy: " + this.getProQtyAvailable();
		}else {
			productDetails += "\nProduct is not discontinued";
			productDetails += "\nAmount available to buy: " + this.getProQtyAvailable();
		}
		return productDetails;
	}

	/**
	 * @return the proCode - This returns the proCode variable
	 */
	public int getProCode() {
		return proCode;
	}

	/**
	 * @return the proMake - This returns the proMake variable
	 */
	public String getProMake() {
		return proMake;
	}

	/**
	 * @return the proModel - This returns the proModel variable
	 */
	public String getProModel() {
		return proModel;
	}

	/**
	 * @return the proPrice - This returns the proPrice variable
	 */
	public double getProPrice() {
		return proPrice;
	}

	/**
	 * @return the proQtyAvailable - This returns the proQtyAvailable variable
	 */
	public int getProQtyAvailable() {
		return proQtyAvailable;
	}

	/**
	 * @return the proDiscontinued - This returns the proDiscontinued variable
	 */
	public boolean isProDiscontinued() {
		return proDiscontinued;
	}

	/**
	 * @param proCode - This sets the proCode variable
	 */
	public void setProCode(int proCode) {
		this.proCode = proCode;
	}

	/**
	 * @param proMake - This sets the proMake variable
	 */
	public void setProMake(String proMake) {
		this.proMake = proMake;
	}

	/**
	 * @param proModel - This sets the proModel variable
	 */
	public void setProModel(String proModel) {
		this.proModel = proModel;
	}

	/**
	 * @param proPrice - This sets the proPrice variable
	 */
	public void setProPrice(double proPrice) {
		this.proPrice = proPrice;
	}

	/**
	 * @param proQtyAvailable - This sets the proQtyAvailable variable
	 */
	public void setProQtyAvailable(int proQtyAvailable) {
		this.proQtyAvailable = proQtyAvailable;
	}

	/**
	 * @param proDiscontinued - This sets the proDiscontinued variable
	 */
	public void setProDiscontinued(boolean proDiscontinued) {
		this.proDiscontinued = proDiscontinued;
	}
	
}
