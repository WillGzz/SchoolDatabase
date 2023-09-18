
public class Employee extends Person {

	
	private String deptName;
	private static int numEmployees;
	private int employeeID;		//generated 

	public Employee() {			// deptName = “”, employeeID computed
		
		super();                  //reference variable used to call the parent class's methods or constructors,
		this.employeeID = ++numEmployees;//you can initialize any fields or variables in the parent class that the subclass inherits.
		deptName = "";
	   
	   }	
	public Employee(String deptName) {	// employeeID computed
	
		this.deptName = deptName;
		this.employeeID = ++numEmployees;	
	}	
	public Employee(String name, int birthYear, String deptName) {	// employeeID computed
	
	super(name,birthYear);
	this.deptName = deptName;

	this.employeeID = ++numEmployees; //employeeID is am instance variable that belongs to each object, since numEmployees is static it is accessible to the entire class
									// which allows to increment the employee number since its not tied to tbe specific object
	
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptName() {
		
		return deptName;
	}
	public static int getNumEmployees(){
	
	return numEmployees;	
	}	
	public int getEmployeeID() {
		
		
		return employeeID;
	}
	/*When a subclass overrides a method in the parent class, the behavior of the overridden method 
	 * is replaced with the new behavior defined in the subclass. 
	 * This means that the output of the parent class's method is effectively 
	 * "disregarded" and instead the output of the subclass's method is used. 
	 */
	@Override
	public boolean equals(Object obj){	//all attributes inherited+local must match for 2 Employee objects to be considered equal
	
		  if (this == obj) {
		        return true;
		    }
		    if (!super.equals(obj)) {
		        return false;
		    }
		 
		    if (!(obj instanceof Employee)) { // if object is an instance of a class it has access to all the methods and properties(variables) defined by the class
		        return false;
		    }
		    Employee employee = (Employee) obj;
		    if (deptName != employee.deptName) { 
		        return false;
		    }
		    if (numEmployees != employee.numEmployees) { 
		        return false;
		    }
		         return true;
	
	}	
	@Override
	public String toString() {	//”<content of Person> Employee: Department: %20s | Employee Number: %3d”, deptName, employeeID
	
	// the super.toString() method is used to call the parent class's toString() method and include the common information about the person's name and birth year. 	
		return String.format("%s Employee: Department: %20s | Employee Number: %3d",super.toString(),deptName, employeeID);
	}	
	
	public int compareTo(Employee e) {
		if(e == null){
			return 0;
			}
		if(employeeID > e.employeeID ){
			return 1;
		}
		else if(employeeID  < e.employeeID  ){
			return -1;
		}
		return 0;
	


	}	
	public static void main(String[] args) {
		Employee c = new Employee("Fidel Castro",1926,"Revolution");
	    Employee l = new Employee("Castro",1940,"Revolution");
	//	Employee k = new Employee("Castro",1940,"Revolution");
		  
		System.out.println(c.toString());
		System.out.println(l.toString());
		//System.out.println(k.toString());
	//		System.out.println(k.compareTo(c));
	//	System.out.println(l.toString());

	//	System.out.println(c.getEmployeeID());
		  
	}

}
