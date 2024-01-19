package source_code;

import java.util.Scanner;

public class PalindromeChecker{

    public static void main(String[] args) {
        Scanner sc=  new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.next();
        str = str.toLowerCase();

        if(palindromeChecker(str)){
            System.out.println("The String " +str + " is a Palindrome");
        }
        else{
            System.out.println("The String " +str+ " is not a Palindrome");
        }

    }

    public static boolean palindromeChecker(String str) {

        // madam strlen - 4
        // 01234
        int strLen = str.length()-1;

        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(strLen-i))
                return false;
        }
        return true;
    }
}