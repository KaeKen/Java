package CollegeList;

public class CollegeEmployee extends Person{
    private int socialNum;
    private double annunSalary;
    private String dptName;

    @Override
    public void setData(){
        super.setData();
        socialNum = iInt("Social Security number: ");
        annunSalary = iDouble("Annual salary: ");
        dptName = iString("Department name: ");
    }

    @Override
    public void display(){
        super.display();
        System.out.println(
                "Social Security Number: " + socialNum +
                "\nAnnual Salary: " + annunSalary +
                "\nDepartment: " + dptName
        );
    }
}
