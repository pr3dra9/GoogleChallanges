/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepare_the_bunnies_escape;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Predrag
 */
public class Answer {
    public static int answer(final int[][] maze) {
        final int mazeX = maze.length - 1;
        final int mazeY = maze[0].length - 1;
                
        class Field implements Comparable<Field> {
            
            private int pathLength;
            private int x;
            private int y;
            private int wall;
            private Field previous;
            private double distance;
            private List<Field> neighbors;
            
            public Field(int x, int y, Field previous) {
                this.x = x;
                this.y = y;
                this.previous = previous;
                
                if (previous != null) {                    
                    this.pathLength = previous.getPathLength() + 1;
                } else {
                    this.pathLength = 1;
                }
                
                if (previous != null && previous.getWall() == 1) {
                    this.wall = 1;
                } else {
                    this.wall = maze[x][y];
                }                
                
                this.distance = Math.sqrt(Math.pow((mazeX - x), 2) + Math.pow((mazeY - y), 2)) + pathLength;
            }
            
            public int getPathLength() {
                return pathLength;
            }
            
            public int getX() {
                return x;
            }
            
            public int getY() {
                return y;
            }            
            
            public int getWall() {
                return wall;
            }
            
            @Override
            public int compareTo(Field t) {
                if (t.distance > this.distance) {
                    return -1;
                } else if (t.distance < this.distance) {
                    return 1;
                } else {
                    return 0;
                }
            }
            
            @Override
            public boolean equals(Object o) {
                System.out.println("Test");
                Field f = (Field) o;                                
                return f.getX() == this.x && f.getY() == this.y && f.getWall() == this.wall && f.previous.x == this.previous.x && f.previous.y == this.previous.y;
            }
            
            public Field getLeftNeighbor() {
                if (x == 0 || (previous != null && previous.getX() == x - 1) || (maze[x - 1][y] == 1 && (previous != null && previous.getWall() == 1))) {
                    return null;
                }
                return new Field(x - 1, y, this);
            }

            public Field getRightNeighbor() {
                if (x == mazeX || (previous != null && previous.getX() == x + 1) || (maze[x + 1][y] == 1 && (previous != null && previous.getWall() == 1))) {
                    return null;
                }
                return new Field(x + 1, y, this);
            }
            
            public Field getUpperNeighbor() {
                if (y == 0 || (previous != null && previous.getY() == y - 1) || (maze[x][y - 1] == 1 && (previous != null && previous.getWall() == 1))) {
                    return null;
                }
                return new Field(x, y - 1, this);
            }
            
            public Field getLowerNeighbor() {
                if (y == mazeY || (previous != null && previous.getY() == y + 1) || (maze[x][y + 1] == 1 && (previous != null && previous.getWall() == 1))) {
                    return null;
                }
                return new Field(x, y + 1, this);
            }

            @Override
            public String toString() {
                if (this.previous == null) {
                    return (this.getX() + " " + this.getY() + " " + this.getWall() + " " + null + " " + null);
                }
                return (this.getX() + " " + this.getY() + " " + this.getWall() + " " + this.previous.x  + " " + this.previous.y);
            }
            
            
            
        }

        Set<String> fields = new HashSet<>();
        
        PriorityQueue<Field> pq = new PriorityQueue<>();
        pq.add(new Field(0, 0, null));
        
        while (!pq.isEmpty()) {
            Field f = pq.poll();
            int x = f.getX();
            int y = f.getY();
            
            if (x == mazeX && y == mazeY) {
                return f.pathLength;
            }
            
            Field leftNeighbor = f.getLeftNeighbor();
            if (leftNeighbor != null && !fields.contains(leftNeighbor.toString())) {
                fields.add(leftNeighbor.toString());
                pq.add(leftNeighbor);
            }
            
            Field rightNeighbor = f.getRightNeighbor();
            if (rightNeighbor != null && !fields.contains(rightNeighbor.toString())) {
                fields.add(rightNeighbor.toString());
                pq.add(rightNeighbor);
            }
            
            Field upperNeighbor = f.getUpperNeighbor();
            if (upperNeighbor != null && !fields.contains(upperNeighbor.toString())) {
                fields.add(upperNeighbor.toString());
                pq.add(upperNeighbor);
            }
            
            Field lowerNeighbor = f.getLowerNeighbor();
            if (lowerNeighbor != null && !fields.contains(lowerNeighbor.toString())) {
                fields.add(lowerNeighbor.toString());
                pq.add(lowerNeighbor);
            }
        }
        
        return 0;
    }
 
    
    public static void main(String[] args) {
        
        int[][] maze = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}};
        System.out.println(answer(maze));
        
        
    }
}
