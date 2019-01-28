package part02;

public class PrintMethods {


	static int userChoice = 0;
	static int numOfChoices = 0;
	//This prints out all the items currently added to the selected supplier, and asks if a new supplier is to be added
	//if there are no suppliers in the system
	public static void printAllItems() {
		if(Part02Tester.supArray.size() == 0) {
			System.out.println("There are no suppliers in the system");
			AddMethods.addSupQuestion();
		}else {
		Supplier selectedSup = Part02Tester.getSupplier();		

		for(Product item: selectedSup.getSupProducts()  ) {
			System.out.println(item.getProductDetails());
		}
		System.out.println();
		}
	}

	// This prints all of the suppliers currently added to the supplier array
	public static void printSuppliers() {
		int index = 1;												
		if(Part02Tester.supArray.size() == 0) {
			System.out.println("There are no suppliers in the system");
			AddMethods.addSupQuestion();
		}else {
			for(Supplier sup: Part02Tester.supArray) {
				System.out.println(index + " : " + sup.getSupName());
				index ++;
			}
		}
	}
	
	//This prints out all the items currently added to the selected supplier
	public static void printProducts(Supplier selectedSup) {
		int index = 1;
		if(Part02Tester.supArray.size() == 0) {
			System.out.println("There are no suppliers in the system");
			AddMethods.addSupQuestion();
		}else {
			for(Product item: selectedSup.getSupProducts()  ) {
				System.out.println(index + " : " + item.getProductDetails());	
				index++;
			}
		}
	}	
	
	//This prints all of the regions that the supplier can be from with regards to the values stored in the SupRegion enum
	public static void printEnumList(int numOfEnums) {
		for(int index = 1; index <= numOfEnums; index++) {											
			System.out.println(index + ": " + SupRegion.values()[index-1].getSupRegionAsString() );
		}
	}
	
	//This prints the sub-menu for editing suppliers
	public static void printSupEditOptions() {
		
		System.out.println();
		System.out.println("----Edit Options----");
		System.out.println("1.Edit name");
		System.out.println("2.Edit address");
		System.out.println("3.Edit supplier region");
		System.out.println("4.Return to main menu");
		
		numOfChoices = 4;
		
		userChoice = Validation.listValidation(numOfChoices);
		
		switch (userChoice) {
		case 1 : EditMethods.editName();; break;
		case 2 : printAddressOptions(); break;
		case 3 : EditMethods.editSupRegion(); break;
		case 4 : break;
		default : System.out.println("Please select an option"); break;
		}
	}
	
	//This prints the sub-menu for editing products
	public static void printProdEditOptions() {
		System.out.println();
		System.out.println("----Edit Options----");
		System.out.println("1.Edit make" + "\n" + "2.Edit model"
		+ "\n" + "3.Edit price" + "\n" + "4.Edit amount of stock available for purchase" + 
				"\n" + "5.Change product continuation" + "\n" + "6.Return to main menu");
		
		numOfChoices = 5;
		
		userChoice = Validation.intValidation();
		
		switch (userChoice) {
		case 1 : EditMethods.editMake(); break;
		case 2 : EditMethods.editModel(); break;
		case 3 : EditMethods.editPrice(); break;
		case 4 : EditMethods.editProQtyAvailable(); break;
		case 5 : EditMethods.editProDiscontinued(); break;
		case 6 : break;
		default : System.out.println("Please select an option");
		}
	}
	
	//This prints the sub-menu for editing the address of a supplier
	public static void printAddressOptions() {
		
		System.out.println();
		System.out.println("----Edit Options----");
		System.out.println("1.Edit building number");
		System.out.println("2.Edit street name");
		System.out.println("3.Edit town name");
		System.out.println("4.Edit postcode");
		System.out.println("5.Edit country");
		System.out.println("6.Return to main menu");
		
		numOfChoices = 6;
		
		userChoice = Validation.listValidation(numOfChoices);
		
		switch (userChoice) {
		case 1 : EditMethods.editbldNum(); break;
		case 2 : EditMethods.editStreet();; break;
		case 3 : EditMethods.editTown(); break;
		case 4 : EditMethods.editPCode(); break;
		case 5 : EditMethods.editCountry(); break;
		case 6 : break;
		default : System.out.println("Please select an option"); break;
		}
	}
	
	//This prints the sub-menu for searching for suppliers
	public static void printSupSearchMenu() {
		System.out.println("\n" + "----Search Options----" + "\n");
		System.out.println("1.Search by name"  + "\n" + "2.Search by region" + "\n" + "3.Return to main menu");
		numOfChoices = 4;
		userChoice = Validation.listValidation(numOfChoices);
		
		switch (userChoice) {
		case 1 : SearchMethods.supplierNameSearch(); break;
		case 2 : SearchMethods.supRegionSearch(); break;
		case 3 : break;
		default : System.out.println("Please select an option"); break;
		}
	}
	
	//This prints the sub-menu for searching for products
	public static void printProdSearchMenu() {
		System.out.println("\n" + "----Search Options----" + "\n");
		System.out.println("1.Search by price" + "\n" + "2.Search  for discontinued products" + "\n" + "3.Return to main menu");
		numOfChoices = 3;
		userChoice = Validation.listValidation(numOfChoices);
		switch (userChoice) {
		case 1 : SearchMethods.priceSearch(); break;
		case 2 : SearchMethods.disconSearch(); break;
		case 3 : break;
		default : System.out.println("Please select an option"); break;
		}
	}


}

