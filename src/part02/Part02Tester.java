package part02;

import java.util.ArrayList;
import java.util.Scanner;

public class Part02Tester {

	static Scanner input = new Scanner(System.in);
	static ArrayList<Supplier> supArray = new ArrayList<Supplier>();		//This array holds all the suppliers that are added to the system
	static int userChoice = 0;
	static boolean userDecision = false;
	static int numOfChoices = 0;

	public static void main(String[] args) {

		//This is temporary data, used to fill the system with suppliers initially
		Address address1 = new Address(12, "Test01", "TstTwn1", "Test123", "Test12");
		Address address2 = new Address(45, "test2", "testtwn", "erwar", "tsert");
		ArrayList<Product> prodList1 = new ArrayList<Product>();
		ArrayList<Product> prodList2 = new ArrayList<Product>();
		Product prod1 = new Product(34, "Test01", "Testmake01", 123.4, false);
		Product prod2 = new Product(78, "Make02", "Model02", 456.2, true);
		prod1.setProQtyAvailable(12);
		prod2.setProQtyAvailable(60);
		prodList2.add(prod2);
		prodList1.add(prod1);
		ArrayList<Feedback> feedbackList = new ArrayList<Feedback>();
		Supplier sup1 = new Supplier(35, "Tset01", address1, SupRegion.OUTSIDE_EU, prodList1,feedbackList);
		Supplier sup2 = new Supplier(678, "Test02", address2, SupRegion.OUTSIDE_EU, prodList2,feedbackList);
		Feedback feedback = new Feedback("Joe Bloggs", sup1, "Great Service");
		feedbackList.add(null);
		feedbackList.add(feedback);
		supArray.add(sup1);
		supArray.add(sup2);

		//System.out.println(sup1.getSupDetails());

		boolean programRun = true;

		while(programRun) {
			userChoice = mainMenu();			//This calls the MainMenu method and stores the value as an int

			switch (userChoice) {
			case 1 : PrintMethods.printAllItems(); break;		//This switch statement calls different methods depending on what option the user chooses
			case 2 : addSupProdMenu(); break;
			case 3 : removeSupProdMenu(); break;
			case 4 : editMenu(); break;
			case 5 : searchMenu(); break;
			case 6 : orderProduct(); break;
			case 7 : FeedbackOptions.giveFeedback(); break;
			case 8 : FeedbackOptions.printFeedback(); break;
			case 9 : System.out.println("Terminating application");System.exit(0); break;
			default : System.out.println("Please select an option"); break;
			}
		}
		input.close();
	}

	//This prints the options available to the user and asks the user to select an option
	public static int mainMenu() {
		System.out.println();
		System.out.println("Main Menu");				
		System.out.println("1.Print all products");
		System.out.println("2.Add new supplier or product");
		System.out.println("3.Remove a supplier or product");
		System.out.println("4.Edit a supplier or product");
		System.out.println("5.Search for a supplier or product");
		System.out.println("6.Order a product");
		System.out.println("7.Give feedback");
		System.out.println("8.Print feedback");
		System.out.println("9.Exit Application");

		numOfChoices = 9;

		int choice = Validation.listValidation(numOfChoices);

		return choice;
	}
	
	//This prints the options available to the user for adding a product or supplier and asks the user to select an option
	public static void addSupProdMenu() {

		numOfChoices = 3;

		System.out.println();
		System.out.println("Add a new supplier or product" + "\n");
		System.out.println("1.Add new supplier");
		System.out.println("2.Add new product");
		System.out.println("3.Return to main menu");

		int choice = Validation.listValidation(numOfChoices);

		switch (choice) {
		case 1 : AddMethods.addNewSupplier(); break;
		case 2 : AddMethods.addNewProduct(); break;
		case 3 : break;
		default : System.out.println("Please secet an option");
		}
	}
	
