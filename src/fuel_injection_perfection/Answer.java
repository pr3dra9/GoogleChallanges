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
        
        int len = 2;
        
        int i = n.length() / len;
        int j = n.length() % len;
        if (j > 0) 
            dividedString.add(Long.parseLong(n.substring(0, j)));
        for (int k = 0; k < i; k++) {
            dividedString.add(Long.parseLong(n.substring(j + k * len, j + (k + 1) * len)));
        }

        int size = dividedString.size();
        int oprtation= 0;
        while (size > 0) {
            if (dividedString.get(size - 1) % 2 == 1) {
                dividedString.set(size - 1, dividedString.get(size - 1) + 1);
                oprtation++;
                continue;
            } else {
                for (int k = 0; k < size; k++) {
                    long ii = dividedString.get(k) % 2;
                    if (ii == 1) {
                        long jjj = (long)(Math.pow(10, len));
                        dividedString.set(k+1, dividedString.get(k+1) + jjj);
                    }                                        
                    long jj = dividedString.get(k) / 2;
                    dividedString.set(k, jj);
                }
            }
            if (size > 1 && dividedString.get(0) == 0) {
                dividedString.remove(0);
                size--;
            } else if (size == 1 && dividedString.get(0) == 1) {
                size--;
            }
            oprtation++;
        }

        return oprtation;
    }
    public static void main(String[] args) {
        System.out.println(answer("100000"));
    }
}
