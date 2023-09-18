
public class Course implements Comparable<Course> {

	private boolean isGraduateCourse;
	private int courseNum;
	private String courseDept;
	private int numCredits;


	public Course() {

		isGraduateCourse = false;
		courseNum = 0;
		courseDept = "";
		numCredits = 0;	
	}
	public Course(boolean isGraduateCourse, int courseNum, String courseDept, int numCredits) {

		this.isGraduateCourse = isGraduateCourse;
		this.courseNum = courseNum;
		this.courseDept = courseDept;
		this.numCredits = numCredits;	
	}
	public boolean isGraduateCourse() {
		return isGraduateCourse;

	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public void setCourseDept(String courseDept) {
		this.courseDept = courseDept;
	}
	public void setNumCredits(int numCredits) {
		this.numCredits = numCredits;
	}

	public int getCourseNum() {
		return courseNum;
	}
	public String getCourseDept() {
		return courseDept;
	}
	public int getNumCredits() {
		return numCredits;
	}
	public String getCourseName() {
		if (isGraduateCourse == true) {
			return "G"+courseDept+courseNum;
		}
		else {
		return "U"+courseDept+courseNum;
		}
		}
	public boolean equals(Object obj) {
		
		     if (this == obj) {
		        return true;
		    }
		     if (obj == null || !(obj instanceof Course)) {
			        return false;
			    }
		    Course course = (Course) obj; // // compare all instance fields and return true or false
		    
		    if (isGraduateCourse() != course.isGraduateCourse()) {
		        return false;
		    }
		    if (getCourseNum() != course.getCourseNum()) {
		        return false;
		    }
		    if (getCourseDept() != course.getCourseDept()) {
		        return false;
		    }
		    if (getNumCredits() != course.getNumCredits()) {
		        return false;
		    }
		 
		    return true;
		}

	public String toString(){

		if (isGraduateCourse == true) {
			
			 return String.format("Course: %3s-%3d | Number of Credits: %02d | Graduate", courseDept, courseNum, numCredits, isGraduateCourse);
		}
		else {
		  return String.format("Course: %3s-%3d | Number of Credits: %02d | Undergraduate", courseDept, courseNum, numCredits, isGraduateCourse);
		}
	}
	public int compareTo(Course c) { //found in shared drive
		if(c == null){
			return 0;
			}
		if(this.courseNum >  c.courseNum ){
			return 1;
		}
		else if(this.courseNum  < c.courseNum ){
			return -1;
		}
		return 0;
	}
	public static void main(String[] args) {
	
		Course c = new Course(false,168,"CMP",4);
		
	 System.out.println(c.toString());

	}

}
