package part02;

import java.util.Scanner;

public class Validation {

	static Scanner input = new Scanner(System.in);

	// This validates the users decision for any lists that are printed out, and if it is invalid, asks for another input

	public static int listValidation(int numOfChoices) {
		
		boolean userChoice = false;

		while(!userChoice) {
			if(input.hasNextInt()) {						
				int choice = input.nextInt();
				if (choice >=1 && choice <= numOfChoices) {
					userChoice = true;
					return choice;
				}else {
					choice = input.nextInt();
					if (choice >=1 && choice <= numOfChoices) {
						userChoice = true;
						return choice;
					} else {
						System.out.println("Error - Please enter a number between 1 and " + numOfChoices);
					}	
				}
			}else {
				System.out.println("Error - please enter an integer");
				input.next();
			}

		}
		return 0;

	}

	// This validates the users choice when asked for an integer, and if it is invalid, asks for another input

	public static int intValidation() {
		int number = 0;
		while (input.hasNextInt()) {
			number = input.nextInt();
			if (number <= 0) {
				System.out.println("Please enter a positive number");
			}else {
				
				return number;
			}
		}	    
		    while (!input.hasNextInt()) {
		        System.out.println("Please enter a valid,positive number");
		        input.next();
		    }

		
		return 0;
	}
	
	// This validates the users choice when asked for a double, and if it is invalid, asks for another input

	public static double doubleValidation() {
		double number = 0;
		
		boolean userChoice = false;

		while(!userChoice) {
		while (input.hasNextDouble()) {
			number = input.nextDouble();
			if (number <= 0) {
				System.out.println("Please enter a positive number");	
			}else {
				userChoice = true;
				input.next();
				return number;
			}
		}	    
		    while (!input.hasNextDouble()) {
		        System.out.println("Please enter a valid,positive number");
		        input.next();
		    }

		}
		return 0;
	}

	//This validates the users input when asks for a string, and if invalid asks for a new input

	public static String stringNoIntsValidation() {
		
		String choice = null;
		do {
		    
		    while (input.hasNextInt()) {
		        System.out.println("Please enter a valid sentence");
		        input.next(); 
		    }
		    choice = input.nextLine();
		} while (choice.isEmpty() == true);
		for (char c : choice.toCharArray()) {
		    if (!Character.isAlphabetic(c)){
		        System.out.println("INVALID");
		        break;
		    }
		    
		}
		
		return choice;
	}

	public static String stringValidation() {
		String choice = null;
		do {
		    
		    while (input.hasNextInt()) {
		        System.out.println("Please enter a valid sentence");
		        input.next(); 
		    }
		    choice = input.nextLine();
		} while (choice.isEmpty() == true);
		
		return choice;
	}
}
