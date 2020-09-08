public class Encrypter
{


    public String encrypt(String input)
    {
        int[] digits;
        String encryptedOut;

        digits = convertStringToArray(input);
        digits = firstEncrypt(digits);
        digits = swapFirstThirdandSecondFourth(digits);
        encryptedOut = convertArrayToString(digits);

        return encryptedOut;

    }

    public static int addSevenModTen(int x) //Takes integer value, adds seven and performs modulo ten;
    {
        x = x + 7;
        x = x % 10;

        return x;
    }

    public static int[] firstEncrypt(int[] array)//Encrypts values of array
    {
        int i;

        for(i=0; i < 4 ; i++)
        {
            array[i] = addSevenModTen(array[i]);
        }

        return array;
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