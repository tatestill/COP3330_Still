public class Decrypter
{
    public String decrypt(String encryptedValue) //Takes encrypted string and returns decrypted string
    {
        int[] encryptedArray;

        encryptedArray = convertStringToArray(encryptedValue);
        encryptedArray = swapFirstThirdandSecondFourth(encryptedArray);
        encryptedArray = finalDecrypt(encryptedArray);
        String decryptedValue = convertArrayToString(encryptedArray);

        return decryptedValue;

    }

    public static int[] finalDecrypt(int[] array) //Performs main decryption
    {
        int i;
        for(i=0 ; i < 4 ; i++)
        {
            if(array[i] < 7 ) //if value is below seven, it will have been % 10 and adding 10 will undo it
                array[i] = array[i] + 10;

            array[i] = array[i] - 7; //Takes away seven that was added during encryption
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

