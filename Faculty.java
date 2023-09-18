
public class Faculty extends Employee{


	private Course [] coursesTaught;	// you can assume that the maximum number of courses a faculty has  // taught cannot exceed 100
	private int numCoursesTaught; 	//controlled variable
	private boolean isTenured; //professor or faculty member at a college or university, indicating that they have earned a permanent position within the institution

	public Faculty(){	// coursesTaught = [], numCoursesTaught = 0, isTenured = false

		super();	
		coursesTaught = new Course [100];
		numCoursesTaught = 0;
		isTenured = false;

	}	
	public Faculty(boolean isTenured) {	// coursesTaught = [], numCoursesTaught = 0, this.isTenured = isTenured

		coursesTaught = new Course [100];
		this.isTenured = isTenured;
		numCoursesTaught = 0;

	}
	public Faculty(String deptName, boolean isTenured) {

		super(deptName);
		this.isTenured = isTenured;
	}
	public Faculty(String name, int birthYear, String deptName, boolean isTenured) {
		super(name,birthYear,deptName);
		this.isTenured = isTenured;
		numCoursesTaught = 0;
		coursesTaught = new Course [100];
	}
	public void setIsTenured(boolean isTenured) {

		this.isTenured = isTenured;
	}

	public boolean isTenured() {

		return isTenured;
	}
	public int getNumCoursesTaught() {

		return	numCoursesTaught;
	}

	public void addCourseTaught(Course course) {	//appends course to the end of the existing array


		if (numCoursesTaught >=  0 && numCoursesTaught <= coursesTaught.length-1) {
       

		coursesTaught[numCoursesTaught] = course;
		numCoursesTaught++;
		} 


	}	
	public void addCoursesTaught(Course [] course) {	//appends courses to the end of the existing array

		
		for (int i = 0; i < course.length ;i++) {

			if (numCoursesTaught >=  0 && numCoursesTaught <= course.length-1) {
			coursesTaught[numCoursesTaught++] = course[i];
			//System.out.println(coursesTaught[i]);


		}
		}
	}


	public Course getCourseTaught(int index) {		// note: index must be verified. Return “null” if invalid

		if (index < 0 || index > numCoursesTaught || index > coursesTaught.length-1) {

			return null;
		}
		else {
			return coursesTaught[index];
		}


	}	
	public String getCourseTaughtAsString(int index) {	// note: index must be verified. Return “” if invalid
		if (index < 0 || index > numCoursesTaught || index > coursesTaught.length-1) {

			return null;
		}
		else {

			return getDeptName()+"-"+coursesTaught[index].toString();
		}                                                                // returns “courseDept-courseNum”

	}	

	public String getAllCoursesTaughtAsString() {	// comma separated list of all courses taught

		String allCourses = ""; 

		for (int i = 0; i < numCoursesTaught; i++) {

			allCourses += getCourseTaughtAsString(i);
			if (i < numCoursesTaught - 1) {

				allCourses += ", ";
			}
			//  uses getCourseTaughtAsString(int index) as a helper method

		}

		return allCourses;

	}	
	@Override	
	public boolean equals(Object obj){	//all attributes inherited+local must match for 2 Faculty objects to be considered equal

		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}

		if (!(obj instanceof Faculty)) { // if object is an instance of a class it has access to all the methods and properties(variables) defined by the class
			return false;
		}
		Faculty faculty = (Faculty) obj; //we cast faculty as an object to compare all instance fields to itself(the class)
		if (numCoursesTaught != faculty.numCoursesTaught) { 
			return false;
		}
		if (isTenured != faculty.isTenured) { 
			return false;
		}
		return true;
	}	
	@Override	
	public String toString() {	
		String tenured = "";	

		if (isTenured == true) {
			tenured = "Is Tenured";
			return String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",super.toString(),tenured, numCoursesTaught,getAllCoursesTaughtAsString());
		}
		else {
			tenured = "Not Tenured";
			return String.format("%s Faculty: %11s | Number of Courses Taught: %3d | Courses Taught: %s",super.toString(),tenured, numCoursesTaught,getAllCoursesTaughtAsString());
		}
	}    
	
	public int compareTo(Faculty f) {	// use the Comparable interface specification, sort by  // numCoursesTaught
		
		
		return super.compareTo(f);                                   
	}

	public static void main(String[] args) {
		Faculty a = new Faculty("Fidel Castro",1926,"Revolution",true);
		Faculty l = new Faculty("Castro",1940,"Revolution",false);
		//	System.out.println(c.toString());
	
		Course b = new Course(false,168,"CMP",4); //created objects for array of objects
		Course g = new Course(false,334,"CMP",4);
		Course s = new Course(false,338,"CMP",4);
		Course[] c = {b,g,s}; //initialized array of objects with the objects

		int tracker = 0;
	   while(tracker < c.length ) {     //Add 2 new Courses to a Faculty object
		a.addCourseTaught(c[tracker]);
			tracker++;
		}
		Course m = new Course(false,172,"CMP",4); //created objects for array of objects
		Course gp = new Course(false,339,"CMP",4);
		Course h = new Course(false,308,"CMP",4);
		Course[] z = {m,gp,h};
	
		//while(tracker < z.length ) {     //Add 2 new Courses to a Faculty object
		//a.addCourseTaught(z[tracker]);
	//	tracker++;
//	}
		
	//	Course [] mn = {b,g,s,m,gp,h}; 
		while(tracker < z.length ) {     //Add 2 new Courses to a Faculty object
			a.addCourseTaught(z[tracker]);
			tracker++;
		}
	  //System.out.println(a.getCourseTaught(0));
	  System.out.println(a.toString());
	
	
		//l.addCourseTaught(g);
		//l.addCourseTaught(s);
		//System.out.println(a.getAllCoursesTaughtAsString());
	//	System.out.println(a.compareTo(l));
		

	}

}
