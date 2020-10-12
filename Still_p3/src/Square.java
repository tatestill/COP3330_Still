public class Square extends Shape2D
{
    double side;
    Square(double s)
    {
        this.side = s;
    }

    public String getName()
    {
        return "square";
    }

    public double getArea()
    {
        return (side * side);
    }
}