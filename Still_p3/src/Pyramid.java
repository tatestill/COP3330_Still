import static java.lang.Math.sqrt;

public class Pyramid extends Shape3D{
    double length;
    double width;
    double height;
    Pyramid(double l, double w, double h)
    {
        this.length = l;
        this.width = w;
        this.height = h;
    }
    public String getName()
    {
        return "pyramid";
    }

    public double getArea()
    {
        double temp1, temp2, temp3;
        temp1 = length * width;
        temp2 = sqrt((width/2) *(width/2) + height*height) * length;
        temp3 = sqrt((length/2) *(length/2) + height*height) * width;
        return temp1 + temp2 + temp3;
    }

    public double getVolume()
    {
        double temp = (length * width) * height;
        return temp/3;
    }

}
