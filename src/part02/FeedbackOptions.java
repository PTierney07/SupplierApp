package part02;

public class FeedbackOptions {

	//This allows the user to enter feedback for a supplier
	public static void giveFeedback() {
		System.out.println("\n" + "----Feeback Sheet----");
		System.out.println("Please enter your name:");
		String userName = Validation.stringValidation();
		Supplier selectedSup = Part02Tester.getSupplier();
		System.out.println("\n" + "Please enter any feedback:");
		String feedback = Validation.stringValidation();
		
		Feedback tempFeedback = new Feedback(userName, selectedSup, feedback);
		
		selectedSup.getFeedback().add(tempFeedback);
	}
	
	//This prints all feedback associated with a supplier
	public static void printFeedback() {
		Supplier selectedSup = Part02Tester.getSupplier();
		if (selectedSup.getFeedback().size() <2) {
			System.out.println("No feedback available for this supplier");
		}else {
			for (int i =1;i< selectedSup.getFeedback().size(); i++) {
				System.out.println(selectedSup.getFeedback().get(i).getFeedbackDetails());
			}	
		}	
	}
}
