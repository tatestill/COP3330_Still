public class Square extends Shape2D
{
    double side;
    Square(double s)
    {
        this.side = s;
    }

    String getName()
    {
        return "square";
    }

    double getArea()
    {
        return (side * side);
    }
}