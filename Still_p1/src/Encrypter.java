public class Encrypter
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

    static int addSevenModTen(int x) //Takes integer value, adds seven and performs modulo ten;
    {
        x = x + 7;
        x = x % 10;

        return x;
    }

    static int[] firstEncrypt(int[] array)//Encrypts values of array
    {
        int i;

        for(i=0; i < 4 ; i++)
        {
            array[i] = addSevenModTen(array[i]);
        }

        return array;
    }

}