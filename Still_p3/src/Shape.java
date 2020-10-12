abstract class Shape
{
    abstract String getName();
}

class Square extends Shape
{
    int side;
    Square(int s)
    {
        this.side = s;
    }

    String getName()
    {
        return "square";
    }
}