
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import java.util.List;

public class Student
{
    // instance variables - replace the example below with your own
    private String name;
    private String id;
    private ArrayList<String> courses;

    /**
     * Constructor for objects of class Student
     */
    
     public Student(String name, String id)
    {
        // initialise instance variables
        this.name=name;
        this.id=id;
        courses=new ArrayList<>();
    }
    
    public Student()
    {
        name="Syeda";
        id="500623477";
        courses=new ArrayList<>();
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getStudentName ()
    {
        // put your code here
        return name;
    }
    public  String getStudentID (){
        
        return id;
    }  
    
    
    public int addCourse(String courseCode){
        
    int course=0;
    //I can hard code all the courses in the main function
    courses.add(courseCode);
    course++;
    return course;
    }
    
    
    
    public int dropCourse(String courseCode){
    int course=0;
    courses.remove(courseCode);
    course--;
    return course;
    
    }
    
    public ArrayList<String> getCourses() {
        return courses;
    }
    
    public String getCourseLoadStatus(){
      if(courses.size()<4){
            return "Part time";   
    }
        else if(courses.size()>=4 && courses.size()<=6){
            return "Full time";
        }
        else 
        return"overload";
        
}
    
 @Override public String toString(){
     String a=getStudentName();
     String b=getStudentID();
     ArrayList<String> c=getCourses();
     String d=getCourseLoadStatus();  
     return "Student Name:"+ " "+a+"\n"+"Student Id:"+" "+b+"\n"+ "List of Courses:"+
     " "+c+"\n"+ "Course Load:"+" "+d+"\n";
    }
}

