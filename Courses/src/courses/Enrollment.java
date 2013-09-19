package courses;

import java.util.Date;

public class Enrollment {
    private Date date;
    private Course course;
    private Student student;
    
    Enrollment(Course c, Student s){
        date  = new Date();
        course = c;
        student = s;
    }
    
    public Course getCourse(){
        return course;
    }
    
    public Student getStudent(){
        return student;
    }
    
    public Date getEnrollDate(){
        return date;
    }
}
