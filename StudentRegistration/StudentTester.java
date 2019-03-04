import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class StudentTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentTester
{
    // instance variables - replace the example below with your own
    public static void main(String[] args){
        Student student1=new Student();//object created with empty constructor
        Student student2=new Student("Syeda", "500623477");//object created with the non empty contructor
       
        
        student1.addCourse("CPS105");//adding courses for the student1 object 
        student1.addCourse("CPS106");//expected the results will be overloaded
        student1.addCourse("CPS200");
        student1.addCourse("CPS809");
        student1.addCourse("CPS500");
        student1.addCourse("CPS209");
        student1.addCourse("CCPS300");
        student1.addCourse("CCPS700");
        
        /*System.out.println("Student 1 Name:"+" "+student1.getStudentName()+"\n");
        System.out.println("Student 1 ID:"+" "+student1.getStudentID()+"\n");
        System.out.println("Student 1 ID:"+" "+student1.getStudentID()+"\n");*/
        System.out.println("Studen 1: \n"+student1.toString());//displaying student 1 information by calling the toString() method
        
        
        student2.addCourse("CPS105");//adding courses for student 2
        student2.addCourse("CPS106");//expected results for student 2 is full time
        student2.addCourse("CPS200");
        student2.addCourse("CPS809");
        student2.addCourse("CPS500");
        student2.addCourse("CPS209");
        student2.addCourse("CCPS300");
        student2.addCourse("CCPS700");
        
        student2.dropCourse("CPS105");//dropping two courses; expected results is full time
        student2.dropCourse("CPS200");
        
        //testing addcourse method
        /*ArrayList<String> stud2Courses = student2.getCourses();
		for (int i = 0; i < stud2Courses.size(); i++) {
			// String details = stud2Courses.get(i).getCourseDetails();
			// System.out.println(details);
			System.out.println(stud2Courses.get(i));
		}*/
		
		System.out.println("Student 2 (Full Time): \n"+student2.toString());
		
	student2.dropCourse("CPS106");//dropping 3 more courses for student2
	student2.dropCourse("CCPS300");//expected results is part time
	student2.dropCourse("CPS809");
	
	
		System.out.println("Studen 2 (Part-Time): \n"+student2.toString());
		
        
        
    }
}
