package Main;

import java.lang.Math;
import java.sql.SQLOutput;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Decide {

    public enum operators {
        NOTUSED,
        ANDD,
        ORR
    }

    //  The number of planar data points.
    public static int NUMPOINTS;

    //Array containing the coordinates of data points
    public static Point[] points;

    // Class holding parameters for LIC’s
    public static Parameters_T parameters;

    // Logical Connector Matrix.
    public static operators[][] LCM;

    // Preliminary Unlocking Vector
    public static boolean[] PUV;

    // Conditions Met Vector
    public static boolean[] CMV;

    // Preliminary Unlocking Matrix
    public static boolean[][] PUM;

    //Final Unlocking Vector.
    public static boolean[] FUV;

    public static boolean decide(){
        return false;
    }

    public static boolean lic_0(){
        double max_distance = -1;
        double distance = -1;
        for (int i = 0; i < (points.length-1); i++){
            distance = Math.sqrt(Math.pow((points[i+1].x-points[i].x),2)+Math.pow((points[i+1].y-points[i].y),2));
            if(distance > max_distance){
                max_distance = distance;
            }
        }
        return max_distance > parameters.LENGTH1;
    }
    public static boolean lic_1(){
        return false;
    }
    public static boolean lic_2(){
        return false;
    }
    public static boolean lic_3(){
        return false;
    }
    public static boolean lic_4(){
        LinkedList<Integer> quadrants = new LinkedList<>(); // List of QPTS consecutive quadrants / data points

        for (Point point : points) {
            int quadrant = getQuadrant(point);

            quadrants.addLast(quadrant);

            if (quadrants.size() == parameters.QPTS) {
                int[] quadUsed = {0, 0, 0, 0};
                int numUsedQuadrants = 0;

                for (int i = 0; i < parameters.QPTS; i++) {
                    quadUsed[quadrants.get(i)-1] = 1; // Set used quadrants
                }

                for (int j : quadUsed) {
                    numUsedQuadrants += j; // j is 0 if quadrant is not used, 1 if used
                }

                if (numUsedQuadrants > parameters.QUADS) {
                    return true;
                }
                else {
                    quadrants.removeFirst();
                }
            }

        }

        return false;
    }

    // Used in lic_4()
    private static int getQuadrant(Point p){
        if (p.y >= 0) {
            if (p.x >= 0) {
                return 1; // Quadrant 1
            }
            else {
                return 2; // Quadrant 2
            }
        }
        else {
            if (p.x <= 0) {
                return 3; // Quadrant 3
            }
            else {
                return 4; // Quadrant 4
            }
        }
    }
    public static boolean lic_5(){
        return false;
    }
    public static boolean lic_6(){
        if(NUMPOINTS<3){
            return false;
        }
        double distance = -1;
        for(int i = 0; i < NUMPOINTS-parameters.NPTS+1; i++){
            Point p1 = points[i];
            Point p2 = points[i+parameters.NPTS-1];

            for(int j = i; j < i+parameters.NPTS-1; j++){
                Point p0 = points[j];
                distance = Math.abs((p2.x-p1.x)*(p1.y-p0.y)-(p1.x-p0.x)*(p2.y-p1.y));
                distance = distance/Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
                if(distance > parameters.DIST){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean lic_7(){
        if(NUMPOINTS < 3){
            return false;
        }
        double distance = -1;
        for(int i = 0; i < NUMPOINTS-parameters.KPTS-1; i++){
            Point p1 = points[i];
            Point p2 = points[i+parameters.KPTS+1];
            distance = Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
            if(distance > parameters.LENGTH1){
                return true;
            }
        }
        return false;
    }
    public static boolean lic_8(){
        return false;
    }
    public static boolean lic_9(){
        return false;
    }
    public static boolean lic_10(){
        return false;
    }
    public static boolean lic_11(){
        return false;
    }
    public static boolean lic_12(){
        return false;
    }
    public static boolean lic_13(){
        return false;
    }
    public static boolean lic_14(){

        if(NUMPOINTS < 5)
            return false;

        boolean area1check = false;
        boolean area2check = false;

        for(int i = 0; i+2 < points.length-parameters.EPTS-parameters.FPTS; i++){

            // 3 vertices from points
            Point p1 = points[i];
            Point p2 = points[i+parameters.EPTS+1];
            Point p3 = points[i+parameters.EPTS+parameters.FPTS+2];

            // Area of triangle given 3 vertices
            double area = 0.5*Math.abs(p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y));

            if(area > parameters.AREA1){
                area1check = true;
            }
            if(area < parameters.AREA2){
                area2check = true;
            }
        }

        return area1check & area2check;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        boolean result = decide();
        System.out.println(result);
    }
}