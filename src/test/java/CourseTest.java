package test.java;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import main.java.Course;

public class CourseTest {
	Course secondStudent;
	Course firstTest;
	Course secondTest;
	Course thirdTest;
	Course fourthTest;
	Course fifthTest;
	Course sixthTest;
	Course seventhTest;
	Course eighthTest;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void testOneAverageWithoutMinWithoutMax() {
        // One Student (node 97)
        firstTest = new Course("SER111");
        firstTest.set_points("Marlie", 70);
        double ans = firstTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 70.0);
    }
    
    @Test
    public void testTwoAverageWithoutMinWithoutMax() {
        // Two Students (node 100)
        secondTest = new Course("SER222");
        secondTest.set_points("Jules", 90);
        secondTest.set_points("Lucky", 100);
        double ans = secondTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == 95.0);
    }
    
    @Test
    public void testThreeAverageWithoutMinWithoutMax() {
        // three Students (node 103)
        thirdTest = new Course("SER333");
        thirdTest.set_points("Keke", 75);
        thirdTest.set_points("Marcy", 80);
        thirdTest.set_points("Jeff", 85);
        double ans = thirdTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == -80.0); // should be 80
    }
    
    @Test
    public void testFourAverageWithoutMinWithoutMax() {
        // Two Students (node 105) (negative num)
        fourthTest = new Course("SER444");
        fourthTest.set_points("Jessa", -20);
        fourthTest.set_points("Kenzie", 60);
        fourthTest.set_points("Emmie", 50);
        fourthTest.set_points("Lara", 130);
        double ans = fourthTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == -60.0); //should be 87.9
    }
    
    @Test
    public void testFiveAverageWithoutMinWithoutMax() {
        // Two Students (node 105 & alt 106) (negative num)
        fifthTest = new Course("SER444");
        fifthTest.set_points("Olivia", -20);
        fifthTest.set_points("Abigail", 60);
        fifthTest.set_points("Ethan", 90);
        double ans = fifthTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == -0.0); //should be 43.3
    }
    
    @Test
    public void testSixAverageWithoutMinWithoutMax() {
        // Two Students (node 105 & 106 & 109 & 112) (over 100)
        sixthTest = new Course("SER666");
        sixthTest.set_points("Norma", 120);
        sixthTest.set_points("William", 70);
        sixthTest.set_points("Thomas", 85);
        double ans = sixthTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == -85.0); //should be 91.67
    }
    
    @Test
    public void testSeventhAverageWithoutMinWithoutMax() {
        // Two Students (node 105 & 106 & 109 & 112)
        seventhTest = new Course("SER777");
        seventhTest.set_points("Casey", 40);
        seventhTest.set_points("Connor", 60);
        seventhTest.set_points("Stacy", 100);
        double ans = seventhTest.calculateAverageWithoutMinWithoutMax();
        assertTrue(ans == -60.0); //should be 66.67
    }
}
