package part02;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

public class SupplierTester {

	static Scanner input = new Scanner(System.in);

	static ArrayList<Supplier> supArray = new ArrayList<Supplier>();

	public static void main(String[] args) {
		Address address1 = new Address(12, "Test01", "TstTwn1", "Test123", "Test12");
		Address address2 = new Address(45, "test2", "testtwn", "erwar", "tsert");
		ArrayList<Product> prodList1 = new ArrayList<Product>();
		ArrayList<Product> prodList2 = new ArrayList<Product>();
		Product prod1 = new Product(34, "Test01", "Testmake01", 123.4, false);
		Product prod2 = new Product(78, "Make02", "Model02", 456.2, false);
		prodList2.add(prod2);
		prodList1.add(prod1);
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		Supplier sup1 = new Supplier(35, "Tset01", address1, SupRegion.OUTSIDE_EU, prodList1,feedbackList);
		Supplier sup2 = new Supplier(678, "Test02", address2, SupRegion.OUTSIDE_EU, prodList2,feedbackList);
		Feedback feedback = new Feedback("Joe Bloggs", sup1, "Great Service");
		feedbackList.add(feedback);
		supArray.add(sup1);
		supArray.add(sup2);
		
		System.out.println(sup1.getFeedback().get(0).getFeedbackDetails());
		
		System.out.println(sup1.getSupDetails());
		AddSupplier();
		
		System.out.println(supArray.get(2).getSupAddressAsString());

	}

	public static void AddSupplier() {
		System.out.println("Please enter the following supplier details:");

		System.out.println("Supplier Name:");

		String  supName = input.next();

		System.out.println("---Supplier Address details---");


		Address supAddress = AddAddress();

		int numOfEnums = EnumSet.allOf(SupRegion.class).size();

		printEnumList(numOfEnums);

		System.out.println("\nPlease choose the region of your supplier:");

		int regionChoice = input.nextInt();

		SupRegion supRegion = SupRegion.values()[regionChoice-1];


		ArrayList<Product> supProducts = AddProduct();
		
		Feedback tempFeedback = new Feedback(null, null, null);
		ArrayList<Feedback> supFeedback = new ArrayList<Feedback>();
		supFeedback.add(tempFeedback);

		Random supCodeRandom = new Random(100);
		int supCode = supCodeRandom.nextInt();

		Supplier tempSupplier = new Supplier(supCode, supName, supAddress, supRegion, supProducts,supFeedback);

		supArray.add(tempSupplier);

	}

	public static void printEnumList(int numOfEnums) {
		for(int index = 1; index <= numOfEnums; index++) {											
			System.out.println(index + ": " + SupRegion.values()[index-1].getSupRegionAsString() );
		}
	}

	public static Address AddAddress() {

		System.out.println("Please enter the building number of the supplier:");

		int bldNum = input.nextInt();



		System.out.println("Please enter the supplier's street name:");
		String bldStreet = input.next();



		System.out.println("Please enter the town the supplier is in:");
		String bldTown =  input.next();		

		System.out.println("Please enter the postcode for the supplier:");
		String bldPCode =  input.next();

		System.out.println("Please enter the country the supplier is in:");
		String bldCountry =  input.next();

		Address newAddress = new Address(bldNum, bldStreet, bldTown, bldPCode, bldCountry);

		return newAddress;

	}

	public static ArrayList<Product> AddProduct() {

		boolean proDiscontinued = false;
		boolean proInStock = false;
		int proQtyAvailable = 0;
		ArrayList<Product> newProductArray = new ArrayList<Product>();

		System.out.println("---Product details---");

		Random proCodeRandom = new Random();							
		int proCode = proCodeRandom.nextInt(100);


		System.out.println("Please enter the make of the product:");		

		String proMake =  input.next();


		System.out.println("Please enter the model of the product:");

		String proModel =  input.next();


		System.out.println("Please enter the price of the product:");
		double proPrice = input.nextDouble();

		System.out.println("Is the product discontinued? y/n ");

		String answer = input.next();


		if(answer.equals("y") || answer.equals("Y")) {
			proDiscontinued = true;
			System.out.println("How  many products are available?");
			proQtyAvailable  =  input.nextInt();
			if(proQtyAvailable <= 0) {

				proInStock = false;
			}else {
				proInStock = true;
			}
		}else if(answer.equals("n") || answer.equals("N")) {
			proDiscontinued = false;
			System.out.println("How  many products are available?");
			proQtyAvailable  =  input.nextInt();
			if(proQtyAvailable <= 0) {
				proInStock = false;
			}else {
				proInStock = true;
			}
		}	

		Product newProduct = new Product(proCode, proMake, proModel, proPrice, proInStock);
		newProduct.setProQtyAvailable(proQtyAvailable);
		newProduct.setProDiscontinued(proDiscontinued);

		newProductArray.add(newProduct);															//The product is then added to the array list for the specified supplier

		System.out.println();

		return newProductArray;
	}
}