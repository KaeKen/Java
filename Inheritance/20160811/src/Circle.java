import java.util.ArrayList;

public class Circle extends Point{

    private Point point;
    private double radius, diameter, circumference, area;

    public Circle(Point p1, Point p2) {
        super(p1.getX(), p1.getY());
        point = p2;
        radius = Math.sqrt((Math.pow((p2.getX() - p1.getX()), 2)) + Math.pow((p2.getY() - p1.getY()), 2));
        diameter = 2 * radius;
        circumference = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
    }

    public void getEdgePoint(){
        System.out.println("Edge point: " + point.getX() + ", " + point.getY());

    }

    public double getRadius() {
        return radius;
    }

    public double getDiameter() {
        return diameter;
    }

    public double getCircumference() {
        return circumference;
    }

    public double getArea() {
        return area;
    }
}
