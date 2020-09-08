import java.util.Scanner;

public class Application {

    public static void main(String args[])
    {
        String inputValue;

        Encrypter encryptOut = new Encrypter();

        inputValue = getValue();



        System.out.print("You entered ")
    }

    static String getValue()
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for encryption: ");
        inputValue = input.nextLine();
        return inputValue;
    }
}

class Encrypter{

    int digits[] = new int[4];


    static String encrypt(String input)
    {
        Encrypter encryptOut = new Encrypter();

        return input;
    }

    static int[] convertStringToArray(String stringIn)
    {
        int arrayOut[] = new int[4];
        int i;
        for(i=0 ; i < 4 ; i++)
        {
            arrayOut[i] = stringIn.charAt(i) - 48;
        }
        return arrayOut;

    }


    static int addSevenModTen(int x)
    {
        x = x + 7;
        x = x % 10;
        return x;
    }

    static Encrypter firstEncrypt(Encrypter in)
    {
        int i;
        for(i=0; i < 4 ; i++)
        {
            in.digits[i] = addSevenModTen(in.digits[i]);
        }
        return in;
    }

}