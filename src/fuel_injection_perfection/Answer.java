/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuel_injection_perfection;

import java.util.ArrayList;

/**
 *
 * @author Predrag
 */
public class Answer {

    public static int answer(String n) {
        // Your code goes here.
        ArrayList<Long> dividedString = new ArrayList();
        
        int len = 3;
        
        int i = n.length() / len;
        int j = n.length() % len;

        dividedString.add(Long.parseLong(n.substring(0, j)));
        for (int k = 0; k < i; k++) {
            dividedString.add(Long.parseLong(n.substring(j + k * len, j + (k + 1) * len)));
        }

        int size = dividedString.size();
        
        while (size > 1) {
            if (dividedString.get(size - 1) % 2 == 1) {
                dividedString.set(size - 1, dividedString.get(size - 1) + 1);
            } else {
                for (int k = 0; k < 10; k++) {
                
                }
            }
            
        }
        
        while (dividedString.get(0) > 1) {
            
        }

        return 0;
    }
    public static void main(String[] args) {
        answer("12123123123123123");
    }
}
