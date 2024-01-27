import Main.Decide;
import Main.Parameters_T;
import Main.Point;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecideTest {


    @Test
    void decide() {
        fail("Not implemented");
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
    void lic_1() {
        fail("Not implemented");
    }

    @Test
    void lic_2() {
        fail("Not implemented");
    }

    @Test
    void lic_3() {
        fail("Not implemented");
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
    void lic_5() {
        fail("Not implemented");
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
    void lic_8() {
        fail("Not implemented");
    }

    @Test
    void lic_9() {
        fail("Not implemented");
    }

    @Test
    void lic_10() {
        fail("Not implemented");
    }

    @Test
    void lic_11() {
        fail("Not implemented");
    }

    @Test
    void lic_12() {
        fail("Not implemented");
    }

    @Test
    void lic_13() {
        fail("Not implemented");
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