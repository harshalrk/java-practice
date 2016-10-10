package arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        
        int currentHigh = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if (i >= arr.length-2) continue;
            
            for (int j = 0; j < arr[i].length; j++){
                if (j >= arr[i].length-2) continue;
                int sum = calculateHourGlassSum(arr,i,j);
                System.out.println(sum);
                if (sum > currentHigh)
                    currentHigh = sum;
            }
        }
        
        System.out.println(currentHigh);
    }
    
    private static int calculateHourGlassSum(int[][] arr, int i, int j){
    	
    	System.out.println();
    	System.out.println(arr[i][j]+" "+arr[i][j+1]+" "+arr[i][j+2]);
    	System.out.println(arr[i+1][j+1]);
    	System.out.println(arr[i+2][j]+" "+arr[i+2][j+1]+" "+arr[i+2][j+2]);
        return arr[i][j]+arr[i][j+1]+arr[i][j+2]
            +arr[i+1][j+1]
            +arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
    }
}

