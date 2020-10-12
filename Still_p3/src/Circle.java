import static java.lang.Math.PI;

public class Circle extends Shape2D {
    double radius;

    Circle(double r)
    {
        this.radius = r;
    }

    public String getName()
    {
        return "circle";
    }

    public double getArea()
    {
        double temp;
        temp = radius * radius;
        return temp * PI;
    }
}
