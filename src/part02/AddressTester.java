
package part02;

import java.util.Scanner;

public class AddressTester {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Address address01 = new Address(23, "TestStr", "TestTwn", "Ts01 0Ts", "TestCntry");
		
		System.out.println(address01.getFullAddress());
		
		Address newAddress = AddAddress();
		
		System.out.println(newAddress.getFullAddress());

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

}
