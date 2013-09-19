package courses;

import java.util.Vector;

public class Student {
    private String name;
    private int enrollCount = 0;
    private Vector<Enrollment> enrollments = new Vector();
    
    public Student(String s){
        name = s;
    }
    
    void enroll(Course c) throws CourseExcep{
        try {
            Enrollment enroll = new Enrollment(c, this);
            if(enrollCount <= 10 && c.enrollQuantity() <= 100){
                c.addEnrollment(enroll);
                enrollments.add(enroll);
                enrollCount += 1;
                System.out.println("Enrolled on: " + c.getName() + " =)");
            } else {
                System.out.println("So many enroll's");
            }
        } catch (CourseExcep ex){ }
    }
    
    public String getName(){
        return name;
    }
    
    public int getEnrollCount(){
        return enrollCount;
    }
    
    public Vector<Enrollment> getEnrollments(){
        return enrollments;
    }
    
    public void showEnrollments(){
        if(enrollCount != 0){
            System.out.println("Enroll on: " );
            
            for(Enrollment enr : enrollments) 
                System.out.println(enr.getCourse().getName());

        } else System.out.println("Without enrollments");
    }
}
