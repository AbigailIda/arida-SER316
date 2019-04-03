package main.java;

import java.awt.List;
import java.util.ArrayList;

//emun derived from the Major.class to change code smells (lazy class) defect.
public enum Major {
    SER, CS, IT; 

} 

/**
 * This is student class encapsulating all the details for a student.
 */
public class Student {
    private String asurite;
    private Major major;
    private double overall_grade;
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Course> Courses2 = null;
    
    public Student(String asurite, Major major){
        this.setAsurite(asurite);
        this.setMajor(major);
        setOverall_grade(0);

    }

    public String getAsurite() {
         return asurite;
    }

    public void setAsurite(String asurite ) {
        this.asurite = asurite;
    }

    public Major getMajor() {
        return major;
    }
    
    public boolean Register_forCourse(Course course) {
      course.addStudent(this);
      return courses.add(course);
  }

    public void setMajor(Major major) {
        this.major = major;
    }

    public double getOverall_grade(){
        return overall_grade;
    }

    public void setOverall_grade(double overall_grade) {
        this.overall_grade = overall_grade;
    }
    
    


}
