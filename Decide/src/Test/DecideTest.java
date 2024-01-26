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
    void lic_6() {
    }

    @org.junit.jupiter.api.Test
    void lic_7() {
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
    void lic_12() {
    }

    @org.junit.jupiter.api.Test
    void lic_13() {
    }

    @org.junit.jupiter.api.Test
    void lic_14() {
    }
}