package Hospital_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class Sample {
	   static  String Name;
	   static  int Age;
	   static  String Blood_Group;
 static Scanner sc=new Scanner(System.in);
 static ArrayList<Sample> items = new ArrayList<Sample>();

	
	   public  void Sample(String Name, int Age,String Blood_Group)
	   {
	       this.Name = Name;
	       this.Age = Age;
	       this.Blood_Group=Blood_Group;
	   }

	  
//	   public String getName() {
//	       return Name;
//	   }
//
//	   public int getAge() {
//	       return Age;
//	   }
//	   public String getBlood_Group()
//	   {
//		   return Blood_Group;
//	   }
	   public void TodayPatientList()
	   {
		   for (Sample item: items) 
			{
			    System.out.println(item.Name);
			    System.out.println(item.Age);
			    System.out.println(item.Blood_Group);

			}

	   }
	public static void main(String[] args) {
		while(true)
		{
			int choise;
			System.out.println("Enter a Choice");
			choise=sc.nextInt();
			
		switch(choise)
		{
		
		case 1:
	    System.out.println("Enter Name,Age,Bloodgroup");
	    String  Name1 = sc.next();
	      //System.out.println("Enter Age");
         int  Age1 = sc.nextInt();
	     String Blood_Group1=sc.next();
	     Sample d= new Sample();

	     d.Sample(Name1,Age1,Blood_Group1);
	     items.add(d);
	     break;
		case 2:
		{
			Sample d1= new Sample();

			d1.TodayPatientList();
		}
		}


	}

}

}
