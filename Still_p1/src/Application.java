
import java.util.*;

public class Application
{

   static void main(String[] args)
    {
        int choice = 1;
        while(choice != 3) //Loops until exit selection is made1
        {
            choice = getChoice();
            if (choice == 1) {
                performEncryption();
            }
            if (choice == 2) {
                performDecryption();
            }
        }
        System.out.println("Goodbye!");
    }

    static char getChoice() //Gets choice between encryption, decryption, and exiting
    {
        int inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 1 for encryption, 2 for decryption, or 3 to exit: ");
        while(true)
        {
            inputValue = input.nextInt();
            if (inputValue == 1)
                return 1;
            if (inputValue == 2)
                return 2;
            if (inputValue == 3)
                return 3;
            else //if not 1, 2, or 3 the value is invalid and will repeat the loop
                System.out.print("Invalid entry, please enter 1 for encryption, 2 for decryption, or 3 to exit: ");
        }

    }
    static String getEncryptionValue() //Gets value for encryption from user
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for encryption: ");
        inputValue = input.nextLine();

        return inputValue;
    }

    static String getDecryptionValue() //Gets value for decryption from user
    {
        String inputValue;
        Scanner input = new Scanner(System.in);

        System.out.print("Enter value for decryption: ");
        inputValue = input.nextLine();

        return inputValue;
    }

    static void performEncryption() //Gets value for encryption, encrypts it, and shows encrypted value
    {
        //Gets and encrypts value
        String inputValue = getEncryptionValue();
        String encryptedValue = Encrypter.encrypt(inputValue);
        //Shows user what was entered and shows what encrypted value is
        System.out.println("You entered " + inputValue);
        System.out.println("Encrypted value is " + encryptedValue + "\n");
    }

    static void performDecryption() //Gets value for decryption, decrypts it, and shows decrypted value
    {
        //Gets and decrypts value
        String inputValue = getDecryptionValue();
        String decryptedValue = Decrypter.decrypt(inputValue);
        //Shows user what was entered and shows what decrypted value is
        System.out.println("You entered " + inputValue);
        System.out.println("Decrypted value is " + decryptedValue + "\n");
    }

     public static int[] swapFirstThirdandSecondFourth(int[] array) //Swaps the first and third values, and swaps the second and fourth values
    {
        int temp;
        //Swaps first and third values
        temp = array[0];
        array[0] = array[2];
        array[2] = temp;
        //Swaps second and fourth values
        temp = array[1];
        array[1] = array[3];
        array[3] = temp;

        return array;

    }

    public static int[] convertStringToArray(String stringIn)//Takes String and converts it into integer array
    {
        int[] arrayOut = new int[4]; //Integer array that will take the values
        int i;

        for(i=0 ; i < 4 ; i++)
        {
            arrayOut[i] = stringIn.charAt(i) - 48; // Taking away 48 converts a number character into the integer equivalent
        }

        return arrayOut;

    }

    public static String convertArrayToString(int[] arrayIn)//Takes integer array and converts it into String
    {
        char[] charArray = new char[4]; //charArray that will take values and become string
        int i;

        for(i=0 ; i < 4 ; i++)
        {
             charArray[i] = (char)(arrayIn[i] + 48); //Adding 48 converts an integer into its character equivalent
        }

        String stringOut = new String(charArray);
        return stringOut;
    }
}



