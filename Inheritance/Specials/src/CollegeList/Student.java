package CollegeList;

public class Student extends Person{
    private String majorField;
    private double aveGradePoint;

    @Override
    public void setData(){
        majorField = iString("Major field of study: ");
        aveGradePoint = iDouble("Average grade point: ");
    }
}
