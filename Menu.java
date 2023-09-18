import java.util.Scanner;
import java.io.*;
/*The main method in Java accepts an array of strings (String[] args) as a parameter to allow passing command-line arguments to the program. 
 * When you run a Java program from the command line, 
 * you can provide additional arguments separated by spaces,
 *  and these arguments will be passed to the main method as elements of the args array.
 * 
 */
public class Menu {

	static Scanner scnr = new Scanner(System.in);
	private static Object yesOrno;
	public static void main(String[] args) {
		do {
			int num = 0;
			Course [] c;
			Course course; 

			System.out.println("**************************************************************");	
			System.out.println("Entering the school database.........");
			System.out.println("**************************************************************");	

			System.out.println("SCHOOL DATABASE INFO:");
			System.out.println();
			System.out.println("************************************************");

			System.out.println("COURSES:");

			System.out.println("How many courses do you want to create?");
			num = scnr.nextInt();

			System.out.println("Enter "+num+" courses as indicated below:");
			c = new Course[num];
			for (int i = 0; i < c.length;i++) { // calls the createCourse method while the loop iterates until the array is filled

				course = createCourse();      //this allow us to create and assign a object at each index
				c[i] = course;
			
	
			}
			for (int i = 0; i < c.length;i++) {

				System.out.println(c[i].toString());

			}
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("PERSONS:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("EMPLOYEES:");
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("GENERAL STAFF:");
			// /*
			int num2 = 0;
			GeneralStaff [] gs;
			GeneralStaff staff;

			System.out.println("What is the number of Staff?");
			num2 = scnr.nextInt();

			System.out.println("Enter info for "+num2+" Staff:" );
			gs = new GeneralStaff[num2];

			for (int i = 0; i < gs.length;i++) { // calls the method while the loop iterates until the array is filled

				staff = createGeneralStaff();      //this allow us to create and assign a object at each index
				gs[i] = staff;
			}
			for (int i = 0; i < gs.length;i++) {

				System.out.println(gs[i].toString());
			}	
			//	*/
			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("FACULTY:");
			int num3 = 0;
			Faculty [] fa;
			Faculty faculty;

			System.out.println("What is the number of Faculty?");
			num3 = scnr.nextInt();

			System.out.println("Enter info for "+num3+" Faculty as indicated below:" );
			fa = new Faculty[num3];

			for (int i = 0; i < fa.length;i++) { // calls the method while the loop iterates until the array is filled

				faculty = createFaculty();      //this allow us to create and assign a object at each index
				fa[i] = faculty;

			}
			for (int i = 0; i < fa.length;i++) {

				System.out.println(fa[i].toString());
			}	
			System.out.println("Specify the faculty and what courses will they teach as indicated below:");
			System.out.println("indicate the faculty by their employee number:");
			int employeeNumber = scnr.nextInt();
			for (int i = 0; i < fa.length;i++) {

				if (fa[i].getEmployeeID() == employeeNumber) {

					System.out.println("The faculty chosen is: "+fa[i].toString()+"\n");

					System.out.println("Indicate the amount of courses "+fa[i].getName() +" will teach:");
					int numCourses = scnr.nextInt();


					int tracker = 0;
					while(tracker < numCourses ) {
						fa[i].addCourseTaught(c[tracker]);
						tracker++;
					}
					System.out.println(numCourses+" courses were added!");
					System.out.println(fa[i].toString()+"\n");

					System.out.println("Indicate if "+fa[i].getName()+" will be teaching any new courses:");
					System.out.println("Enter Yes or No:");
					String reply = scnr.next();

					if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
						System.out.println("Indicate the number of new courses that "+fa[i].getName()+" will be teaching:");
						numCourses = scnr.nextInt();

						System.out.println(numCourses +" will be added, specify the courses as indicated below:");
						int newLength = c.length + numCourses;
						Course []	c2  = new Course[newLength];

						for (int j = 0; j < c.length ;j++) {   //Assigning old values from old array to new since arrays have a fixed size

							c2[j] = c[j];
						}

						for (int j = c.length; j < c2.length ;j++) { // calls the createCourse method while the loop iterates until the array is filled

							course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

							c2[j] = course;

							fa[i].addCourseTaught(c2[j]);  //allows us too keep adding new to the specific faculty object 
						}
						System.out.println(numCourses+" new courses were added!");
						System.out.println(fa[i].toString()+"\n");

						System.out.println("Indicate if you would be accessing a specific course from "+fa[i].getName()+":");
						System.out.println("Enter Yes or No:");
						reply = scnr.next();

						if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
							System.out.println("Indicate the specific course by the course number:");
							int courseNum = scnr.nextInt();

							boolean courseFound = false;
							for (int j = 0; j < c2.length; j++) {

								if (c2[j].getCourseNum() == courseNum) {
									System.out.println(fa[i].getCourseTaughtAsString(j));

									courseFound = true;
									break;
								}

							}
							if (!courseFound) {
								System.out.println(fa[i].getName() + " is not teaching this course.");
							}

						}
						else {
							System.out.println("No courses will be accessed.");	
						}
						System.out.println("Choose another faculty by their employee number:");
						int employee = scnr.nextInt();
						for (int j = 0; j < fa.length;j++) {

							if (fa[j].getEmployeeID() == employee) {

								System.out.println("The faculty chosen is: "+fa[j].toString()+"\n");

								System.out.println("Indicate the amount of courses "+fa[j].getName() +" will teach:");
								numCourses = scnr.nextInt();
								System.out.println(numCourses +" will be added, specify the courses as indicated below:");

								newLength = c2.length + numCourses;
								Course []	c3  = new Course[newLength];


								for (int k = 0; k < c2.length; k++) {   //Assigning old values from old array to new since arrays have a fixed size

									c3[k] = c2[k];
								}
								for (int k = c2.length; k < c3.length ;k++) { // calls the createCourse method while the loop iterates until the array is filled

									course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

									c3[k] = course;

									fa[j].addCourseTaught(c3[k]);  //allows us too keep adding new to the specific faculty object 

								}
								System.out.println(numCourses+" courses were added!");
								System.out.println(fa[j].toString()+"\n");

								System.out.println(mostCoursesTaught(fa));
								System.out.println(leastCoursesTaught(fa));
								System.out.println("The max course number is: "+maxCourseNum(c3));
								System.out.println("The min course number is: "+minCourseNum(c3));
								courseObjects(c3);
								//
							}	
						}	
					}	
					else {
						System.out.println(fa[i].getName()+" will not be teaching any new courses.");

						System.out.println("Indicate if you would be accessing a specific course from "+fa[i].getName()+":");
						System.out.println("Enter Yes or No:");
						reply = scnr.next();

						if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
							System.out.println("Indicate the specific course by the course number:");
							int courseNum = scnr.nextInt();

							boolean courseFound = false;
							for (int j = 0; j < c.length; j++) {

								if (c[j].getCourseNum() == courseNum) {
									System.out.println(fa[i].getCourseTaughtAsString(j));
									courseFound = true;
									break;
								}
							}
							if (!courseFound) {
								System.out.println(fa[i].getName() + " is not teaching this course.");
							}

						}
						else {
							System.out.println("No courses will be accessed.");	
						}
						System.out.println("Choose another faculty by their employee number:");
						int employee = scnr.nextInt();
						for (int j = 0; j < fa.length;j++) {

							if (fa[j].getEmployeeID() == employee) {

								System.out.println("The faculty chosen is: "+fa[j].toString()+"\n");

								System.out.println("Indicate the amount of courses "+fa[j].getName() +" will teach:");
								numCourses = scnr.nextInt();

								System.out.println(numCourses +" will be added, specify the courses as indicated below:");

								int newLength = c.length + numCourses;
								Course []	c3  = new Course[newLength];


								for (int k = 0; k < c.length; k++) {   //Assigning old values from old array to new since arrays have a fixed size

									c3[k] = c[k];
								}
								for (int k = c.length; k < c3.length ;k++) { // calls the createCourse method while the loop iterates until the array is filled

									course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

									c3[k] = course;

									fa[j].addCourseTaught(c3[k]);  //allows us too keep adding new to the specific faculty object 

								}

								System.out.println(numCourses+" courses were added!");
								System.out.println(fa[j].toString()+"\n");

								System.out.println(mostCoursesTaught(fa));
								System.out.println(leastCoursesTaught(fa));
								System.out.println("The max course number is: "+maxCourseNum(c3));
								System.out.println("The min course number is: "+minCourseNum(c3));
								courseObjects(c3);



								//
							}	
						}	
					}
				}
			}


