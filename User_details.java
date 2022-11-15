package Hospital_Project;

import java.util.*;

public  class User_details {
	static String Name;
	static int Age;
	//static String Blood_Group;
	static int id ;
	//static int id1 = 1;
    
	static Map<Integer, User_details> hp = new HashMap<Integer, User_details>();
	static Scanner sc = new Scanner(System.in);

	public void User_details1(String Name, int Age) {

		this.Name = Name;
		this.Age = Age;
		//this.Blood_Group = Blood_Group;
		this.id = id;
	}
	
	public void printDetails()
	{
		for(User_details d : hp.values())
		{
			System.out.println(d.id);
			id++;
			System.out.println(d.Name);
			System.out.println(d.Age);
		}
	}

	public static void main(String[] args) {
		User_details u = new User_details();
		while(true) {
		System.out.println("choice\n 1.NewPatient\n 2.printDetails");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter New Patient Details ...");
			System.out.println("Enter Your Name,Age, blood group");
			String Name = sc.next();
			int Age = sc.nextInt();
			String Blood_Group = sc.next();
             u.User_details1(Name, Age);
			  hp.put( id,u);
			
			break;
			
		case 2 : 
			u.printDetails();
		}}

	}

}
