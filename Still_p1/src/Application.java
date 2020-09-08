
import java.util.*;

public class Application
{

    public static void main(String[] args)
    {
        String inputValue;
        String encryptedValue;
        String decryptedValue;
        int choice;

        Encrypter myEncrypter= new Encrypter();
        Decrypter myDecrypter = new Decrypter();
        choice = getChoice();
        if(choice == 1)
        {
            inputValue = getEncryptionValue();
            encryptedValue = myEncrypter.encrypt(inputValue);

            System.out.println("You entered " + inputValue);
            System.out.println("Encrypted value is " + encryptedValue);
        }
        else
        {
            inputValue = getDecryptionValue();
            decryptedValue = myDecrypter.decrypt(inputValue);
            System.out.println("You entered " + inputValue);
            System.out.println("Decrypted value is " + decryptedValue);
        }
    }

    static char getChoice()
    {
        int inputValue;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 1 for encryption and 2 for decryption: ");
        while(true)
        {
            inputValue = input.nextInt();
            if (inputValue == 1)
                return 1;
            if (inputValue == 2)
                return 2;
            else
                System.out.print("Invalid entry, please enter 1 for encryption and 2 for decryption: ");
        }

    }
    static String getEncryptionValue()
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for encryption: ");
        inputValue = input.nextLine();
        return inputValue;
    }

    static String getDecryptionValue()
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for decryption: ");
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
        int[] arrayOut = new int[4];
        int i;
        for(i=0 ; i < 4 ; i++)
        {
            arrayOut[i] = stringIn.charAt(i) - 48;
        }
        return arrayOut;

    }

    static String convertArrayToString(int[] array)
    {
        char[] charArray = new char[4];
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
        int[] digits;
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

    static int[] firstEncrypt(int[] in)
    {
        int i;
        for(i=0; i < 4 ; i++)
        {
            in[i] = addSevenModTen(in[i]);
        }
        return in;
    }

}

class Decrypter
{
    static String decrypt(String encryptedValue)
    {
        String decryptedValue;
        int[] encryptedArray;

        encryptedArray = Application.convertStringToArray(encryptedValue);
        encryptedArray = Application.swapFirstThirdandSecondFourth(encryptedArray);
        encryptedArray = finalDecrypt(encryptedArray);
        decryptedValue = Application.convertArrayToString(encryptedArray);
        return decryptedValue;

    }

    static int[] finalDecrypt(int array[])
    {
        int i;
        for(i=0 ; i < 4 ; i++)
        {
            if(array[i] < 7 )
                array[i] = array[i] + 10;

            array[i] = array[i] - 7;


        }

        return array;

    }
}