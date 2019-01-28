package part02;

import java.util.EnumSet;
import java.util.Scanner;

public class EditMethods {
	static Scanner input = new Scanner(System.in);
	static int userChoice = 0;

	//This changes the bldNum variable for the selected supplier, to a new value entered by the user
	public static void editbldNum() {

		Supplier selectedSup = Part02Tester.getSupplier();

		System.out.println("\n" + "Please enter the new building number");
		int newBldNum = Validation.intValidation();

		selectedSup.getSupAddress().setBldNum(newBldNum);
	}

	//This changes the supName variable for the selected supplier, to a new value entered by the user
	public static void editName() {

		Supplier selectedSup = Part02Tester.getSupplier();

		System.out.println("\n" + "Please enter the new name for your supplier");
		String newSupName = Validation.stringNoIntsValidation();

		selectedSup.setSupName(newSupName);

	}

	//This changes the bldStreet variable for the selected supplier, to a new value entered by the user
	public static void editStreet() {

		Supplier selectedSup = Part02Tester.getSupplier();
		System.out.println("\n" + "Please enter the new street name");
		String newStreet = Validation.stringNoIntsValidation();

		selectedSup.getSupAddress().setBldStreet(newStreet);		

	}
	
	//This changes the bldTown variable for the selected supplier, to a new value entered by the user
	public static void editTown() {
		
		Supplier selectedSup = Part02Tester.getSupplier();
		
		System.out.println("\n" + "Please enter the new town name");
		
		String newTown = Validation.stringNoIntsValidation();
		selectedSup.getSupAddress().setBldTown(newTown);

	}
	
	//This changes the bldPCode variable for the selected supplier, to a new value entered by the user
	public static void editPCode() {
		
		Supplier selectSup = Part02Tester.getSupplier();
		System.out.println(selectSup.getSupAddress().getBldPCode());
		System.out.println("\n" + "Please enter the new post code");
		String newPCode = Validation.stringNoIntsValidation();
		
		selectSup.getSupAddress().setBldPCode(newPCode);
		System.out.println(selectSup.getSupAddress().getBldPCode());

	}
	
	//This changes the bldCountry variable for the selected supplier, to a new value entered by the user
	public static void editCountry() {
		
		Supplier selectedSup = Part02Tester.getSupplier();
		System.out.println(selectedSup.getSupAddress().getBldCountry());
		System.out.println("\n" + "Please enter the new country for the supplier");
		String newCountry = Validation.stringNoIntsValidation();
		
		selectedSup.getSupAddress().setBldCountry(newCountry);
		System.out.println(selectedSup.getSupAddress().getBldCountry());

	}
	
	//This changes the supRegion variable for the selected supplier, to a new value entered by the user
	public static void editSupRegion() {
		
		Supplier selectedSup = Part02Tester.getSupplier();
		
		int numOfEnums = EnumSet.allOf(SupRegion.class).size();
		PrintMethods.printEnumList(numOfEnums);
		
		System.out.println("\n" + "Please select the new region for the supplier");
		userChoice = Validation.listValidation(numOfEnums);
		SupRegion supRegion = SupRegion.values()[userChoice-1];
		
		selectedSup.setSupRegion(supRegion);

	}
	
	//This changes the proMake variable for the selected product, to a new value entered by the user
	public static void editMake() {
		
		Supplier selectedSup = Part02Tester.getSupplier();
		PrintMethods.printProducts(selectedSup);
		System.out.println("\n" + "Please selected the product you would like to edit");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());
		Product selectedProd = selectedSup.getSupProducts().get(userChoice-1);
		System.out.println("Please enter the new make");
		String editMake = Validation.stringNoIntsValidation();
		selectedProd.setProMake(editMake);
		
		
	}
	
	//This changes the proModel variable for the selected product, to a new value entered by the user
	public static void editModel() {
		
		Supplier selectedSup = Part02Tester.getSupplier();
		PrintMethods.printProducts(selectedSup);
		System.out.println("\n" + "Please selected the product you would like to edit");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());
		Product selectedProd = selectedSup.getSupProducts().get(userChoice-1);
		System.out.println("Please enter the new model");
		String editModel = Validation.stringNoIntsValidation();
		selectedProd.setProModel(editModel);
		
		
	}
	
	//This changes the proPrice variable for the selected product, to a new value entered by the user
	public static void editPrice() {

		Supplier selectedSup = Part02Tester.getSupplier();
		PrintMethods.printProducts(selectedSup);
		System.out.println("\n" + "Please selected the product you would like to edit");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());
		Product selectedProd = selectedSup.getSupProducts().get(userChoice-1);
		System.out.println("Please enter the new price");
		int editModel = Validation.intValidation();
		selectedProd.setProPrice(editModel);


	}
	
	//This changes the proQtyAvailable variable for the selected product, to a new value entered by the user
	public static void editProQtyAvailable() {

		Supplier selectedSup = Part02Tester.getSupplier();
		PrintMethods.printProducts(selectedSup);
		System.out.println("\n" + "Please selected the product you would like to edit");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());
		Product selectedProd = selectedSup.getSupProducts().get(userChoice-1);
		System.out.println("Please enter the new amount in stock");
		int editProQty = Validation.intValidation();
		selectedProd.setProQtyAvailable(editProQty);


	}
	
	//This changes the proDiscontinued variable for the selected product, to a new value entered by the user
	public static void editProDiscontinued() {
		
		
		Supplier selectedSup = Part02Tester.getSupplier();
		PrintMethods.printProducts(selectedSup);
		System.out.println("\n" + "Please selected the product you would like to edit");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());
		Product selectedProd = selectedSup.getSupProducts().get(userChoice-1);
		System.out.println("Is the product discontinued? y/n");
		String userInput = input.next();
		boolean editProDiscontinued = false;
		while (!((userInput.equals("y") || userInput.equals("Y")) || (userInput.equals("n") || userInput.equals("N")))){
			System.out.println("Please enter 'y' or 'n'");
			userInput = input.next();
		}
		if (userInput.equals("y") || userInput.equals("Y")) {
			editProDiscontinued = true;
		}else if (userInput.equals("n") || userInput.equals("N")) {
			editProDiscontinued = false;
		}
		selectedProd.setProDiscontinued(editProDiscontinued);


	}
	
}