	//This prints the options available to the user for removing a product or supplier and asks the user to select an option
	public static void removeSupProdMenu() {
		numOfChoices = 3;

		System.out.println();
		System.out.println("----Removal Menu----" + "\n");
		System.out.println("1.Remove supplier");
		System.out.println("2.Remove product");
		System.out.println("3.Return to main menu");

		int choice = Validation.listValidation(numOfChoices);

		switch (choice) {
		case 1 : RemoveMethods.removeSupplier(); break;
		case 2 : RemoveMethods.removeProduct(); break;
		case 3 : break;
		default : System.out.println("Please select an option");
		}
	}
	
	//This prints the options available to the user for searching for a product or supplier and asks the user to select an option
	public static void searchMenu() {
		numOfChoices = 3;
		System.out.println("\n" + "----Search Menu----" + "\n");
		System.out.println("1.Search for a supplier" + "\n" + "2.Search for a product" + "\n" + "3.Return to main menu");
		userChoice = Validation.listValidation(numOfChoices);

		switch (userChoice) {
		case 1 : PrintMethods.printSupSearchMenu(); break;
		case 2 : PrintMethods.printProdSearchMenu(); break;
		case 3 : break;
		default : System.out.println("Please select an option"); break;
		}

	}
	
	//This prints the options available to the user for editing a product or supplier and asks the user to select an option
	public static void editMenu() {

		System.out.println();
		System.out.println("----Edit Menu----");
		System.out.println("1.Edit a supplier");
		System.out.println("2.Edit a product");
		System.out.println("3.Return to main menu");

		numOfChoices = 3;

		userChoice = Validation.listValidation(numOfChoices);

		switch (userChoice) {
		case 1 : PrintMethods.printSupEditOptions(); break;
		case 2 : PrintMethods.printProdEditOptions(); break;
		case 3 : break;
		default : System.out.println("Please select an option"); break;
		}		
	}
	
	//This method prints the suppliers in the system,then lets the user select a supplier
	public static Supplier getSupplier() {
		PrintMethods.printSuppliers();

		System.out.println("\n" + "Please select your supplier");
		userChoice = Validation.listValidation(Part02Tester.supArray.size());

		Supplier selectedSup = Part02Tester.supArray.get(userChoice -1);
		return selectedSup;
	}
	
	//This method lets the user select a supplier and order a product from them if there is any in stock, and re-confirms their decision
	//if they order over 50 instances of the item, then prints out a receipt
	public static void orderProduct() {
		Supplier selecedSup = getSupplier();
		int index = 1;
		for(Product eachProd : selecedSup.getSupProducts()) {
			System.out.println(index + ": " + eachProd.getProMake() + " " + eachProd.getProModel());
			index ++;
		}
		System.out.println("Please select the product you want to order");
		userChoice = Validation.listValidation(selecedSup.getSupProducts().size());
		Product selectedProd = selecedSup.getSupProducts().get(userChoice-1);
		int numOrdered = 0;
		if (selectedProd.getProQtyAvailable() == 0) {
			System.out.println("There is no stock available for this product");
			return;
		}else {
			System.out.println("Please enter the amount you want to order");
			numOrdered = Validation.intValidation();
			if(numOrdered >=50) {
				System.out.println("Are you sure you want to order " + numOrdered + " of this product? y/n");
				String userInput = Validation.stringNoIntsValidation();
				userDecision = false;
				while (!userDecision) {
					if (userInput.equals("y") || userInput.equals("Y")) {
						userDecision = true;
					}else if (userInput.equals("n") || userInput.equals("N")) {
						System.out.println("Please enter a new amount to order");
						numOrdered = Validation.intValidation();
						userDecision = true;
						
					}else {
						System.out.println("Error - please enter 'y' or 'n'");
						input.next();
					}
				}
			}
			System.out.println("\n" + "----Order Details----");
			System.out.println("Product selected: " + selectedProd.getProMake() + " " + selectedProd.getProModel());
			System.out.println("Amount ordered: " + numOrdered);
			double totalPrice = selectedProd.getProPrice() * numOrdered;
			System.out.printf("Total price: £%.2f",totalPrice);
			System.out.println();
		}
	}

}


