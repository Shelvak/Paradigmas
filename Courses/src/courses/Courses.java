package courses;

public class Courses {

    public static void main(String[] args) throws CourseExcep {
        Course course1 = new Course("math");
        Course course2 = new Course("math2");
        Course course3 = new Course("math3");
        Course course = new Course("math");
        Teacher teacher = new Teacher("Square");
        Student student = new Student("Nestor");
        
        System.out.println("WITHOUT TEACHER");
        
        student.enroll(course1);
        student.enroll(course2);
        student.enroll(course3);
        
        
        course1.setTeacher(teacher);
        course2.setTeacher(teacher);
        course3.setTeacher(teacher);
        
        student.showEnrollments();
                
        System.out.println("Get Teacher's students from first course");
        teacher.getCourses().get(0).studentsList();
        
        System.out.println("\n\n\n");
        System.out.println("WITH TEACHER");
        
                
        student.enroll(course1);
        student.enroll(course2);
        student.enroll(course3);
        
        System.out.println("Get Student's teacher from second course");
        System.out.println(student.getEnrollments().get(1).getCourse().getTeacher().getName());
        
        System.out.println("Get Teacher's students from first course");
        teacher.getCourses().get(0).studentsList();
    }
}
