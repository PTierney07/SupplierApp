package part02;

public class RemoveMethods {
	
	static int userChoice = 0;

	//This removes the supplier selected by the user from the supArray array list
	public static void removeSupplier() {

		PrintMethods.printSuppliers();

		System.out.println("\n" + "Please select your desired supplier to remove");
		userChoice = Validation.listValidation(Part02Tester.supArray.size());

		Part02Tester.supArray.remove(userChoice-1);

	}

	//This removes the product selected by the user from the product array list of the selected supplier
	public static void removeProduct() {

		PrintMethods.printSuppliers();

		System.out.println("\n" + "Please select your desired supplier");
		userChoice = Validation.listValidation(Part02Tester.supArray.size());

		Supplier selectedSup = Part02Tester.supArray.get(userChoice -1);

		PrintMethods.printProducts(selectedSup);

		System.out.println("\n" + "Please selected the product you would like to remove");
		userChoice = Validation.listValidation(selectedSup.getSupProducts().size());

		selectedSup.getSupProducts().remove(userChoice-1);
	}

}
