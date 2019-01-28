package part02;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

public class AddMethods {

	static int userChoice = 0;
	static boolean userDecision = false;
	static Scanner input = new Scanner(System.in);

	//This method prompts the user to add details of a new product, then adds the product to their desired supplier
	public static ArrayList<Product> addNewProduct() {

		Supplier selectedSup = Part02Tester.getSupplier();

		ArrayList<Product> newProductArray = addProduct();

		Product newProduct = newProductArray.get(0);

		ArrayList<Product> prodList = selectedSup.getSupProducts();

		prodList.add(newProduct);																		//The product is then added to the array list for the specified supplier
		return newProductArray;

	}

	//This method prompts the user to add details of their desired suppler, then adds the supplier to the supplier array list
	public static void addNewSupplier() {
		System.out.println("Please enter the following supplier details:");

		System.out.println("Supplier Name:");

		String  supName = Validation.stringNoIntsValidation();

		System.out.println("---Supplier Address details---");


		Address supAddress = addAddress();

		int numOfEnums = EnumSet.allOf(SupRegion.class).size();

		PrintMethods.printEnumList(numOfEnums);

		System.out.println("\nPlease choose the region of your supplier:");

		int regionChoice = Validation.listValidation(numOfEnums);

		SupRegion supRegion = SupRegion.values()[regionChoice-1];


		ArrayList<Product> supProducts = addProduct();
		
		Feedback tempFeedback = new Feedback(null, null, null);
		ArrayList<Feedback> supFeedback = new ArrayList<Feedback>();
		supFeedback.add(tempFeedback);

		Random supCodeRandom = new Random(100);
		int supCode = supCodeRandom.nextInt();

		Supplier tempSupplier = new Supplier(supCode, supName, supAddress, supRegion, supProducts, supFeedback);

		Part02Tester.supArray.add(tempSupplier);
	}

	//This method prompts the user to add the address details for the supplier they are adding to the system
	public static Address addAddress() {

		System.out.println("Please enter the building number of the supplier:");

		int bldNum = Validation.intValidation();



		System.out.println("Please enter the supplier's street name:");
		String bldStreet = Validation.stringNoIntsValidation();



		System.out.println("Please enter the town the supplier is in:");
		String bldTown =  Validation.stringNoIntsValidation();		

		System.out.println("Please enter the postcode for the supplier:");
		String bldPCode =  Validation.stringValidation();

		System.out.println("Please enter the country the supplier is in:");
		String bldCountry =  Validation.stringNoIntsValidation();

		Address newAddress = new Address(bldNum, bldStreet, bldTown, bldPCode, bldCountry);

		return newAddress;

	}

	//This method prompts the user to add details of the first product to be added to the supplier they are adding into the system.
	public static ArrayList<Product> addProduct() {

		boolean proDiscontinued = false;
		boolean proInStock = false;
		int proQtyAvailable = 0;

		ArrayList<Product> newProductArray = new ArrayList<Product>();

		System.out.println("---Product details---");

		Random proCodeRandom = new Random();							
		int proCode = proCodeRandom.nextInt(100);


		System.out.println("Please enter the make of the product:");		

		String proMake =  Validation.stringNoIntsValidation();


		System.out.println("Please enter the model of the product:");

		String proModel =  Validation.stringNoIntsValidation();


		System.out.println("Please enter the price of the product:");
		double proPrice = Validation.doubleValidation();

		System.out.println("Is the product discontinued? y/n ");

		String answer = Validation.stringNoIntsValidation();


		if(answer.equals("y") || answer.equals("Y")) {
			proDiscontinued = true;
			System.out.println("How  many products are available?");
			proQtyAvailable  =  Validation.intValidation();
			if(proQtyAvailable <= 0) {

				proInStock = false;
			}else {
				proInStock = true;
			}
		}else if(answer.equals("n") || answer.equals("N")) {
			proDiscontinued = false;
			System.out.println("How  many products are available?");
			proQtyAvailable  =  Validation.intValidation();
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
	//This asks the user if they want to add a supplier to the system, to be used when searching suppliers
	public static void addSupQuestion() {
		System.out.println("Do you want to add a supplier to the system? y/n");
		String userInput = Validation.stringNoIntsValidation();
		userDecision = false;
		while (!userDecision) {
			if (userInput.equals("y") || userInput.equals("Y")) {
				AddMethods.addNewSupplier();
				userDecision = true;
			}else if (userInput.equals("n") || userInput.equals("N")) {
				System.out.println("Returning to the main menu");
				System.out.println();
				userDecision = true;
				break;
			}else {
				System.out.println("Error - please enter 'y' or 'n'");
				input.next();
			}
		}
	}
}
