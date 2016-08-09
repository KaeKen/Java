public class LabCourse extends CollegeCourse{

	public LabCourse(String dptName, double courseNum, int credits) {
		super(dptName, courseNum, credits);
	}
	
	@Override
	public void display(){
		super.display(50);
	}
	
}
