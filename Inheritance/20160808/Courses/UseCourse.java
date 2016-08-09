import java.util.Scanner;
import java.util.ArrayList;

public class UseCourse {

	public static void main(String[] args) {
		ArrayList<CollegeCourse> collegecourses = new ArrayList<>();
		ArrayList<LabCourse> labcourses = new ArrayList<>();
		
		Scanner inputString = new Scanner(System.in);
		Scanner inputNum = new Scanner(System.in);
		
		String option, dptName;
		double courseNum;
		int creditHours;
		
		do{
			System.out.print("\nDepartment: ");
			dptName = inputString.nextLine();
			System.out.print("Course number: ");
			courseNum = inputNum.nextDouble();
			System.out.print("Credit hours: ");
			creditHours = inputNum.nextInt();
			
			if(isLab(dptName)){
				labcourses.add(new LabCourse(dptName, courseNum, creditHours));
			}else{
				collegecourses.add(new CollegeCourse(dptName, courseNum, creditHours));
			}
			
			System.out.print("\nWould you like to add another course? [Y/N]: ");
			option = inputString.nextLine();
		}while(option.equals("Y") || option.equals("y"));
		
		if(collegecourses.size() > 0){
			System.out.println("\nCollege courses: \n");
			for(CollegeCourse thisCCourse: collegecourses){
				thisCCourse.display();
			}
		}
		
		if(labcourses.size() > 0){
			System.out.println("\nLab courses: \n");
			for(LabCourse thisLCourse: labcourses){
				thisLCourse.display();
			}
		}
			
	}
	
	public static boolean isLab(String dptName){
		String[] labCourses = {"BIO", "CHM", "CIS", "PHY"};
		for(String thisCourse : labCourses){
			if(dptName.equals(thisCourse)){
				return true;
			}
		}
		return false;
	}

}
