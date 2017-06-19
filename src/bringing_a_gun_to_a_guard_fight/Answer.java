/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bringing_a_gun_to_a_guard_fight;

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
            
            public boolean isOnLine(Point p1, Point p2) {
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

        }

        int dy = dimensions[1] - badguy_position[1];
        int dx = dimensions[0] - badguy_position[0];

        int maxUp = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int maxDown = 0;
        Point captain = new Point(captain_position[0], captain_position[1]);
        
        while (true) {
            int d = badguy_position[1] + (int) (Math.pow(2, maxUp/2 + 1) * dy + (maxUp + 1) / 2 * 2 * (dimensions[1] - dy));
            Point cp = new Point(dimensions[0], d);
            if (cp.distanceTo(captain) > distance) {
                break;
            }
            System.out.println(d);
            maxUp++;
        }
        
        Point p = new Point(1,1);
        Point p1 = new Point(2,1);
        Point p2 = new Point(3,1);
        
        //System.out.println(p1.isOnLine(p, p2));
        
        return 0;
    }
    
    public static void main(String[] args) {
        answer(new int[] {5,5}, new int[] {1,1}, new int[] {1,4}, 50);
    }
}
