import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	
	private String firstName, lastName;
	private int employeeID;  
   	private double salary;

	/* Task 3C: Add three constructors */
	
	public Employee(){
	}

	public Employee(String last, String first){
		firstName = first;
		lastName = last;
	}

	public Employee(String last, String first, int id, double wage){	
		firstName = first;
		lastName = last;
		employeeID = id;
		salary = wage;

	}
   
	// Task 3D: Add set (mutator) and get (accessor) meethods
	public void setFirstName(String first){
		firstName = first;
	}   
	
	public void setLastName(String last){
		lastName = last;
	}

	public void setEmployeeId(int id){
		employeeID = id;
	}

	public void setSalary(double wage){
		if (wage < 0){
			wage = 0;
		}
		salary = wage;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public int getEmployeeId(){
		return employeeID;
	}

	public double getSalary(){
		return salary;
	}
	/* Task 3F: Add toString method */
   	public String toString(){
		return ("Name: "+firstName+" "+lastName+"\nEmployee ID: "+employeeID+"\nSalary: $"+salary+"\n");  
  	} 
	/* Task 3G: Add equals method */
	public boolean equals( String name ){
		return (lastName.equals(name));
	}
   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.print("Enter First name: ");
						String first = keyboard.nextLine();
						employees[empCount].setFirstName(first);
						
						System.out.print("Enter Last name: ");
						String last = keyboard.nextLine();
						employees[empCount].setLastName(last);
						
						System.out.print("Enter Employee ID: ");
						int id = keyboard.nextInt();
						employees[empCount].setEmployeeId(id);

						System.out.print("Enter Salary: ");
						double wage = keyboard.nextDouble();
						employees[empCount].setSalary(wage);
						
						empCount++;
					}
					else{ // Notifies user if an MAX_EMPLOYEES has been reached
						System.out.println("Database full");
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					boolean match = false;
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								match = true;
								keyboard.nextLine();
							}
						}
					}
				if(match == false){ // Notifies user if no match has been found
					System.out.println("No match found.");
				}
				break;
        
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
				
				default: // Notifies user if an invalid selection has been made
					if( choice != 'Q') {
						System.out.println("Invalid Input");
					}
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
