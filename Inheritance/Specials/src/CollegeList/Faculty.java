package CollegeList;

public class Faculty extends CollegeEmployee{
    private Boolean isTenured;
    private String option;

    @Override
    public void setData(){
        super.setData();
        System.out.println("Tenured? [Y/N]: ");
        if(option.equals("Y") || option.equals("y")){
            isTenured = true;
        }else{
            isTenured = false;
        }
    }

    @Override
    public void display(){
        super.display();
        System.out.println(
                "Tenured: " + isTenured
        );
    }
}
