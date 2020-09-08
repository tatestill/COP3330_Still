public class Decrypter
{
    static String decrypt(String encryptedValue) //Takes encrypted string and returns decrypted string
    {
        int[] encryptedArray;

        encryptedArray = Application.convertStringToArray(encryptedValue);
        encryptedArray = Application.swapFirstThirdandSecondFourth(encryptedArray);
        encryptedArray = finalDecrypt(encryptedArray);
        String decryptedValue = Application.convertArrayToString(encryptedArray);

        return decryptedValue;

    }

    static int[] finalDecrypt(int[] array) //Performs main decryption
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
}