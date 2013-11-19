package courses;

import java.util.ArrayList;

public class Teacher {
    private String name;
    private ArrayList<Course> courses;
    
    public Teacher(String t){
        courses = new ArrayList<Course>();
        name = t;
    }
    
    public int coursesCount(){
        return courses.size();
    }
    
    public void addCourse(Course c){
        courses.add(c);
    }
    
    public ArrayList<Course> getCourses(){
        return courses;
    }
    
    public String getName(){
        return name;
    }
}
