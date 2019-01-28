package part01;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;
import java.util.Scanner;


public class SupplierTester {

	static Scanner input = new Scanner(System.in);

	static ArrayList<part01.Supplier> supArray = new ArrayList<part01.Supplier>();

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
		
		System.out.println(sup1.getSupAddressAsString());
		AddSupplier();
		
		System.out.println(SupplierTester.supArray.get(2).getSupAddressAsString());
	}

	public static void AddSupplier() {
		System.out.println("Please enter the following supplier details:");

		System.out.println("Supplier Name:");

		String  supName = input.next();

		System.out.println("---Supplier Address details---");


		part01.Address supAddress = AddAddress();

		int numOfEnums = EnumSet.allOf(SupRegion.class).size();

		printEnumList(numOfEnums);

		System.out.println("\nPlease choose the region of your supplier:");

		int regionChoice = input.nextInt();

		part01.SupRegion supRegion = part01.SupRegion.values()[regionChoice-1];


		ArrayList<part01.Product> supProducts = AddProduct();

		Random supCodeRandom = new Random(100);
		int supCode = supCodeRandom.nextInt();

		part01.Supplier tempSupplier = new part01.Supplier(supCode, supName, supAddress, supRegion, supProducts);

		supArray.add(tempSupplier);

	}

	public static void printEnumList(int numOfEnums) {
		for(int index = 1; index <= numOfEnums; index++) {											
			System.out.println(index + ": " + part01.SupRegion.values()[index-1].getSupRegionAsString());
		}
	}

	public static part01.Address AddAddress() {

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

		part01.Address newAddress = new part01.Address(bldNum, bldStreet, bldTown, bldPCode, bldCountry);

		return newAddress;

	}

	public static ArrayList<part01.Product> AddProduct() {

		boolean proDiscontinued = false;
		boolean proInStock = false;
		int proQtyAvailable = 0;
		ArrayList<part01.Product> newProductArray = new ArrayList<part01.Product>();

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

		part01.Product newProduct = new part01.Product(proCode, proMake, proModel, proPrice, proInStock);
		newProduct.setProQtyAvailable(proQtyAvailable);
		newProduct.setProDiscontinued(proDiscontinued);

		newProductArray.add(newProduct);															//The product is then added to the array list for the specified supplier

		System.out.println();

		return newProductArray;
	}
}