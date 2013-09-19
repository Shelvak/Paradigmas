package courses;

import java.util.Vector;

public class Course {
    private String name;
    private int duration = 0;
    private Vector<Enrollment> enrollments;
    private Teacher teacher;
    
    public Course(String c){
        enrollments = new Vector<Enrollment>();
        name = c;
    }
    
    public void studentsList(){
        if(!enrollments.isEmpty()){
            System.out.println("Students are: " );
            for(Enrollment enr : enrollments){
                System.out.println(enr.getStudent().getName());
            }
        } else System.out.println("Without students...");
    }
    
    public int enrollQuantity(){
        return enrollments.size();
    }
    
    public String getName(){
        return name;
    }
    
    public void addEnrollment(Enrollment e) throws CourseExcep{
        if (teacher == null)
            throw new CourseExcep();
        else
            enrollments.add(e);
    }
        
    public void setTeacher(Teacher t){
        if(t.coursesCount() <= 4){
            t.addCourse(this);
            teacher = t;
        } else {
            System.out.println("Teacher with max courses...");
        }
    }
    
    public Teacher getTeacher(){
        return teacher;
    }
}
