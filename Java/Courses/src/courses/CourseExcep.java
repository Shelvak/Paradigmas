package courses;


public class CourseExcep extends Exception {
    
    public CourseExcep(String msj){
        super(msj);
    }
    
    public CourseExcep() {
        System.out.println("Error, can't enroll in a course without a teacher");
    }
}
