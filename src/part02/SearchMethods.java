package part02;

import java.util.EnumSet;

public class SearchMethods {
	static int count = 0;
	static boolean userDecision = false; 
	static int userChoice = 0;
	static boolean found = false;
	//This searches the supplier list for a name given by the user, then returns the amount of matching suppliers
	//then asks if the user wants to print out the supplier's details individually
	public static void supplierNameSearch() {

		userDecision = false;
		boolean found = false;

		System.out.println("Please enter the name of the supplier you want to search for");
		String supName = Validation.stringNoIntsValidation();
		for (Supplier eachSup : Part02Tester.supArray) {
			if (supName.equals(eachSup.getSupName())) {
				System.out.println("The selected supplier was found");
				found = true;
				System.out.println("Do you want to print out the supplier's details? y/n");
				String userInput = Validation.stringNoIntsValidation();
				while (!userDecision) {	
					if (userInput.equals("y") || userInput.equals("Y")) {
						System.out.println(eachSup.getSupDetails());
						eachSup.printProductList();
						System.out.println();
						userDecision = true;
						break;
					}else if (userInput.equals("n") || userInput.equals("N")) {
						System.out.println("Returning to the main menu");
						System.out.println();
						userDecision = true;
						break;
					}else {
						System.out.println("Error - please enter 'y' or 'n'");
						userInput = Validation.stringNoIntsValidation();
					}
				}
			}else {
				if (found == true) {
					break;
				}
				System.out.println("The selected supplier wasn't found");
				found = false;
				break;
			}	
		}
		if (found == false) {
			AddMethods.addSupQuestion();
		}		
	}
	//This searches for suppliers from a region selected by the user, then prints the amount of matches
	//then asks if the user wants to print out each of the suppliers' details individually
	public static void supRegionSearch() {

		int numOfEnums = EnumSet.allOf(SupRegion.class).size();

		PrintMethods.printEnumList(numOfEnums);

		System.out.println("\nPlease choose the region to search:");

		int regionChoice = Validation.listValidation(numOfEnums);

		SupRegion supRegion = SupRegion.values()[regionChoice-1];

		boolean found = false;
		for (Supplier eachSup : Part02Tester.supArray) {
			if (supRegion.equals(eachSup.getSupRegion())) {
				count ++;
			}	
		}
		System.out.println(count + " supplier(s) found");

		for (Supplier eachSup : Part02Tester.supArray) {
			if (supRegion.equals(eachSup.getSupRegion())) {
				userDecision = false;
				found = true;
				System.out.println("Do you want to print out the supplier's details? y/n");
				String userInput = Validation.stringNoIntsValidation();
				while (!userDecision) {	
					if (userInput.equals("y") || userInput.equals("Y")) {
						System.out.println(eachSup.getSupDetails());
						eachSup.printProductList();
						System.out.println();
						userDecision = true;
						break;
					}else if (userInput.equals("n") || userInput.equals("N")) {
						System.out.println("Returning to the main menu");
						System.out.println();
						userDecision = true;
						break;
					}else {
						System.out.println("Error - please enter 'y' or 'n'");
						userInput = Validation.stringNoIntsValidation();
					}
				}
			}else {
				if (found == true) {
					break;
				}
				System.out.println("No suppliers were found");
				found = false;
				break;
			}	
		}
		if (found == false) {
			AddMethods.addSupQuestion();
		}		
	}
	//This searches for products from a selected supplier within a selected price range, then prints the amount of matches
	//then asks if the user wants to print the details of each product individually
	public static void priceSearch() {
		count = 0;
		Supplier selectedSup = Part02Tester.getSupplier();
		System.out.println("Please enter the lower price range to search");
		int lowerPrice = Validation.intValidation();
		System.out.println("Please enter the upper price range to search");
		int upperPrice = Validation.intValidation();
		for (Product searchProd : selectedSup.getSupProducts()) {
			if (searchProd.getProPrice() >= lowerPrice && searchProd.getProPrice() <= upperPrice) {
				count++;
			}
		}
		System.out.println(count + " product(s) found");

		for (Product searchProd : selectedSup.getSupProducts()) {
			if (searchProd.getProPrice() >= lowerPrice && searchProd.getProPrice() <= upperPrice) {
				userDecision = false;
				found = true;
				System.out.println("Do you want to print out the product's details? y/n");
				String userInput = Validation.stringNoIntsValidation();
				while (!userDecision) {	
					if (userInput.equals("y") || userInput.equals("Y")) {
						System.out.println(searchProd.getProductDetails());
						System.out.println();
						userDecision = true;
						break;
					}else if (userInput.equals("n") || userInput.equals("N")) {
						System.out.println("Returning to the main menu");
						System.out.println();
						userDecision = true;
						break;
					}else {
						System.out.println("Error - please enter 'y' or 'n'");
						userInput = Validation.stringNoIntsValidation();
					}
				}
			}else {
				if (found == true) {
					break;
				}
				System.out.println("No products were found");
				found = false;
				break;
			}	
		}
	}
	//This searches for products from a selected supplier that are discontinued, then prints the amount of discontinued products
	//then asks if the user wants to print the details of each product individually
	public static void disconSearch() {
		count = 0;
		Supplier selectedSup = Part02Tester.getSupplier();
		for (Product searchProd : selectedSup.getSupProducts()) {
			if (searchProd.isProDiscontinued() == true) {
				count++;
			}
		}
		System.out.println(count + " product(s) found");

		for (Product searchProd : selectedSup.getSupProducts()) {
			if (searchProd.isProDiscontinued() == true) {
				userDecision = false;
				found = true;
				System.out.println("Do you want to print out the product's details? y/n");
				String userInput = Validation.stringNoIntsValidation();
				while (!userDecision) {	
					if (userInput.equals("y") || userInput.equals("Y")) {
						System.out.println(searchProd.getProductDetails());
						System.out.println();
						userDecision = true;
						break;
					}else if (userInput.equals("n") || userInput.equals("N")) {
						System.out.println("Returning to the main menu");
						System.out.println();
						userDecision = true;
						break;
					}else {
						System.out.println("Error - please enter 'y' or 'n'");
						userInput = Validation.stringNoIntsValidation();
					}
				}
			}else {
				if (found == true) {
					break;
				}
				System.out.println("No products were found");
				found = false;
				break;
			}	
		}
	}
}
