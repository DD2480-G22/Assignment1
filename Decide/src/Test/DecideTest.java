import Main.Decide;
import Main.Parameters_T;
import Main.Point;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {


    @org.junit.jupiter.api.Test
    void decide() {
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void lic_1() {

    }

    @org.junit.jupiter.api.Test
    void lic_2() {
    }

    @org.junit.jupiter.api.Test
    void lic_3() {
    }

    @org.junit.jupiter.api.Test
    void lic_4() {
    }

    @org.junit.jupiter.api.Test
    void lic_5() {
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void lic_8() {
    }

    @org.junit.jupiter.api.Test
    void lic_9() {
    }

    @org.junit.jupiter.api.Test
    void lic_10() {
    }

    @org.junit.jupiter.api.Test
    void lic_11() {
    }

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
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

    @org.junit.jupiter.api.Test
    void lic_13() {
    }

    @org.junit.jupiter.api.Test
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
    @org.junit.jupiter.api.Test
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