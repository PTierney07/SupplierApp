package part01;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;

public class Part01Tester {

	static Scanner input = new Scanner(System.in);

	static ArrayList<Supplier> supArray = new ArrayList<Supplier>() ;		//This array holds all the suppliers that are added to the system


	public static void main(String[] args) {

		part01.Address address1 = new part01.Address(12, "Test01", "TstTwn1", "Test123", "Test12");
		part01.Address address2 = new part01.Address(45, "test2", "testtwn", "erwar", "tsert");
		ArrayList<part01.Product> prodList1 = new ArrayList<part01.Product>();
		ArrayList<part01.Product> prodList2 = new ArrayList<part01.Product>();
		part01.Product prod1 = new part01.Product(34, "Test01", "Testmake01", 123.4, false);
		part01.Product prod2 = new part01.Product(78, "Make02", "Model02", 456.2, false);
		prodList2.add(prod2);
		prodList1.add(prod1);

		part01.Supplier sup1 = new part01.Supplier(34, "Tset01", address1, part01.SupRegion.OUTSIDE_EU, prodList1);
		part01.Supplier sup2 = new part01.Supplier(78, "Test02", address2, part01.SupRegion.OUTSIDE_EU, prodList2);
		supArray.add(sup1);
		supArray.add(sup2);
		
		
		boolean programRun = true;

		while(programRun) {
			int userChoice = MainMenu();			//This calls the MainMenu method and stores the value as an int

			switch (userChoice) {
			case 1 : PrintAllItems(); break;		//This switch statement calls different methods depending on what option the user chooses
			case 2 : AddNewSupplier(); break;
			case 3 : AddNewProduct(); break;
			case 4: System.exit(0); break;

			}


		}
	}

	public static int MainMenu() {



		System.out.println("Main Menu");				//This prints the options available to the user and asks the user to select an option
		System.out.println("1.Print All products");
		System.out.println("2.Add New Supplier");
		System.out.println("3.Add New Product");
		System.out.println("4.Exit Application");

		int numOfChoices = 4;
		int choice = listValidation(numOfChoices);

		return choice;
	}

	public static void PrintAllItems() {
		int index = 1;												// This prints all of the suppliers currently added to the supplier array
		for(Supplier sup: supArray) {
			System.out.println(index + " : " + sup.getSupName());
			index ++;
		}
		System.out.println("Please select your desired supplier");
		int userChoice = input.nextInt();

		Supplier selectedSup = supArray.get(userChoice -1);			//This prints out all the items currently added to the selected supplier
		for(Product item: selectedSup.getSupProducts()  ) {
			System.out.println(item.getProductDetails());
		}
		System.out.println();
	}

	//This method prompts the user to add details of their desired suppler, then adds the supplier to the supplier array list

	public static void AddNewSupplier() {
		System.out.println("Please enter the following supplier details:" + "\n");

		System.out.println("Supplier Name:");

		String  supName = input.next();

		System.out.println("---Supplier Address details---" + "\n");


		Address supAddress = AddAddress();

		int numOfEnums = EnumSet.allOf(SupRegion.class).size();

		printEnumList(numOfEnums);

		System.out.println("\nPlease choose the region of your supplier:");

		int regionChoice = input.nextInt();

		SupRegion supRegion = SupRegion.values()[regionChoice-1];


		ArrayList<Product> supProducts = AddProduct();

		Random supCodeRandom = new Random(100);
		int supCode = supCodeRandom.nextInt();

		Supplier tempSupplier = new Supplier(supCode, supName, supAddress, supRegion, supProducts);

		supArray.add(tempSupplier);


	}

	//This method prompts the user to add details of a new product, then adds the product to their desired supplier

	public static ArrayList<Product> AddNewProduct() {

		int index = 1;																//This prints all the suppliers currently added to the system
		for(Supplier sup: supArray) {
			System.out.println(index + " : " + sup.getSupName());
			index ++;
		}
		System.out.println("Please select the supplier you want to add a product to:");
		int userChoice = input.nextInt();

		Supplier selectedSup = supArray.get(userChoice -1);

		ArrayList<Product> newProductArray = AddProduct();
		
		Product newProduct = newProductArray.get(0);
		
		ArrayList<Product> prodList = selectedSup.getSupProducts();

		prodList.add(newProduct);																		//The product is then added to the array list for the specified supplier

		System.out.println();

		return newProductArray;

	}

	//This method prompts the user to add the address details for the supplier they are adding to the system

	public static Address AddAddress() {

		System.out.println("Please enter the building number of the supplier:");

		int bldNum = input.nextInt();

		System.out.println("Please enter the supplier's street name:");
		input.next();
		String bldStreet = input.next();
		

		System.out.println("Please enter the town the supplier is in:");
		input.next();
		String bldTown =  input.nextLine();		

		System.out.println("Please enter the postcode for the supplier:");
		input.next();
		String bldPCode =  input.nextLine();

		System.out.println("Please enter the country the supplier is in:");
		String bldCountry =  input.nextLine();

		Address newAddress = new Address(bldNum, bldStreet, bldTown, bldPCode, bldCountry);

		return newAddress;

	}

	//This prints all of the regions that the supplier can be from with regards to the values stored in the SupRegion enum

	public static void printEnumList(int numOfEnums) {
		for(int index = 1; index <= numOfEnums; index++) {											
			System.out.println(index + ": " + SupRegion.values()[index-1].getSupRegionAsString() );
		}
	}

	//This method prompts the user to add details of the first product to be added to the supplier they are adding into the system.

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
	
	public static int listValidation(int numOfChoices) {
		
		boolean userChoice = false;

		while(!userChoice) {

			if(input.hasNextInt()) {						
				int choice = input.nextInt();
				if (choice >=1 && choice <= numOfChoices) {
					userChoice = true;
					return choice;
				}else {
					System.out.println("Error - Please enter a number between 1 and " + numOfChoices);
				}
			}else {
				System.out.println("Error - please enter an integer");
				input.next();
			}

		}
		return 0;

	}

}


