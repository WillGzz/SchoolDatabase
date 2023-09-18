
public class GeneralStaff extends Employee{

	private String duty;
	
	public GeneralStaff() {				// duty = “”
	
	super();
	duty = "";
	
	}	
	public GeneralStaff(String duty) {
		
		this.duty = duty;
	}
	
	public GeneralStaff(String deptName, String duty) {
		super(deptName);
		this.duty = duty;
	}
	public GeneralStaff(String name, int birthYear, String deptName, String duty) {
		super(name,birthYear,deptName);
		this.duty = duty;
	}
	public String getDuty() {
		
		return duty;
	}
	@Override
	public boolean equals(Object obj) {	//all attributes inherited+local must match for 2 Staff objects to be considered equal

		 if (this == obj) {
		        return true;
		    }
		    if (!super.equals(obj)) {
		        return false;
		    }
		 
		    if (!(obj instanceof GeneralStaff)) { // if object is an instance of a class it has access to all the methods and properties(variables) defined by the class
		        return false;
		    }
		    GeneralStaff staff = (GeneralStaff) obj; //we cast GeneralStaff as an object to compare all instance fields to itself(the class)
		    if (duty != staff.duty) { 
		        return false;
		    }
		   
		         return true;
		
	}
	@Override
	public String toString() {	//”<content of Employee> GeneralStaff: Duty: %10s”, duty 
	
		
		return String.format("%s GeneralStaff: Duty: %10s",super.toString(), duty);
		
		
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	GeneralStaff c = new GeneralStaff("Fidel Castro",1926,"Revolution","clean");
	//	System.out.println(c.toString()); //you dont pass employee number as a parameter since that is assigned within the employee constructor and it increments 
											//everytime we create an object
	}

}
