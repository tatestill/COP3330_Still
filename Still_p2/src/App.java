import java.util.*;

public class App {

    static boolean first = true;
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);

        }

        displayBmiStatistics(bmiData);
    }

    private static boolean moreInput()
    {
        char keepGoing;
        if(first)
        {
            System.out.println("Welcome to the Body Mass Index Calculator");
            first = false;
            return true;
        }

        System.out.print("\nWould you like to perform another BMI calculation? Enter Y/N : ");
        keepGoing = input.next().charAt(0);
        input.nextLine();
        while(keepGoing != 'Y' && keepGoing != 'N')
        {
            System.out.print("Invalid input, please enter Y or N : ");
            keepGoing = input.next().charAt(0);
            input.nextLine();
        }
        return (keepGoing == 'Y');
    }

    private static double getUserHeight()
    {
        double height;
        System.out.print("Please enter height in inches for BMI calculation : ");
                height = input.nextDouble();
        while(height <= 0)
        {
            System.out.print("Negative or zero number entered. Please enter a positive nonzero number for height: ");
            height = input.nextDouble();
        }
        return height;
    }

    private static double getUserWeight()
    {
        double weight;
        System.out.print("Please enter weight in pounds for BMI calculation : ");
        weight = input.nextDouble();
        while(weight <= 0)
        {
            System.out.print("Negative or zero number entered. Please enter a positive nonzero number for weight: ");
            weight = input.nextDouble();
        }
        return weight;
    }

    private static void displayBmiInfo(BodyMassIndex bmi)
    {
        System.out.println("Your BMI(Body Mass Index) is : " + bmi.calculateBMI());
        System.out.println("Your BMI category is : " + bmi.categoryBMI());
        return;
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData)
    {
        int i;
        double avg = 0;
        for(i=0 ; i < bmiData.size() ; i++)
        {
            avg = avg + bmiData.get(i).calculateBMI();
        }
        avg = avg / bmiData.size();
        avg = Math.round(avg*10.0)/10.0;
        System.out.print("Thank you for using the Body Mass Index Calculator\nThe average BMI of this session was : " + avg);
    }
}
