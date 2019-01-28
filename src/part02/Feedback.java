package part02;

public class Feedback {

	private String userName;
	private Supplier selectedSupplier;
	private String feedback;
	/**
	 * @param userName - this is the name of the user
	 * @param selectedSupplier - this is the supplier the user is giving feedback on
	 * @param feedback - this is the feedback the user is giving
	 */
	public Feedback(String userName, Supplier selectedSupplier, String feedback) {
		this.userName = userName;
		this.selectedSupplier = selectedSupplier;
		this.feedback = feedback;
	}
	public String getUserName() {
		return userName;
	}
	public Supplier getSelectedSupplier() {
		return selectedSupplier;
	}
	public String getFeedback() {
		return feedback;
	}
	
	//This prints the details of the feedback as a string
	public String getFeedbackDetails() {
		String feedbackDetails = "\n" + "----Feedback Details----";
		feedbackDetails += "\n" + "Name of user: " + this.userName;
		feedbackDetails += "\n" + "Name of Supplier:" + this.selectedSupplier.getSupName();
		feedbackDetails += "\n" + "Feedback: " + this.feedback;
		
		return feedbackDetails;
	}
	
}
