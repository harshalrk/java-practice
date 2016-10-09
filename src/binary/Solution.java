package binary;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String binary = convertToBinaryStr(n);
        //System.out.println("Binary=>"+binary);
        String consecOnes = findConsecOnes(binary);
        System.out.println("consecOnes=>"+consecOnes);
        int number = convertToBaseTen(consecOnes);
        System.out.println(number);
    }
    
    private static String convertToBinaryStr(int n){
        StringBuilder binary = new StringBuilder();
        while(n > 0){
            int remainder = n % 2;
            n = n / 2;
            binary.insert(0, remainder);
            
        }
        return binary.toString();
    }
    
    private static String findConsecOnes(String binary){
        char[] chars = binary.toCharArray();
        StringBuilder consecOnes = new StringBuilder();
        StringBuilder currentConsecOnes = new StringBuilder();
        boolean inStreak = false;
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == '1'){
                if (inStreak){
                    currentConsecOnes.append('1');
                }else {
                    inStreak = true;
                    currentConsecOnes.setLength(0);
                    currentConsecOnes.append('1');
                }
            }else {
                if (inStreak){
                    inStreak = false;
                    if (currentConsecOnes.length() > consecOnes.length()){
                        consecOnes.setLength(0);
                        consecOnes.append(currentConsecOnes.toString());
                    }
                    currentConsecOnes.setLength(0);
                }else {
                    //Keep moving
                }
            }
        }
        if (currentConsecOnes.length() > consecOnes.length()){
            consecOnes.setLength(0);
            consecOnes.append(currentConsecOnes.toString());
        }
        
        return consecOnes.toString();
    }
    
    
    
    private static int convertToBaseTen(String binary){
      
        return binary.length();
    }
    
}

