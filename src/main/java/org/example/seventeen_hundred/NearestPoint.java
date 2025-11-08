package org.example.seventeen_hundred;

/**
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/description/
 */
public class NearestPoint {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int soln = -1;
        double minDistance = Double.MAX_VALUE;

        for(int i =0; i< points.length; i++) {
            if(points[i][0] == x || points[i][1] == y) {
                double distance = calculateDistance(x,y,points[i][0],points[i][1]);
                if(distance < minDistance) {
                    minDistance = distance;
                    soln = i;
                }
            }
        }
        return soln;
    }

    double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
    }
}
