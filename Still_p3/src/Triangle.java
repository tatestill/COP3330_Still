public class Triangle extends Shape2D
{
    double side1, side2;
    Triangle(double s1, double s2)
    {
        this.side1 = s1;
        this.side2 = s2;
    }

    public String getName()
    {
        return "triangle";
    }

    public double getArea()
    {
        double temp;
        temp = side1 * side2;
        return temp/2;
    }
}
