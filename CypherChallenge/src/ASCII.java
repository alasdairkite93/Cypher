/** Developing this program so that it:
 * Beautifies the solution process by printing the shift with more information.
 * Using Java.FX to be able to work on the cipher text using an fx box.
 * Selecting individual characters of a string to shift and change which brings the program closer to solving more
 * complex problems.
 */

import java.util.*;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ASCII {

    private List<Integer> shifts;

    public static void main(String[] args) {

        String data = null;

        try {
            File myObj = new File("cipher.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("File unreachable");
            e.printStackTrace();
        }

        String spacetest = removeSpace(data);
        String translate = spacetest.toLowerCase(Locale.ROOT);
        char[] testchar = translate.toCharArray();

        int[] asciitestchar = new int[testchar.length];
        int[] caesershift = new int[asciitestchar.length];
        int[] caesercorrect = new int[asciitestchar.length];
        char[] charshift = new char[caesershift.length];

        for (int i = 0; i < testchar.length; i++){
            asciitestchar[i] = (int) testchar[i];
            caesershift[i] = asciitestchar[i] + 1;
            if (caesershift[i] > 122){caesershift[i] = caesershift[i] - 25;}
        }

        for (int k = 0; k < caesershift.length; k++){
            charshift[k] = (char) caesershift[k];
        }

        Boolean play = false;

        while (play == false) {
            String caeser = String.valueOf(charshift);
            System.out.println(caeser);
            System.out.println(frequency(caeser));
            String transform = substitution(caeser, caesershift);

            List<String> shifts = new ArrayList<>();
            shifts.add(transform);

            System.out.println(transform);
            System.out.println("Play again? [y/n]");
            Scanner selection = new Scanner(System.in);
            String value = selection.nextLine();
            if (value.equals("y"))
            {
                play = false;
            }
            else {play = true;}
        }
    }

    /**Sanitise the string for encryption**/
    static String removeSpace(String test){
        test = test.replaceAll(" ","");
        return test;
    }

    /**Calculate the frequency of the string**/
    static Map<Character, Integer> frequency(String caeser){
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();

        char[]frequency = caeser.toCharArray();
        for (char f:frequency){
            if (charCountMap.containsKey(f)){
                charCountMap.put(f, charCountMap.get(f) + 1);
            }
            else {
                charCountMap.put(f, 1);
            }
        }
        return charCountMap;
    }

    /**This method substitutes values into the algorithm based on the frequency. So for example a letter is chosen and
     * the user chooses what letter it should be by selecting the shift to make it that character.
     * @return
     */

    static String substitution(String caeser, int[] caesershift)
    {
        //first select character to transform
        //calculate shift for the letter to be transformed
        //shift the cipher to make the letter transformed.



        Scanner selection = new Scanner(System.in);
        System.out.println("Enter char to translate");
        String value = selection.nextLine();
        char[] val = value.toCharArray();
        int[] valint = new int[val.length];
        System.out.println("Enter char to transform to");
        String trans = selection.nextLine();
        char[] tran = trans.toCharArray();
        int[] tranint = new int[tran.length];

        int shift = 0;

        if (caeser.contains(value)) {
            //find the difference between the trans and value for the shift.
            for (int k = 0; k < val.length; k++) {
                valint[k] = (int) val[k];
                tranint[k] = (int) tran[k];
                shift = tranint[k] - valint[k];
            }
        }

        int [] normal = new int[caesershift.length];

        for (int l = 0; l < caesershift.length; l++)
        {
            normal[l] = caesershift[l] + shift;
        }

        //translate back to normal

        char [] shifted = new char[normal.length];

        for (int m = 0; m < normal.length; m++){
            shifted[m] = (char) normal[m];
        }

        String attempt = new String(shifted);

        //This method returns string.
        return attempt;
    }
    static String caeserShift(){

    return null; }

}

