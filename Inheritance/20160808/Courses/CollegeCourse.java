public class CollegeCourse {
	private String dptName;
	private double courseNum, courseFee;
	private int credits;
	
	public CollegeCourse(String dptName, double courseNum, int credits) {
		this.dptName = dptName;
		this.courseNum = courseNum;
		this.credits = credits;
		courseFee = 120;
	}
	
	public void display(double extraFee){
		System.out.println(
				 "Department: " + dptName +
				 "\nCourse number: " + courseNum +
				 "\nCredit hours: " + credits +
				 "\nCourse Fee: " + (credits * (courseFee + extraFee)));
	}
	
	public void display(){
		display(0);
	}
	
}
