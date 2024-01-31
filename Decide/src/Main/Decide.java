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

    public static final double PI = 3.1415926535;

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


    // Calculates the CMV with the use of LIC-requirements
    public static boolean[] setCMV(){
        CMV = new boolean[15];
        CMV[0] = lic_0();
        CMV[1] = lic_1();
        CMV[2] = lic_2();
        CMV[3] = lic_3();
        CMV[4] = lic_4();
        CMV[5] = lic_5();
        CMV[6] = lic_6();
        CMV[7] = lic_7();
        CMV[8] = lic_8();
        CMV[9] = lic_9();
        CMV[10] = lic_10();
        CMV[11] = lic_11();
        CMV[12] = lic_12();
        CMV[13] = lic_13();
        CMV[14] = lic_14();

        return CMV;
    }

    /*
    - The PUM is set using the CMV and LCM
    - By applying the boolean operator from the LCM to the requirements in CMV we get the PUM
     */
    public static boolean[][] setPUM(){

        PUM = new boolean[15][15];
        for(int i = 0; i <= 14; i++){
            for(int j = 0; j <= 14; j++){
                // Note that the diagonal is filled in too, which needs to be disregarded when calculating the FUV
                switch(LCM[i][j]){
                    case ANDD:
                        PUM[i][j] = CMV[i] && CMV[j];
                        break;
                    case ORR:
                        PUM[i][j] = CMV[i] || CMV[j];
                        break;
                    case NOTUSED:
                        PUM[i][j] = true;
                        break;
                }
            }
        }
        return PUM;
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
    public static boolean lic_1()
      if (xpoints.length <3)
        return false;
      if (xpoints.length !=ypoints.length || radius1 <0)
          return false;

      for (int i=0; i< xpoints.length -2; i++){
          boolean result = helperCircle (xpoints[i], ypoints[i], xpoints[i+1], ypoints[i+1], xpoints[i+2], ypoints[i+2], radius1);
          if(result)
              return false;
      }
      return true;
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
    public static int getQuadrant(Point p){
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
        for(int i = 0; i+1 < points.length; i++){

            // 2 consecutive points
            Point p1 = points[i];
            Point p2 = points[i+1];

            // difference in x-axis between second and first point
            double diff = p2.x-p1.x;

            if(diff < 0){
                return true;
            }
        }
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
        if (NUMPOINTS < 5){
            return false;
        }

        for (int i = 0; i < points.length - parameters.APTS - parameters.BPTS - 2; i++) {
            Point point1 = points[i];
            Point point2 = points[i + 1 + parameters.APTS];
            Point point3 = points[i + 2 + parameters.APTS + parameters.BPTS];

            // side lengths
            double a = distance(point1, point2);
            double b = distance(point2, point3);
            double c = distance(point3, point1);

            // if points are collinear
            if ((point2.y - point1.y) / (point2.x - point1.x) == ((point3.y - point2.y) / (point3.x - point2.x))){
                return a > parameters.RADIUS1 * 2 || b > parameters.RADIUS1 * 2 || c > parameters.RADIUS1 * 2;
            }

            double s = (a + b + c) / 2; // semiperimeter
            double circumradius = (a * b * c) / (4.0 * Math.sqrt(s * (a+b-s) * (a+c-s) * (b+c-s)));

            if (circumradius > parameters.RADIUS1){
                return true;
            }

        }
        return false;
    }

    public static double distance(Point a, Point b){
        return Math.sqrt((b.x-a.x) * (b.x-a.x) + (b.y-a.y) * (b.y-a.y));
    }

    public static boolean lic_9(){
        if (NUMPOINTS < 5){
            return false;
        }

        for (int i = 0; i < points.length - parameters.CPTS - parameters.DPTS - 2; i++) {
            Point point1 = points[i];
            Point point2 = points[i + 1 + parameters.CPTS]; // vertex of the angle
            Point point3 = points[i + 2 + parameters.CPTS + parameters.DPTS];

            double a = distance(point1, point2);
            double b = distance(point2, point3);
            double c = distance(point3, point1);

            // If either the first point or the last point (or both) coincide with the vertex,
            // the angle is undefined and the LIC is not satisfied by those three points.
            if(a == 0 || b == 0){
                return false;
            }

            // Calculate angle at point2
            double angle = Math.toDegrees(Math.acos((a*a + b*b - c*c) / (2*a*b)));

            if (angle < (PI-parameters.EPSILON) || angle > PI+parameters.EPSILON){
                return true;
            }
        }
        return false;
    }
  
    public static boolean lic_10(){
        if(NUMPOINTS < 5)
            return false;

        boolean area1check = false;

        for(int i = 0; i+2 < points.length-parameters.EPTS-parameters.FPTS; i++){

            // 3 vertices from points
            Point p1 = points[i];
            Point p2 = points[i+parameters.EPTS+1];
            Point p3 = points[i+parameters.EPTS+parameters.FPTS+2];

            // Area of triangle given 3 vertices
            double area = 0.5*Math.abs(p1.x*(p2.y-p3.y)+p2.x*(p3.y-p1.y)+p3.x*(p1.y-p2.y));

            if(area > parameters.AREA1){
                return true;
            }
        }

        return false;
    }
    public static boolean lic_11(){
        if (NUMPOINTS < 3){
            return false;
        }

        for (int i = 0; i < points.length - parameters.GPTS - 1; i++) {
            Point point1 = points[i];                       // (X[i],Y[i])
            Point point2 = points[i + 1 + parameters.GPTS]; // (X[j],Y[j])

            if (point2.x - point1.x < 0){                   // X[j] - X[i] < 0 (where i < j)
                return true;
            }
        }
        return false;
    }
    public static boolean lic_12(){
        //Same as LIC7, except an additional requirement?
        if(NUMPOINTS < 3){
            return false;
        }
        double distance = -1;
        boolean dist1 = false;
        boolean dist2 = false;
        for(int i = 0; i < NUMPOINTS-parameters.KPTS-1; i++){
            Point p1 = points[i];
            Point p2 = points[i+parameters.KPTS+1];
            distance = Math.sqrt(Math.pow((p2.x-p1.x),2)+Math.pow((p2.y-p1.y),2));
            if(distance > parameters.LENGTH1){
                dist1 = true;
            }
            if(distance < parameters.LENGTH2){
                dist2 = true;
            }
        }
        return dist1 & dist2;
    }
    public static boolean lic_13(){
        boolean condition1 = lic_8();

        if (NUMPOINTS < 5){
            return false;
        }

        for (int i = 0; i < points.length - parameters.APTS - parameters.BPTS - 2; i++) {
            Point point1 = points[i];
            Point point2 = points[i + 1 + parameters.APTS];
            Point point3 = points[i + 2 + parameters.APTS + parameters.BPTS];

            // side lengths
            double a = distance(point1, point2);
            double b = distance(point2, point3);
            double c = distance(point3, point1);

            // if points are collinear
            if ((point2.y - point1.y) / (point2.x - point1.x) == ((point3.y - point2.y) / (point3.x - point2.x))){
                return a <= parameters.RADIUS2 * 2 && b <= parameters.RADIUS2 * 2 && c <= parameters.RADIUS2 * 2 && condition1;
            }

            double s = (a + b + c) / 2; // semiperimeter
            double circumradius = (a * b * c) / (4.0 * Math.sqrt(s * (a+b-s) * (a+c-s) * (b+c-s)));

            if (circumradius <= parameters.RADIUS2){
                return condition1;
            }

        }
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
