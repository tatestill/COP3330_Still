public class Sphere extends Shape3D{
    double radius;
    Sphere(double r)
    {
        this.radius = r;
    }
    public String getName()
    {
        return "sphere";
    }

    public double getArea()
    {
       return (12.566370614359172)*(radius*radius);
    }

    public double getVolume()
    {
        return 4.1887902047863905*(radius*radius*radius);
    }
}
