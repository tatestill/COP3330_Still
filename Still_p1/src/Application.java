
import java.util.*;

public class Application
{

    public static void main(String args[])
    {
        String inputValue;
        String encryptedValue;

        Encrypter myEncrypter= new Encrypter();

        inputValue = getValue();
        encryptedValue = myEncrypter.encrypt(inputValue);

        System.out.println("You entered " + inputValue);
        System.out.println("Encrypted value is " + encryptedValue);
    }

    static String getValue()
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for encryption: ");
        inputValue = input.nextLine();
        return inputValue;
    }

   static int[] swapFirstThirdandSecondFourth(int[] array)
    {
        int temp;

        temp = array[0];
        array[0] = array[2];
        array[2] = temp;

        temp = array[1];
        array[1] = array[3];
        array[3] = temp;
        return array;

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

    static String convertArrayToString(int[] array)
    {
        char charArray[] = new char[4];
        int i;
        for(i=0 ; i < 4 ; i++)
        {
             charArray[i] = (char)(array[i] + 48);
        }
        String stringOut = new String(charArray);
        return stringOut;
    }
}

class Encrypter
{


    static String encrypt(String input)
    {
        int digits[] = new int[4];
        String encryptedOut;
        digits = Application.convertStringToArray(input);

        digits = firstEncrypt(digits);

        digits = Application.swapFirstThirdandSecondFourth(digits);

        encryptedOut = Application.convertArrayToString(digits);

        return encryptedOut;

    }




    static int addSevenModTen(int x)
    {
        x = x + 7;
        x = x % 10;
        return x;
    }

    static int[] firstEncrypt(int in[])
    {
        int i;
        for(i=0; i < 4 ; i++)
        {
            in[i] = addSevenModTen(in[i]);
        }
        return in;
    }

}