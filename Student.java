
public class Student extends Person  {

	private static int numStudents;
	private int studentID;			 //generated 
	private Course[] coursesTaken;	//initialize to length of 50
	private int numCoursesTaken; 	//controlled variable
	private boolean isGraduate;
	private String major;			//”undeclared” default value
	
	
	
	public Student() {	// / coursesTaken = [], numCoursesTaken = 0, isGraduate = false
	
	super();
	coursesTaken = new Course[50];
	numCoursesTaken = 0;
	isGraduate = false;
	major = "undeclared";
	this.studentID = ++numStudents;
	}	
	public Student(boolean isGraduate) {
		
		this.isGraduate = isGraduate;
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		major = "undeclared";
		this.studentID = ++numStudents;
	}
	public Student(String major, boolean isGraduate) {
		
		this.major = major;
		this.isGraduate = isGraduate;
		coursesTaken = new Course[50];
		numCoursesTaken = 0;
		this.studentID = ++numStudents;
		
	}
	public Student(String name, int birthYear, String major, boolean isGraduate) {
	
	super(name,birthYear);
	this.major = major;
	this.isGraduate = isGraduate;
	coursesTaken = new Course[50];
	numCoursesTaken = 0;
	this.studentID = ++numStudents;
	
	}
	public void setIsGraduate(boolean isGraduate) {
		
		this.isGraduate = isGraduate;
	}
	public boolean isGraduate() {
		
		return isGraduate;
	}
	public int getNumCoursesTaken() {
		
		return numCoursesTaken;
	}
	public static int getNumStudents() {
		
		return numStudents;
	}
	public int getStudentID() {
		
		return studentID;
	}
	public void setMajor(String major) {
		
		this.major = major;
	}
	
	public String getMajor() {
		
		return major;
	}
	
	public void addCourseTaken(Course course){	//appends course to the end of the existing array
	
		if (numCoursesTaken >=  0 && numCoursesTaken <= coursesTaken.length-1) {
		coursesTaken[numCoursesTaken] = course;
		 numCoursesTaken++;
		}	
	}	
	public void addCoursesTaken(Course [] course) {	//appends courses to the end of the existing array
		
		for (int i = 0; i < course.length ;i++) {
			if (numCoursesTaken >=  0 && numCoursesTaken <= course.length-1) {
			
			coursesTaken[numCoursesTaken++] = course[i];
		
			}
		}
		}	
	public Course getCourseTaken(int index){		// note: index must be verified. Return “null” if invalid
	
		 if (index < 0 || index > numCoursesTaken || index > coursesTaken.length-1) {
			 
			 return null;
		 }
		 else {
			 return coursesTaken[index];
		 }
	}	
	public String getCourseTakenAsString(int index){	// note: index must be verified. Return “” if invalid  // returns “courseDept-courseNum”
	 if (index < 0 || index > numCoursesTaken || index > coursesTaken.length-1) {
			 
			 return null;
		 }
		 else {
			 return major+"-"+coursesTaken[index].toString();
		 }                                                                // returns “courseDept-courseNum”
	
		
	}
	public String getAllCoursesTakenAsString(){	// comma separated list of all courses taught //  uses getCourseTakenAsString(int index) as a helper method
		 String allCourses = ""; 
			
			for (int i = 0; i < numCoursesTaken; i++) {
		      
		     allCourses += getCourseTakenAsString(i); //  uses getCourseTaughtAsString(int index) as a helper method
		     if (i < numCoursesTaken - 1) {    //if you dont add the addition operator, each time the loop iterates allCAoureses is 
		    	 									//just being assigned a new course at a different index instead of adding the courses after each index,
		    	 									//so  you would just get the course assigned at the last index instead of all courses
		    	 									
					allCourses += ", ";
				}
		    }
			
		  return allCourses;
		
	}
	@Override
	public boolean equals(Object obj){//all attributes inherited+local must match for 2 Student objects to be considered equal
	
		 if (this == obj) {
		        return true;
		    }
		    if (!super.equals(obj)) {
		        return false;
		    }
		 
		    if (!(obj instanceof Faculty)) { // if object is an instance of a class it has access to all the methods and properties(variables) defined by the class
		        return false;
		    }
		    Student student = (Student) obj; //we cast faculty as an object to compare all instance fields to itself(the class)
		    if (numStudents != student.numStudents) { 
		        return false;
		    }
		    if (numCoursesTaken != student.numCoursesTaken) { 
		        return false;
		    }
		    if (isGraduate != student.isGraduate) { 
		        return false;
		    }
		    if (major != student.major) { 
		        return false;
		    }
		         return true;
	}	
	@Override
	public String toString(){//”<content of Person> Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s”, studentID, major, Graduate/Undergraduate, numCoursesTaken, getAllCoursesTakenAsString() 
	String grad = "";
		
		if (isGraduate == true) {
			grad = "Graduate";
		return String.format("%s Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",super.toString(), 
			studentID, major, grad, numCoursesTaken, getAllCoursesTakenAsString());
		}	
		else {
			grad = "Undergraduate";
			return String.format("%s Student: studentID: %04d | Major %20s | %14s | Number of Courses Taken: %3d | Courses Taken: %s",super.toString(), 
				studentID, major, grad, numCoursesTaken, getAllCoursesTakenAsString());
		}
		
		}	
	
	public int compareTo(Course s) {	//use the Comparable interface specification, sort by numCredits

		if(s == null){
			return 0;
			}
		if(s.getNumCredits() > s.getNumCredits() ){ 
			return 1;
		}
		else if(s.getNumCredits() < s.getNumCredits() ){
			return -1;
		}
		return 0;

	}
	
	
	
	public static void main(String[] args) {
		
		Student a = new Student("Fidel Castro",1926,"Computer Science",true);
		Student z = new Student("Abraham Lincoln",1823,"Computer Science",true);
		
		Course b = new Course(false,168,"CMP",4);
		Course g = new Course(false,334,"CMP",4);
		Course s = new Course(false,338,"CMP",4);
		Course[] c = {b,g,s}; //initialized array of objects with the objects
	
	//	System.out.println(b.toString());
	//	a.addCoursesTaken(c);
		//a.addCourseTaken(b);
		//a.addCourseTaken(g);
	//	a.addCourseTaken(s);
		//System.out.println(a.getAllCoursesTakenAsString());
		String name = "";
		System.out.println(name);
		//		z.addCourseTaken(g);
//	System.out.println(a.getCourseTaken(0));
//	System.out.println(a.getStudentID());

	}

}
