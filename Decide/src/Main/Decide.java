package Main;

import java.lang.Math;

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
        return false;
    }
    public static boolean lic_5(){
        return false;
    }
    public static boolean lic_6(){
        return false;
    }
    public static boolean lic_7(){
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
        return false;
    }


    public static void main(String[] args) {
        System.out.println("Hello world!");
        boolean result = decide();
        System.out.println(result);
    }
}