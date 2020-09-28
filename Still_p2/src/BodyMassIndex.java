import java.text.DecimalFormat;
import java.util.*;

public class BodyMassIndex {
    public double height;
    public double weight;

    public BodyMassIndex(double hght, double wght) {
        height = hght;
        weight = wght;
    }

    public double calculateBMI()
    {
        double BMI;
        double roundedBMI;
        double hSquared;
        BMI = 703 * weight;
        hSquared = height * height;
        BMI = BMI / hSquared;
        roundedBMI = Math.round(BMI*10.0)/10.0;
        return roundedBMI;
    }
    public String categoryBMI()
    {
        double BMI;
        BMI = calculateBMI();
        if(BMI < 18.5)
        return "Underweight";
        else if(BMI >= 18.5 && BMI < 25)
        return "Normal weight";
        else if(BMI >= 25 && BMI <30)
        return "Overweight";
        else
        return "Obesity";


    }
}