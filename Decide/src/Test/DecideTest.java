import Main.Decide;
import Main.Parameters_T;
import Main.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {

    public enum operators {
        NOTUSED,
        ANDD,
        ORR
    }

    @Test
    void decide_true() {

        // Set up initial points
        Decide.points = new Point[]{
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 3),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        };

        // Set up parameters
        Decide.parameters = new Parameters_T();
        Decide.NUMPOINTS = Decide.points.length;

        Decide.parameters.EPSILON = 1.2;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.CPTS = 2;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 1;
        Decide.parameters.GPTS = 1;
        Decide.parameters.AREA1 = 1;
        Decide.parameters.AREA2 = 1;
        Decide.parameters.RADIUS1 = 1;
        Decide.parameters.RADIUS2 = 2;
        Decide.parameters.QUADS = 2;
        Decide.parameters.QPTS = 2;
        Decide.parameters.LENGTH1 = 1;
        Decide.parameters.LENGTH2 = 2;
        Decide.parameters.KPTS = 1;
        Decide.parameters.DIST = 1;
        Decide.parameters.NPTS = 3;

        // Set up LCM

        Decide.operators[][] LCM = new Decide.operators[15][15];

        for(int i = 0; i <= 14; i++){
            for(int j = 0; j <= 14; j++){
                LCM[i][j] = Decide.operators.NOTUSED;
            }
        }
        LCM[0][1] = Decide.operators.ANDD; // LIC 0 and 1 must be true
        Decide.LCM = LCM;

        // Set up PUV
        boolean[] PUV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            PUV[i] = false;
        }
        PUV[1] = true;
        PUV[5] = true;
        Decide.PUV =  PUV;

        assertTrue(Decide.decide());

    }

    @Test
    void decide_false() {

        // Set up initial points
        Decide.points = new Point[]{
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 3),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        };

        // Set up parameters
        Decide.parameters = new Parameters_T();
        Decide.NUMPOINTS = Decide.points.length;

        Decide.parameters.EPSILON = 1.2;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.CPTS = 2;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 3;
        Decide.parameters.GPTS = 4;
        Decide.parameters.AREA1 = 1;
        Decide.parameters.AREA2 = 1;
        Decide.parameters.RADIUS1 = 1;
        Decide.parameters.RADIUS2 = 2;
        Decide.parameters.QUADS = 2;
        Decide.parameters.QPTS = 2;
        Decide.parameters.LENGTH1 = 1;
        Decide.parameters.LENGTH2 = 2;
        Decide.parameters.KPTS = 1;
        Decide.parameters.DIST = 1;
        Decide.parameters.NPTS = 3;

        // Set up LCM

        Decide.operators[][] LCM = new Decide.operators[15][15];

        for(int i = 0; i <= 14; i++){
            for(int j = 0; j <= 14; j++){
                LCM[i][j] = Decide.operators.ANDD;
            }
        }
        LCM[0][1] = Decide.operators.ANDD; // LIC 0 and 1 must be true
        LCM[2][3] = Decide.operators.ANDD;
        Decide.LCM = LCM;

        // Set up PUV
        boolean[] PUV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            PUV[i] = true;
        }
        Decide.PUV =  PUV;

        assertFalse(Decide.decide());

    }

    @Test
    void setCMV() {
        Decide.points = new Point[]{
                new Point(0, 0),
                new Point(0, 2),
                new Point(2, 3),
                new Point(1, 0),
                new Point(1, 1),
                new Point(0, 1)
        };

        Decide.parameters = new Parameters_T();
        Decide.NUMPOINTS = Decide.points.length;

        Decide.parameters.EPSILON = 1.2;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.CPTS = 2;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 1;
        Decide.parameters.GPTS = 1;
        Decide.parameters.AREA1 = 1;
        Decide.parameters.AREA2 = 1;
        Decide.parameters.RADIUS1 = 1;
        Decide.parameters.RADIUS2 = 2;
        Decide.parameters.QUADS = 2;
        Decide.parameters.QPTS = 2;
        Decide.parameters.LENGTH1 = 1;
        Decide.parameters.LENGTH2 = 2;
        Decide.parameters.KPTS = 1;
        Decide.parameters.DIST = 1;
        Decide.parameters.NPTS = 3;

        // Set CMV
        Decide.setCMV();

        // Check that every element in the CMV is correctly set
        assertEquals(Decide.CMV[0], Decide.lic_0());
        assertEquals(Decide.CMV[1], Decide.lic_1());
        assertEquals(Decide.CMV[2], Decide.lic_2());
        assertEquals(Decide.CMV[3], Decide.lic_3());
        assertEquals(Decide.CMV[4], Decide.lic_4());
        assertEquals(Decide.CMV[5], Decide.lic_5());
        assertEquals(Decide.CMV[6], Decide.lic_6());
        assertEquals(Decide.CMV[7], Decide.lic_7());
        assertEquals(Decide.CMV[8], Decide.lic_8());
        assertEquals(Decide.CMV[9], Decide.lic_9());
        assertEquals(Decide.CMV[10], Decide.lic_10());
        assertEquals(Decide.CMV[11], Decide.lic_11());
        assertEquals(Decide.CMV[12], Decide.lic_12());
        assertEquals(Decide.CMV[13], Decide.lic_13());
        assertEquals(Decide.CMV[14], Decide.lic_14());
    }

    // Tests the PUM based on the input data for LCM and CMV from the assignment
    @Test
    void setPUM() {
        // Set up the LCM
        Decide.operators[][] LCM = new Decide.operators[15][15];
        LCM[0][0] = Decide.operators.ANDD;
        LCM[0][1] = Decide.operators.ANDD;
        LCM[0][2] = Decide.operators.ORR;
        LCM[0][3] = Decide.operators.ANDD;

        LCM[1][0] = Decide.operators.ANDD;
        LCM[1][2] = Decide.operators.ORR;
        LCM[1][3] = Decide.operators.ORR;
        LCM[1][4] = Decide.operators.ANDD;

        LCM[2][0] = Decide.operators.ORR;
        LCM[2][2] = Decide.operators.ORR;
        LCM[2][3] = Decide.operators.ANDD;
        LCM[2][4] = Decide.operators.ANDD;

        LCM[3][0] = Decide.operators.ANDD;
        LCM[3][2] = Decide.operators.ORR;
        LCM[3][3] = Decide.operators.ANDD;
        LCM[3][4] = Decide.operators.ANDD;

        for(int i = 0; i <= 14; i++){
            for(int j = 0; j <= 14; j++){
                if(LCM[i][j] == null){
                    LCM[i][j] = Decide.operators.NOTUSED;
                }
            }
        }
        Decide.LCM = LCM;

        // Set up CMV
        boolean[] CMV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            CMV[i] = false;
        }
        CMV[1] = true;
        CMV[2] = true;
        CMV[3] = true;
        Decide.CMV = CMV;

        boolean[][] PUM = Decide.setPUM();
        // Sample
        assertFalse(PUM[0][1]);
        assertTrue(PUM[0][2]);
        assertFalse(PUM[0][3]);
        assertTrue(PUM[0][4]);

        assertFalse(PUM[1][0]);
        assertTrue(PUM[1][2]);
        assertTrue(PUM[1][3]);
    }

    @Test
    void setFUV() {
        // Setup PUM
        boolean[][] PUM = new boolean[15][15];
        for(int i = 0; i <= 14; i++){
            for(int j = 0; j <= 14; j++){
                PUM[i][j] = true;
            }
        }
        PUM[0][1] = false;
        PUM[0][3] = false;
        PUM[1][0] = false;
        PUM[3][0] = false;

        Decide.PUM = PUM;

        // Set up PUV according to 2.3 in the assignment
        boolean[] PUV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            PUV[i] = true;
        }
        PUV[1] = false;
        Decide.PUV =  PUV;

        // Create the FUV
        boolean[] FUV = Decide.setFUV();

        // Ensure that the result matches table 4 in the assignment
        assertFalse(FUV[0]);
        assertTrue(FUV[1]);
        assertTrue(FUV[2]);
    }

    @Test
    void launch_true(){
        boolean[] FUV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            FUV[i] = true;
        }
        Decide.FUV = FUV;
        assertTrue(Decide.launch());
    }

    @Test
    void launch_false(){
        boolean[] FUV = new boolean[15];
        for(int i = 0; i <= 14; i++){
            FUV[i] = true;
        }
        FUV[2] = false;
        Decide.FUV = FUV;
        assertFalse(Decide.launch());
    }

    @Test
    void lic_0() {
        Decide.parameters = new Parameters_T();
        Point p1 = new Point(1,1);
        Point p2 = new Point(3,3);
        Point[] list = {p1,p2};
        Decide.parameters.LENGTH1 = 1;
        Decide.points = list;
        Decide.NUMPOINTS = 2;

        boolean decision = Decide.lic_0();

        assertTrue(decision);
    }

    @Test
    void lic_1_true() {
        Decide.parameters = new Parameters_T();
        // Set up points which may be contained in the smallest circle with radius r = sqrt(2)/2
        Decide.points = new Point[]{
                new Point(0, 0),
                new Point(1, 0),
                new Point(0, 1)
        };
        Decide.parameters.RADIUS1 = 0.7;
        assertTrue(Decide.lic_1());
    }

    @Test
    void lic_1_false() {
        Decide.parameters = new Parameters_T();
        // Set up points which may be contained in the smallest circle with radius r = sqrt(2)
        Decide.points = new Point[]{
                new Point(0, 0),
                new Point(2, 0),
                new Point(0, 2)
        };
        Decide.parameters.RADIUS1 = 1.42;
        assertFalse(Decide.lic_1());
    }

    @Test
    void lic_2_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(1, 1),
                new Point(5, 5),
                new Point(0, 2)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        Decide.parameters.CPTS = 1;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPSILON = 2.8;

        assertTrue(Decide.lic_2());
    }

    @Test
    void lic_2_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(1, 1),
                new Point(5, 5),
                new Point(0, 2)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        Decide.parameters.CPTS = 1;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPSILON = 3.2;

        assertFalse(Decide.lic_2());
    }

    @Test
    void lic_3_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(6, 8)
        };
        //Gives two triangles, one with area 2.5 and the other with area 3.5
        Decide.parameters.AREA1 = 3.2;

        Decide.points = points;
        Decide.NUMPOINTS = 4;

        boolean decision = Decide.lic_3();

        assertTrue(decision);
    }

    @Test
    void lic_3_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(2, 1),
                new Point(4, 4),
                new Point(-2, 3)
        };

        //Gives a triangle with area 8
        Decide.parameters.AREA1 = 9;

        Decide.points = points;
        Decide.NUMPOINTS = 3;

        boolean decision = Decide.lic_3();

        assertFalse(decision);
    }

    @Test
    void lic_4_true() {
        Decide.parameters = new Parameters_T();
        Decide.points = new Point[]{
                new Point(1, 1), // Quadrant 1 (could be any point)
                new Point(0, 0), // Quadrant 1
                new Point(-1, 0), // Quadrant 2
                new Point(0, -1), // Quadrant 3
                new Point(1, -1) // Quadrant 4
        };
        Decide.parameters.QPTS = 4;
        Decide.parameters.QUADS = 3;
        assertTrue(Decide.lic_4()); // There exists at least one set of QPTS consecutive data points that lie in more than QUADS quadrants.
    }

    @Test
    void lic_4_false() {
        Decide.parameters = new Parameters_T();
        Decide.points = new Point[]{
                new Point(1, 1), // Quadrant 1
                new Point(0, 0), // Quadrant 1
                new Point(0.5, 2.6), // Quadrant 1
                new Point(-1, -1), // Quadrant 3
                new Point(0.5, -0.5) // Quadrant 4
        };
        Decide.parameters.QPTS = 4;
        Decide.parameters.QUADS = 3;
        assertFalse(Decide.lic_4());
    }

    @Test
    void getQuadrant() {
        Point p = new Point(-2,4); // Point in 2nd quadrant
        assertEquals(Decide.getQuadrant(p), 2);
    }

    @Test
    void lic_5_true() {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(2,0)
        };

        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        assertTrue(Decide.lic_5());
    }

    @Test
    void lic_5_false() {
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(7,0)
        };

        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        assertFalse(Decide.lic_5());
    }

    @Test
    void lic_6_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 4),
                new Point(0, 2)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.NPTS = 3;
        Decide.parameters.DIST = 2.9;
        assertTrue(Decide.lic_6());
    }

    @Test
    void lic_6_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(4, 0),
                new Point(4, 4)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.NPTS = 3;
        Decide.parameters.DIST = 2.9;
        assertFalse(Decide.lic_6());
    }

    @Test
    void lic_7_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(2,0),
                new Point(2,0)
        };

        Decide.parameters.KPTS = 2;

        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.LENGTH1 = 1.7;

        assertTrue(Decide.lic_7());
    }

    @Test
    void lic_7_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(2,0),
                new Point(2,2)
        };

        Decide.parameters.KPTS = 3;

        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.LENGTH1 = 3;

        assertFalse(Decide.lic_7());
    }

    @Test
    void lic_8_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0), // Point a
                new Point(0, 0.5),
                new Point(0, 1), // Point b
                new Point(0.5,0),
                new Point(1,1)  // Point c
        };
        Decide.points = points;

        Decide.NUMPOINTS = points.length;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.RADIUS1 = 0.7;

        assertTrue(Decide.lic_8());
    }

    @Test
    void lic_8_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0.1, 0),
                new Point(0, 0),
                new Point(0, 0.1),
                new Point(0, 1),
                new Point(0,0.2),
                new Point(0,2),
                new Point(0,0.3)
        };
        Decide.points = points;

        Decide.NUMPOINTS = points.length;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.RADIUS1 = 1;

        assertFalse(Decide.lic_8());
    }

    @Test
    void distance() {
        Point a = new Point(2,4);
        Point b = new Point(-1,4);
        assertEquals(Decide.distance(a,b), 3);
    }

    @Test
    void lic_9_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(1, 1),
                new Point(5, 5),
                new Point(0, 2),
                new Point(7, 7),
                new Point(1, 0)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        Decide.parameters.CPTS = 1;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPSILON = 14;

        assertTrue(Decide.lic_9());
    }

    @Test
    void lic_9_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(5, 5),
                new Point(0, 2),
                new Point(7, 7),
                new Point(1, 0)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;

        Decide.parameters.CPTS = 1;
        Decide.parameters.DPTS = 1;
        Decide.parameters.EPSILON = 42;

        assertFalse(Decide.lic_9());
    }

    @Test
    void lic_10_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(6, 8),
                new Point(2, 1),
                new Point(4, 4),
                new Point(-2, 3)
        };
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 1;

        Decide.parameters.AREA1 = 10;

        Decide.points = points;
        Decide.NUMPOINTS = 7;

        boolean decision = Decide.lic_10();

        assertTrue(decision);
    }

    @Test
    void lic_10_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(6, 8),
                new Point(2, 1),
                new Point(4, 4),
                new Point(-2, 3)
        };
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 1;

        Decide.parameters.AREA1 = 12;

        Decide.points = points;
        Decide.NUMPOINTS = 7;

        boolean decision = Decide.lic_10();

        assertFalse(decision);
    }

    @Test
    void lic_11_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(1, 0),
                new Point(5, 0), // Point A
                new Point(3, 5),
                new Point(5, 2),
                new Point(4, 8)  // Point B
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.GPTS = 2;

        assertTrue(Decide.lic_11());
    }

    @Test
    void lic_11_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(1, 0),
                new Point(5, 0),
                new Point(3, 5),
                new Point(5, 2),
                new Point(5, 8)
        };
        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.GPTS = 2;

        assertFalse(Decide.lic_11());
    }

    @Test
    void lic_12_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(1.5,0),
                new Point(2,2)
        };

        Decide.parameters.KPTS = 2;

        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.LENGTH1 = 2.2;
        Decide.parameters.LENGTH2 = 1.6;

        assertTrue(Decide.lic_12());
    }

    @Test
    void lic_12_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(1.5,0),
                new Point(2,2)
        };

        Decide.parameters.KPTS = 2;

        Decide.points = points;
        Decide.NUMPOINTS = points.length;
        Decide.parameters.LENGTH1 = 2.3;
        Decide.parameters.LENGTH2 = 2.2;

        assertFalse(Decide.lic_12());
    }

    @Test
    void lic_13_true() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0), // Point a
                new Point(0, 0.5),
                new Point(0, 1), // Point b
                new Point(0.5,0),
                new Point(1,1)  // Point c
        };
        Decide.points = points;

        Decide.NUMPOINTS = points.length;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.RADIUS1 = 0.5;
        Decide.parameters.RADIUS2 = 3;

        assertTrue(Decide.lic_13());
    }

    @Test
    void lic_13_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0), // Point a
                new Point(0, 0.5),
                new Point(0, 1), // Point b
                new Point(0.5,0),
                new Point(1,1)  // Point c
        };
        Decide.points = points;

        Decide.NUMPOINTS = points.length;
        Decide.parameters.APTS = 1;
        Decide.parameters.BPTS = 1;
        Decide.parameters.RADIUS1 = 0.5;
        Decide.parameters.RADIUS2 = 0.7;

        assertFalse(Decide.lic_13());
    }

    @Test
    void lic_14_true() {
        //Assert true
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(6, 8),
                new Point(2, 1),
                new Point(4, 4),
                new Point(-2, 3)
        };
        Decide.parameters.EPTS = 1;
        Decide.parameters.FPTS = 1;

        Decide.parameters.AREA1 = 0.2;
        Decide.parameters.AREA2 = 4;

        Decide.points = points;
        Decide.NUMPOINTS = 7;

        boolean decision = Decide.lic_14();

        assertTrue(decision);
    }
  
    @Test
    void lic_14_false() {
        Decide.parameters = new Parameters_T();
        Point[] points = {
                new Point(0, 0),
                new Point(1, 0),
                new Point(5, 5),
                new Point(6, 8),
                new Point(2, 1),
                new Point(4, 4),
                new Point(-2, 3)
        };
        //Gives a triangle with area 17
        Decide.parameters.EPTS = 2;
        Decide.parameters.FPTS = 2;

        Decide.parameters.AREA1 = 18;
        Decide.parameters.AREA2 = 14;

        Decide.points = points;
        Decide.NUMPOINTS = 7;

        boolean decision = Decide.lic_14();

        assertFalse(decision);
    }
}