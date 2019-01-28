package part02;

import java.util.Random;
import java.util.Scanner;

public class ProductTester {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Product testProduct = new Product(12, "Test01", "Model01", 23.45, true);
		
		System.out.println(testProduct.getProductDetails());
		
		Product testProduct02 = AddProduct();
		
		System.out.println(testProduct02.getProductDetails());
	}
	
	public static Product AddProduct() {
		
		boolean proDiscontinued = false;
		boolean proInStock = false;
		int proQtyAvailable = 0;
		
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
		
		return newProduct;
	}

}
