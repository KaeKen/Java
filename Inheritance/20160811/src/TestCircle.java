import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestCircle {
    public static void main(String[] args){
        int x, y;
        Scanner inputNum = new Scanner(System.in);
        ArrayList<Point> points = new ArrayList<>();
        Circle thisCircle;

        System.out.print("Enter coordinate for center point" + "\nX: ");
        x = inputNum.nextInt();
        System.out.print("Y: ");
        y = inputNum.nextInt();
        points.add(new Point(x,y));
        System.out.print("\nEnter coordinate for edge of the circle: " + "\nX: ");
        x = inputNum.nextInt();
        System.out.print("Y: ");
        y = inputNum.nextInt();
        points.add(new Point(x, y));

        thisCircle = new Circle(points.get(0), points.get(1));

        System.out.println(
                "\nRadius: " + thisCircle.getRadius() +
                "\nDiameter: " + thisCircle.getDiameter() +
                "\nCircumference: " + thisCircle.getCircumference() +
                "\nArea: " + thisCircle.getArea() +
                "\nCenter point: " + thisCircle.getX() + ", " + thisCircle.getY()
        );

        thisCircle.getEdgePoint();


    }
}
