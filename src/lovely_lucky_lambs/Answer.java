/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lovely_lucky_lambs;

import java.util.ArrayList;

/**
 *
 * @author Predrag
 */
public class Answer {

    public static int answer(int total_lambs) {

        ArrayList<Integer> listMin = new ArrayList<>();        
        listMin.add(1);
        listMin.add(1);
        
        int totalMin = total_lambs - 2;
        while (totalMin > 0) {
            int size = listMin.size();
                int incr = listMin.get(size - 1) + listMin.get(size - 2);
                if (incr > totalMin) {
                    break;
                }
                totalMin -= incr;
                listMin.add(incr);

        }

        ArrayList<Integer> listMax = new ArrayList<>();
        listMax.add(1);
        listMax.add(2);

        int totalMax = total_lambs - 3;
        while (totalMax > 0) {
            int size = listMax.size();
                int incr = listMax.get(size - 1) * 2;
                if (incr > totalMax) {
                    if (totalMax < listMax.get(size - 1) + listMax.get(size - 2))  {
                        break;
                    } else {
                        incr = totalMax;
                    }
                }
                totalMax -= incr;
                listMax.add(incr);
        }

        // Your code goes here.
        return listMin.size() - listMax.size();
    }

    public static void main(String[] args) {
        System.out.println(answer(143));
    }
}
