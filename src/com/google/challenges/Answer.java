/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.google.challenges;

/**
 *
 * @author Predrag
 */
public class Answer {

    public static int answer(String s) {

        // Your code goes here.
        int length = s.length();
        int leftWalk = 0;
        int salutes = 0;
        for (int i = 0; i < length; i++) {
            String ch = s.substring(i, i+1);
            if(ch.equalsIgnoreCase(">")) {
                leftWalk++;
            } else if (ch.equalsIgnoreCase("<")) {
                salutes += leftWalk;
            }
        }
        return salutes * 2;
    }
    public static void main(String[] args) {
        System.out.println(answer(">----<"));
    }
}
