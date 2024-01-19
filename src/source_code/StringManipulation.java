package source_code;

import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {

        System.out.println("Enter String");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.trim(); // Remove first and last space...

        countWords(str);
        String [] words = reverseWords(str);
        removeSpacesPutHyphen(words);
    }

    public static void countWords(String str) {
        int count = 0;
        for (int i = 0; i < str.length()-1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i+1) != ' ') {
                count++;  //count space
            }

        }
        int noOfWords = count + 1;  // increment by 1
        System.out.println("Number of Words : " + noOfWords);
    }

    public static String[] reverseWords(String str) {
        String[] words = str.split(" "); //String array[] to store each words
        String revSentence = "";

        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].trim().length() != 0)
                revSentence += words[i]  + " ";                //to store reverse words
        }
        System.out.println("Reverse Sentenced : " + revSentence);
        return words;
    }

    public static void removeSpacesPutHyphen(String[] words) {

        String resultantString = "";
        int strLen = words.length;
        for (int i = 0; i < strLen; i++) {
            if (words[i].trim().length() != 0) {
                resultantString += words[i];                //to store reverse words
                if (i < strLen - 1)  // To avoid last word hyphen concat
                    resultantString += '-';
            }
        }
        System.out.println("Modified Sentence : " + resultantString);
    }
}