/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bringing_a_gun_to_a_guard_fight;

import java.util.ArrayList;

/**
 *
 * @author Predrag
 */
public class Answer {
    public static int answer(int[] dimensions, int[] captain_position, int[] badguy_position, int distance) {
        // Your code goes here.
        class Point {
            private int x;
            private int y;
            
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public double distanceTo(Point p) {
                return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y) * (this.y - p.y));
            }
            
            public boolean isOnLineSegment(Point p1, Point p2) {
                if (p1.x > x && p2.x > x ) {
                    return false;
                }
                if (p1.x < x && p2.x < x ) {
                    return false;
                }
                if (p1.y > y && p2.y > y ) {
                    return false;
                }
                if (p1.y < y && p2.y < y ) {
                    return false;
                }
                if (this.x == p1.x && this.x == p2.x) {
                    return true;
                }                
                if (this.y == p1.y && this.y == p2.y) {
                    return true;
                }
                return this.y - p1.y == (p2.y - p1.y) / (p2.x - p1.x) * this.x- p1.x;
            }

            public boolean isOnLine(Point p1, Point p2) {
                if (this.x == p1.x && this.x == p2.x) {
                    return true;
                }                
                if (this.y == p1.y && this.y == p2.y) {
                    return true;
                }
                return this.y - p1.y == (p2.y - p1.y) / (p2.x - p1.x) * this.x- p1.x;
            }
        }

        Point captain = new Point(captain_position[0], captain_position[1]);
        Point badguy = new Point(badguy_position[0], badguy_position[1]);
        
        ArrayList<Integer> xCoordinates = new ArrayList<>();
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        
        int dy = dimensions[1] - badguy_position[1];
        int dx = dimensions[0] - badguy_position[0];

        int counter = 0;
        
        if (captain.distanceTo(badguy) <= distance) {
            counter++;
        }
        
        int maxUp = 0;
        while (true) {
            int newY = badguy_position[1] + (2 * (maxUp / 2 + 1) * dy + 2 * ((maxUp + 1) / 2) * (dimensions[1] - dy));
            Point cp = new Point(dimensions[0], newY);
            if (cp.distanceTo(captain) > distance) {
                break;
            }
            yCoordinates.add(newY);
            if (captain.x == badguy.x) {
                break;
            }
            //System.out.println(d);
            counter++;
            maxUp++;
        }
        
        int maxDown = 0;
        while (true) {          
            int newY = badguy_position[1] - (2 * (maxDown / 2 + 1) * (dimensions[1] - dy) + 2 * ((maxDown + 1) / 2) * dy);
            Point cp = new Point(dimensions[0], newY);
            if (cp.distanceTo(captain) > distance) {
                break;
            }
            yCoordinates.add(newY);
            if (captain.x == badguy.x) {
                break;
            }              
            //System.out.println(d);
            counter++;
            maxDown++;
        }

        int maxRight = 0;
        while (true) {

            int newX = badguy_position[0] + (2 * (maxRight / 2 + 1) * dx + 2 * ((maxRight + 1) / 2) * (dimensions[0] - dx));
            Point cp = new Point(newX, dimensions[1]);
            if (cp.distanceTo(captain) > distance) {
                break;
            }
            xCoordinates.add(newX);
            //System.out.println(newX);
            if (captain.y == badguy.y) {
                break;
            }            
            counter++;
            maxRight++;
        }
        
        int maxLeft = 0;
        while (true) {           
            int newX = badguy_position[0] - (2 * (maxLeft / 2 + 1) * (dimensions[0] - dx) + 2 * ((maxLeft + 1) / 2) * dx);
            Point cp = new Point(newX, dimensions[1]);
            if (cp.distanceTo(captain) > distance) {
                break;
            }
            xCoordinates.add(newX);
            //System.out.println(newX);
            if (captain.y == badguy.y) {
                break;
            }
            counter++;
            maxLeft++;
        }
        
        for (Integer yCoordinate : yCoordinates) {
            for (Integer xCoordinate : xCoordinates) {
                Point point = new Point(xCoordinate, yCoordinate);
                if (point.distanceTo(captain) <= distance) { // && !point.isOnLine(captain, badguy)
                    counter++;
                }
            }
        }
        /*
        Point p = new Point(3,3);
        Point p1 = new Point(5,-3);
        Point p2 = new Point(7,-7);
        
        System.out.println(p1.isOnLineSegment(p, p2));
        */
        //System.out.println(counter);
        return counter;
    }
    
    public static void main(String[] args) {
        answer(new int[] {300, 275}, new int[] {150, 150}, new int[] {185, 100}, 500);
    }
}
