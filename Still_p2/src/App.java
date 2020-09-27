import java.util.*;

public class App {

    static boolean first = true;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();
            System.out.print("User height is " + height + "\nUserweight is " + weight);
/*
            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);*/
            System.out.println("\n\nMain Function running!\nMain Function running!\n");
        }

        //displayBmiStatistics(bmiData);
    }

    private static boolean moreInput()
    {
        int keepGoing;
        if(first)
        {
            System.out.println("Welcome to the Body Mass Index Calculator");
            first = false;
            return true;
        }

        System.out.print("Enter 1 to perform another BMI calculation, and 0 to end and display statistics : ");
        keepGoing = input.nextInt();
        while(keepGoing != 1 && keepGoing != 0)
        {
            System.out.print("Invalid input, please enter 1 or 0 : ");
            keepGoing = input.nextInt();
        }
        return (keepGoing == 1);
    }

    private static double getUserHeight()
    {
        double height;
        System.out.print("Please enter height in inches for BMI calculation : ");
                height = input.nextDouble();
        while(height < 0)
        {
            System.out.print("Negative number entered. Please enter a positive number for height: ");
            height = input.nextDouble();
        }
        return height;
    }

    private static double getUserWeight()
    {
        double weight;
        System.out.print("Please enter weight in pounds for BMI calculation : ");
        weight = input.nextDouble();
        while(weight < 0)
        {
            System.out.print("Negative number entered. Please enter a positive number for weight: ");
            weight = input.nextDouble();
        }
        return weight;
    }
}
