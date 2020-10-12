public class Cube extends Shape3D
{
    double side;
    Cube(double s)
    {
        this.side = s;
    }

    public String getName()
    {
        return "cube";
    }

    public double getArea()
    {
        double temp = side * side;
        return temp * 6;
    }

    public double getVolume()
    {
        double temp = side * side;
        return temp * side;
    }
}
