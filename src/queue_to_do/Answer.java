/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue_to_do;

import java.util.ArrayList;

/**
 *
 * @author Predrag
 */
public class Answer {
    public static int answer(int start, int length) {
        // Your code goes here.
        int curLength = length;
        
        int xorSum = start;
        boolean started = false;
        while (curLength > 0) {
            for (int i = 0; i < curLength; i++) {
                if (started) {
                    xorSum = xorSum ^ start;
                } else {
                    xorSum = start;
                    started = true;
                }
                start++;
            }
            
            start += length - curLength;
            curLength--;
        }
                
        return xorSum;
    }
    
    public static void main(String[] args) {
        System.out.println(answer(17, 4));
    }
}