			System.out.println("************************************************");
			System.out.println("************************************************");
			System.out.println("STUDENTS:");
			int num4 = 0;
			Student [] st;
			Student student;

			System.out.println("What is the number of Students?");
			num4 = scnr.nextInt();

			System.out.println("Enter info for "+num4+" Students as indicated below:" );
			st = new Student[num4];

			for (int i = 0; i < st.length;i++) { // calls the method while the loop iterates until the array is filled

				student = createStudent();      //this allow us to create and assign a object at each index
				st[i] = student;

			}
			for (int i = 0; i < st.length;i++) {

				System.out.println(st[i].toString());
			}
			System.out.println("Specify the student and what courses will they be taking as indicated below:");
			System.out.println("indicate the student by their student ID number:");
			int studentNumber = scnr.nextInt();
			for (int i = 0; i < st.length;i++) {

				if (st[i].getStudentID() == studentNumber) {

					System.out.println("The student chosen is: "+st[i].toString()+"\n");

					System.out.println("Indicate the amount of courses "+st[i].getName() +" will take:");
					int numCourses = scnr.nextInt();


					int tracker = 0;
					while(tracker < numCourses ) {
						st[i].addCourseTaken(c[tracker]);
						tracker++;
					}
					System.out.println(numCourses+" courses were added!");
					System.out.println(st[i].toString()+"\n");

					System.out.println("Indicate if "+st[i].getName()+" will be taking any new courses:");
					System.out.println("Enter Yes or No:");
					String reply = scnr.next();

					if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
						System.out.println("Indicate the number of new courses that "+st[i].getName()+" will be taking:");
						numCourses = scnr.nextInt();

						System.out.println(numCourses +" will be added, specify the courses as indicated below:");
						int newLength = c.length + numCourses;
						Course []	c4  = new Course[newLength];

						for (int j = 0; j < c.length ;j++) {   //Assigning old values from old array to new since arrays have a fixed size

							c4[j] = c[j];
						}

						for (int j = c.length; j < c4.length ;j++) { // calls the createCourse method while the loop iterates until the array is filled

							course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

							c4[j] = course;

							st[i].addCourseTaken(c4[j]);  //allows us too keep adding new to the specific faculty object 
						}
						System.out.println(numCourses+" new courses were added!");
						System.out.println(st[i].toString()+"\n");

						System.out.println("Indicate if you would be accessing a specific course from "+st[i].getName()+":");
						System.out.println("Enter Yes or No:");
						reply = scnr.next();

						if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
							System.out.println("Indicate the specific course by the course number:");
							int courseNum = scnr.nextInt();

							boolean courseFound = false;
							for (int j = 0; j < c4.length; j++) {

								if (c4[j].getCourseNum() == courseNum) {
									System.out.println(st[i].getCourseTakenAsString(j));

									courseFound = true;
									break;
								}

							}
							if (!courseFound) {
								System.out.println("This course is not available.");
							}

						}
						else {
							System.out.println("No courses will be accessed.");	
						}
						System.out.println("Choose another student by their student ID number:");
						int studentID = scnr.nextInt();
						for (int j = 0; j < st.length;j++) {

							if (st[j].getStudentID() == studentID) {

								System.out.println("The student chosen is: "+st[j].toString()+"\n");

								System.out.println("Indicate the amount of courses "+st[j].getName() +" will be taking:");
								numCourses = scnr.nextInt();

								System.out.println(numCourses +" will be added, specify the courses as indicated below:");

								newLength = c4.length + numCourses;
								Course []	c5  = new Course[newLength];


								for (int k = 0; k < c4.length; k++) {   //Assigning old values from old array to new since arrays have a fixed size

									c5[k] = c4[k];
								}
								for (int k = c4.length; k < c5.length ;k++) { // calls the createCourse method while the loop iterates until the array is filled

									course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

									c5[k] = course;

									st[j].addCourseTaken(c5[k]);  //allows us too keep adding new to the specific faculty object 

								}

								System.out.println(numCourses+" courses were added!");
								System.out.println(st[j].toString()+"\n");

								System.out.println(maxCredit(st,c5));
								System.out.println(leastCredit(st,c5));
								courseObjects(c5);
								allObjects(gs,fa,st);
							}
						}

					}
					else {
						System.out.println(st[i].getName()+" will not be taking any new courses.");

						System.out.println("Indicate if you would be accessing a specific course from "+st[i].getName()+":");
						System.out.println("Enter Yes or No:");
						reply = scnr.next();

						if (reply.equalsIgnoreCase("yes") || (reply.equalsIgnoreCase("Yes")) || (reply.equalsIgnoreCase("YES")) ) {
							System.out.println("Indicate the specific course by the course number:");
							int courseNum = scnr.nextInt();

							boolean courseFound = false;
							for (int j = 0; j < c.length; j++) {

								if (c[j].getCourseNum() == courseNum) {
									System.out.println(st[i].getCourseTakenAsString(j));

									courseFound = true;
									break;
								}

							}
							if (!courseFound) {
								System.out.println("This course is not available.");
							}
						}
						else {
							System.out.println("No courses will be accessed.");	
						}
						System.out.println("Choose another student by their student ID number:");
						int studentID = scnr.nextInt();
						for (int j = 0; j < st.length;j++) {

							if (st[j].getStudentID() == studentID) {

								System.out.println("The student chosen is: "+st[j].toString()+"\n");

								System.out.println("Indicate the amount of courses "+st[j].getName() +" will be taking:");
								numCourses = scnr.nextInt();

								System.out.println(numCourses +" will be added, specify the courses as indicated below:");

								int newLength = c.length + numCourses;
								Course []	c5  = new Course[newLength];


								for (int k = 0; k < c.length; k++) {   //Assigning old values from old array to new since arrays have a fixed size

									c5[k] = c[k];
								}
								for (int k = c.length; k < c5.length ;k++) { // calls the createCourse method while the loop iterates until the array is filled

									course = createCourse();      //we start iterating from the length of the previous array since we just want to add the new courses

									c5[k] = course;

									st[j].addCourseTaken(c5[k]);  //allows us too keep adding new to the specific faculty object 

								}

								System.out.println(numCourses+" courses were added!");
								System.out.println(st[j].toString()+"\n");

								System.out.println(maxCredit(st,c5));
								System.out.println(leastCredit(st,c5));


								courseObjects(c5);
								allObjects(gs,fa,st);


								try {
									File file = new File ("Output.txt");
									FileWriter writer = new FileWriter(file);

									System.setOut(new PrintStream(file)); //sets the output stream of the program to write to the file

									// Call the method that prints to the console
									courseObjects(c5);
									allObjects(gs, fa, st);


									System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));// sets output stream back to the console



									writer.close();

								} catch (IOException e) {
									// TODO Auto-generated catch block
									System.out.println("Error writing file.");
								}	


							}
						}

					}
				}

			}


			System.out.println("************************************************");
			System.out.println("**************************************************************");

			System.out.println("Do you want to start over? (Yes/No)");
			yesOrno = scnr.next();


			if  (!yesOrno.equals("Yes") || (!yesOrno.equals("yes"))){    
				System.out.println("Exiting School Database....");
				System.out.println("Exit Successful.");

			}


		}  while (yesOrno.equals("Yes") || (yesOrno.equals("yes")));		
	}
	public static Course createCourse() {

		System.out.println("Enter true if the course is graduate otherwise false for undergraduate:");
		boolean isGraduateCourse = scnr.nextBoolean();	 

		System.out.println("Enter the coutse number:");
		int courseNum = scnr.nextInt();

		System.out.println("Enter the coutse department by it's 3 letter acronym:");
		String courseDept = scnr.next();

		System.out.println("Enter the number of credits:");
		int numCredits = scnr.nextInt();

		Course course = new Course(isGraduateCourse,courseNum,courseDept,numCredits);

		return course;
	}
	public static GeneralStaff createGeneralStaff() {

		System.out.println("Enter the staff's name:");
		String name = scnr.next()+scnr.nextLine();

		System.out.println("Enter the staff's date of birth:");
		int birthYear = scnr.nextInt();

		System.out.println("Enter the staff's department name by it's 3 letter acronym:");
		String deptName = scnr.next()+scnr.nextLine();// returns the input that was skipped

		System.out.println("Enter the staff's duty:");
		String duty = scnr.next()+scnr.nextLine();

		GeneralStaff staff = new GeneralStaff(name,birthYear,deptName,duty);

		return staff;
	}
	public static Faculty createFaculty() {

		System.out.println("Enter the faculty's name:");
		String name = scnr.next()+scnr.nextLine();

		System.out.println("Enter the faculty's date of birth:");
		int birthYear = scnr.nextInt();

		System.out.println("Enter the faculty's department name by it's 3 letter acronym:");
		String deptName = scnr.next()+scnr.nextLine();// returns the input that was skipped

		System.out.println("Enter true if the faculty is tenured otherwise enter false:");
		boolean isTenured = scnr.nextBoolean();

		Faculty faculty = new Faculty(name,birthYear,deptName,isTenured);

		return faculty;
	}
	public static Student createStudent() {

		System.out.println("Enter the students name:");
		String name = scnr.next()+scnr.nextLine();

		System.out.println("Enter the students date of birth:");
		int birthYear = scnr.nextInt();

		System.out.println("Enter the students major by it's 3 letter acronym:");
		String major = scnr.next()+scnr.nextLine();// returns the input that was skipped

		System.out.println("Enter true if the course is graduate otherwise false:");
		boolean isGraduate = scnr.nextBoolean();

		Student student = new Student(name,birthYear,major,isGraduate);

		return student;
	}
	public static String mostCoursesTaught (Faculty[] fa) { 
		int courseAmount = fa[0].getNumCoursesTaught();
		String name = fa[0].getName();	
		for (int j = 1; j < fa.length ;j++) {   

			if (fa[j].getNumCoursesTaught() > courseAmount) {
				courseAmount = fa[j].getNumCoursesTaught();
				name = fa[j].getName();
			}
		}
		return name+" taught the most courses: " +courseAmount;
	}
	public static String leastCoursesTaught (Faculty[] fa) {
		int courseAmount = fa[0].getNumCoursesTaught();
		String name = fa[0].getName();

		for (int j = 1; j < fa.length ;j++) {   

			if (fa[j].getNumCoursesTaught() < courseAmount) {
				courseAmount = fa[j].getNumCoursesTaught();
				name = fa[j].getName();
			}
		}
		return name+" taught the least courses: " +courseAmount;

	}
	public static int minCourseNum (Course[] c) {
		int courseNum = c[0].getCourseNum();

		for (int j = 1; j < c.length ;j++) {   

			if (c[j].getCourseNum() < courseNum) {
				courseNum = c[j].getCourseNum();
			}
		}
		return courseNum;

	}
	public static int maxCourseNum (Course[] c) {
		int courseNum = c[0].getCourseNum();

		for (int j = 1; j < c.length ;j++) {   

			if (c[j].getCourseNum() > courseNum) {
				courseNum = c[j].getCourseNum();
			}
		}
		return courseNum;
	}

	static String maxCredit(Student[] s,Course [] c) {
		int courseTaken = s[0].getNumCoursesTaken();
		int credits = 0;
		String name = s[0].getName();

		for (int j = 1; j < s.length ;j++) {   

			if (s[j].getNumCoursesTaken() > courseTaken) {
				courseTaken = s[j].getNumCoursesTaken();
				name = s[j].getName();
			}
		}
		for (int k = 0; k < courseTaken; k++) {

			credits += c[k].getNumCredits();
		}

		return name+" took the most credits: "+credits+" which = "+courseTaken +" courses taken.";

	}

	public static String leastCredit(Student[] s, Course[] c) {
		int courseTaken = s[0].getNumCoursesTaken();
		int credits = 0;
		String name = s[0].getName();

		for (int j = 1; j < s.length ;j++) {   

			if (s[j].getNumCoursesTaken() < courseTaken) {
				courseTaken = s[j].getNumCoursesTaken();
				name = s[j].getName();
			}
		}
		for (int k = 0; k < courseTaken; k++) {

			credits += c[k].getNumCredits();
		}

		return name+" took the least credits: "+credits+" which = "+courseTaken +" courses taken.";

	}
	public static void courseObjects(Course [] c ) {
		for (int i = 0; i < c.length;i++) {

			System.out.println(c[i].toString());
		}	
	}
	public static void allObjects( GeneralStaff [] gs, Faculty [] fa,  Student [] st) {

		for ( int k = 0; k < gs.length;k++) {

			System.out.println(gs[k].toString());
		}	
		for ( int j = 0; j < fa.length;j++) {

			System.out.println(fa[j].toString());

		}
		for ( int m = 0; m < st.length;m++) {

			System.out.println(st[m].toString());

		}





	}

}

