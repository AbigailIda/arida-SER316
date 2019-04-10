package test.java;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.java.Course;
import main.java.CourseGrades1;
import main.java.CourseGrades2;
import main.java.CourseGrades5;
import main.java.CourseGrades4;
import main.java.CourseGrades0;
import main.java.CourseGrades3;

import java.lang.reflect.Constructor;

@RunWith(Parameterized.class)
public class GivenBlackbox {
    private Class<Course> classUnderTest;
    
    
    @SuppressWarnings("unchecked")
    public GivenBlackbox(Object classUnderTest) {
        this.classUnderTest = (Class<Course>) classUnderTest;
    }
    
    // Defining all the classes that need to be tested
    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = { 
                {CourseGrades0.class},
                {CourseGrades1.class},
                {CourseGrades2.class},
                {CourseGrades3.class},
                {CourseGrades4.class},
                {CourseGrades5.class}
        };
        return Arrays.asList(classes);
    }
    
    // method to call the correct constructor
    private Course createCourse(String name) throws Exception {
        Constructor<Course> constructor = classUnderTest.getConstructor(String.class);
        return constructor.newInstance(name);
    }
    

    // A sample course & other test courses
    Course twoStudent;
    Course firstTest;
    Course secondTest;
    Course thirdTest;
    Course fourthTest;
    Course fifthTest;
    Course sixthTest;
    Course seventhTest;
    Course eighthTest;
    
    HashMap<String, Integer> twoStudentExpected = new HashMap<String, Integer>(); 
    HashMap<String, Integer> firstTestExpected = new HashMap<String, Integer>(); 
    HashMap<String, Integer> secondTestExpected = new HashMap<String, Integer>(); 
    HashMap<String, Integer> thirdTestExpected = new HashMap<String, Integer>(); 
    HashMap<String, Integer> fourthTestExpected = new HashMap<String, Integer>();
    HashMap<String, Integer> fifthTestExpected = new HashMap<String, Integer>(); 
    HashMap<String, Integer> sixthTestExpected = new HashMap<String, Integer>();
    HashMap<String, Integer> seventhTestExpected = new HashMap<String, Integer>();
    HashMap<String, Integer> eighthTestExpected = new HashMap<String, Integer>();
    
    @Before
    public void setUp() throws Exception {
        
        // all courses should be created like this
        
        
        // Course created with two Students having
        twoStudent = createCourse("SER316");
        twoStudent.set_points("Hanna",100);
        twoStudent.set_points("Karla",100);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        twoStudentExpected.put("A", 2);
        twoStudentExpected.put("B", 0);
        twoStudentExpected.put("C", 0);
        twoStudentExpected.put("D", 0);
        twoStudentExpected.put("F", 0);
        
        //-------------------------------------------------------------------------------------------------------------
        
        //Course variable for 1st test (scores over 100 - boundary/edge-case test)
        firstTest = createCourse("SER111");
        firstTest.set_points("Betty",101);
        firstTest.set_points("Tara",150); //will be considered max in this case
        firstTest.set_points("cooper", 100);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        firstTestExpected.put("A", 1);
        firstTestExpected.put("B", 2);
        firstTestExpected.put("C", 0);
        firstTestExpected.put("D", 0);
        firstTestExpected.put("F", 0);
        
        //-------------------------------------------------------------------------------------------------------------
        
        //Course variable for 2nd test (negative scores - boundary/edge-case test)
        secondTest = createCourse("SER222");
        secondTest.set_points("Julie",-1);
        secondTest.set_points("Rosetta",10); // will be considered max in this case 
        secondTest.set_points("bloomer",-88);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        secondTestExpected.put("A", 1);
        secondTestExpected.put("B", 0);
        secondTestExpected.put("C", 0);
        secondTestExpected.put("D", 0);
        secondTestExpected.put("F", 2);
        
        //-------------------------------------------------------------------------------------------------------------
        
        //Course variable for 3rd test (lower bound of each grade - boundary/edge-case test)
        thirdTest = createCourse("SER333");
        thirdTest.set_points("max3",100); //represents max
        thirdTest.set_points("Buddy",81);
        thirdTest.set_points("Lucky",66);
        thirdTest.set_points("Julliete",51);
        thirdTest.set_points("Marlie",36);
        thirdTest.set_points("Casey",0);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        thirdTestExpected.put("A", 2);
        thirdTestExpected.put("B", 1);
        thirdTestExpected.put("C", 1);
        thirdTestExpected.put("D", 1);
        thirdTestExpected.put("F", 1);
        
        //-------------------------------------------------------------------------------------------------------------

        //Course variable for 4th test (upper bound of each grade - boundary/edge-case test)
        fourthTest = createCourse("SER444");
        fourthTest.set_points("max4",100); //represents max
        fourthTest.set_points("Bridget",100);
        fourthTest.set_points("Anabella",79);
        fourthTest.set_points("Rocko",65);
        fourthTest.set_points("Connor",49);
        fourthTest.set_points("Joe",35);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        fourthTestExpected.put("A", 2);
        fourthTestExpected.put("B", 1);
        fourthTestExpected.put("C", 1);
        fourthTestExpected.put("D", 1);
        fourthTestExpected.put("F", 1);
        
        //-------------------------------------------------------------------------------------------------------------

        //Course variable for 5th test combined boundaries tests together
        fifthTest = createCourse("SER555");
        fifthTest.set_points("Ethan",101); //too high - this will be considered max therefore not accounting for a perfect score and extra credit. (negativly impacts the score of others if included)
        fifthTest.set_points("Nana",-1); //to low
        fifthTest.set_points("Thomas",81); //lower bound
        fifthTest.set_points("Stacy",66);
        fifthTest.set_points("Emmie",51);
        fifthTest.set_points("Isaac",36);
        fifthTest.set_points("Brenda",0);
        fifthTest.set_points("Olivia",100); //upper bound
        fifthTest.set_points("William",79);
        fifthTest.set_points("Emmie",65);
        fifthTest.set_points("Isaac",49);
        fifthTest.set_points("Brenda",35);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        fifthTestExpected.put("A", 2);
        fifthTestExpected.put("B", 2);
        fifthTestExpected.put("C", 2);
        fifthTestExpected.put("D", 2);
        fifthTestExpected.put("F", 3);
        
        //-------------------------------------------------------------------------------------------------------------

        //Course variable for 6th test (students w/ the same name)
        sixthTest = createCourse("SER666");
        sixthTest.set_points("max6",100); //represents max
        sixthTest.set_points("Abigail",95);
        sixthTest.set_points("Abigail",76);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        sixthTestExpected.put("A", 2);
        sixthTestExpected.put("B", 1);
        sixthTestExpected.put("C", 0);
        sixthTestExpected.put("D", 0);
        sixthTestExpected.put("F", 0);
        
        //-------------------------------------------------------------------------------------------------------------
     
       //Course variable for 7th test (a perfect score w/ EC was added to test if it would lower the scores of other students by changing the max.)
        //how it effects lower bound
        seventhTest = createCourse("SER777");
        seventhTest.set_points("max7",112); //perfect score plus extra credit 
        seventhTest.set_points("Bethany",100);
        seventhTest.set_points("carlos", 70);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        seventhTestExpected.put("A", 2);
        seventhTestExpected.put("B", 0);
        seventhTestExpected.put("C", 1);
        seventhTestExpected.put("D", 0);
        seventhTestExpected.put("F", 0);
        
        //-------------------------------------------------------------------------------------------------------------
        
        //Course variable for 8th test (a perfect score w/ EC was added to test if it would lower the scores of other students by changing the max.)
        //how it effects upper bound
        eighthTest = createCourse("SER888");
        eighthTest.set_points("max8",101); //perfect score plus extra credit 
        eighthTest.set_points("blake",100);
        eighthTest.set_points("charles", 89);
        
        // this would be the expected result after the method countOccurencesLetterGrades is called
        eighthTestExpected.put("A", 3);
        eighthTestExpected.put("B", 0);
        eighthTestExpected.put("C", 0);
        eighthTestExpected.put("D", 0);
        eighthTestExpected.put("F", 0);
    }


    // Sample test
    @Test
    public void twoStudent() {
    	System.out.println("------------------------------------test two student-------------------------");
        HashMap<String, Integer> ans = twoStudent.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(twoStudentExpected));
    }
    
    // first test
    @Test
    public void firstTest() {
    	System.out.println("------------------------------------test 1-------------------------");
        HashMap<String, Integer> ans = firstTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(firstTestExpected));
    }
    
    // second test
    @Test
    public void secondTest() {
    	System.out.println("------------------------------------test 2-------------------------");
        HashMap<String, Integer> ans = secondTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(secondTestExpected));
    }

    // third test
    @Test
    public void thirdTest() {
    	System.out.println("------------------------------------test 3-------------------------");
        HashMap<String, Integer> ans = thirdTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(thirdTestExpected));
    }
    
    // fourth test
    @Test
    public void fourthTest() {
    	System.out.println("------------------------------------test 4-------------------------");
        HashMap<String, Integer> ans = fourthTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(fourthTestExpected));
    }
    
    // fifth test
    @Test
    public void fifthTest() {
    	System.out.println("------------------------------------test 5-------------------------");
        HashMap<String, Integer> ans = fifthTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(fifthTestExpected));
    }
    
    // sixth test
    @Test
    public void sixthTest() {
    	System.out.println("------------------------------------test 6-------------------------");
        HashMap<String, Integer> ans = sixthTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(sixthTestExpected));
    }
    
    // seventh test
    @Test
    public void seventhTest() {
    	System.out.println("------------------------------------test 7-------------------------");
        HashMap<String, Integer> ans = seventhTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(seventhTestExpected));
    }
    
 // eighth test
    @Test
    public void eighthTest() {
    	System.out.println("------------------------------------test 8-------------------------");
        HashMap<String, Integer> ans = eighthTest.countOccurencesLetterGrades();
        System.out.println(ans);
        assertTrue(ans.equals(eighthTestExpected));
    }

    
}
