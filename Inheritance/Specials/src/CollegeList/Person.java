package CollegeList;
import java.util.Scanner;

public class Person {
    private String firstName, lastName;
    private int zipCode, phoneNum;

    Scanner inputString = new Scanner(System.in);
    Scanner inputNum = new Scanner(System.in);

    public void setData(){
        firstName = iString("First name: ");
        lastName = iString("Last name: ");
        zipCode = iInt("Zip code: ");
        phoneNum = iInt("Phone number: ");
    }

    public void display(){
        System.out.println(
                "Name: " + lastName + ", " + firstName +
                "\nZip code: " + zipCode +
                "\nPhone number: " + phoneNum
        );
    }

    public String iString(String text){
        System.out.print(text);
        return inputString.nextLine();
    }

    public int iInt(String text){
        System.out.print(text);
        return inputNum.nextInt();
    }

    public double iDouble(String text){
        System.out.print(text);
        return inputNum.nextDouble();
    }

}
