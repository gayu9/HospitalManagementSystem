package Hospital_Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.*;
class OldPatient_Details 
{
	public void Old_PatientDetails()
	{
		try {
Connection con = DriverManager.getConnection(
			"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022", "P@ssw0rd");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from GAYATHRI_HOSPITAL");
			System.out.println(".......OLD PATIENT DETAILS......");
			while (rs.next()) {
			int pid = rs.getInt("pid");
			String Name = rs.getString("Name");
			int Age = rs.getInt("Age");
			int bp = rs.getInt("bp");
			//String bloodgroup = rs.getString("bloodgroup");
			int temp = rs.getInt("temp");
			//System.out.println("pid" + "  " + "Name" + "  " + "Age" + "  " + "bp" + "  "  + "temp");

			System.out.println(" Patient Id :"+pid + " \n " +"Patient Name is :"+ Name + " \n " +"Patient Age Is :"+ Age + " \n " +"BP is : "+ bp + "\n"  +" Temprature is :"+ temp+"\n");
			}

			} catch (Exception e) {
			System.out.println(e);
			}

	}

}

public class Hospital extends OldPatient_Details
{
	static int temp, te;
	static int bp = 0;
	static String Name;
	static int Age;
	static String Blood_Group;
	int doct;

	static Scanner sc = new Scanner(System.in);
	static Scanner sn = new Scanner(System.in);
	static ArrayList<Hospital> m = new ArrayList<Hospital>();
	static ArrayList<String> al = new ArrayList<>();

	public Hospital(String Name, int Age, String Blood_Group) {

		this.Name = Name;
		this.Age = Age;
		this.Blood_Group = Blood_Group;
	}

	public static void main(String[] arg) {

		al.add("1.General physician");
		al.add("2.Heart Specalist");
		al.add("3.Exit");
		try

		{
	while(true)
    {

			int press;
 			System.out.println("Press \n1.New_Patient\n2.Old_Patient ");
 			press=sc.nextInt();
 			switch(press)
 			{
 			case 1:
 			{
			System.out.println("Enter New Patient Details ...");
			System.out.println("Enter Your Name,Age, blood group\n");
			String Name = sc.next();
			int Age = sc.nextInt();

			String Blood_Group = sn.next();
			Hospital h = new Hospital(Name, Age, Blood_Group);
			m.add( h);

			System.out.println("New Patient details");
			
			h.doctorsList();
            break;
			 }
 			case 2:
 			{
 				OldPatient_Details ol =new OldPatient_Details();
 			ol.Old_PatientDetails();
 			break;
 			}
 			default :
 				System.out.println("press correct number!");

			}
		
    }
		} 
 			catch (Exception e) {
			System.out.println("Enter valid Data");
		}
	
	}
	
	public void doctorsList() {

		for (String s : al) {
			System.out.println(s);
		}
		try
		{
		int doct = sc.nextInt();
		switch (doct) {
		case 1:
			generalPhysician();
			break;
		case 2:
			heartSpecalist();

			break;
		case 3:
			exit();
			break;

		default:
			System.out.println("Enter valid input");
			doctorsList();
			break;
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void heartSpecalist() {
		System.out.println("Welcome to ..HEART SURGERY WARD..");
		System.out.println("Check your Heartbeat");
		try
		{
		int checkheart = sc.nextInt();
		if (checkheart >= 60 && checkheart <= 100) {
			System.out.println("Your heart beats is normal :" + checkheart + " bpm");
			System.out.println("If you want continue press:1.Continue \n2.Exit");
			int cont = sc.nextInt();
			if (cont == 1) {
				doctorsList();
			} else if (cont == 2) {
				exit();
			} else {
				System.out.println("Enter the wrong input");
				heartSpecalist();
			}

		} else if (checkheart >= 0 && checkheart <= 59 || checkheart >= 101)
		{
			System.out.println("Your Heart Beats is Low  so admit your self");
			System.out.println("1.Admission \n2.Exit");
			int ad = sc.nextInt();
			if (ad == 1) {
				admission();
			} else if (ad == 2) {
				exit();
			} else {
				System.out.println("Enter correct input");
				heartSpecalist();
			}

		}
		else if ( checkheart >= 101)
		{
			System.out.println("Your Heart Beats is High  so admit your self");
			System.out.println("1.Admission \n2.Exit");
			int ad = sc.nextInt();
			if (ad == 1) {
				admission();
			} else if (ad == 2) {
				exit();
			} else {
				System.out.println("Enter correct input");
				heartSpecalist();
			}

		}
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void generalPhysician() {
		System.out.println("Welcome to ..GENERAL PHYSICIAN WARD..");
		try
		{
		if (Age >= 40 && Age >= 100) {
			temperature();
			bloodPressure();
		} else {
			temperature();
		}

		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void temperature() {
		try
		{
		System.out.println("Check your temperature");
		temp = sc.nextInt();
		if (temp >= 97&& temp < 100) {
			System.out.println("You are Normal");
			System.out.println("If you want continue press:1.Continue \n2.Exit");
			int cons = sc.nextInt();
			if (cons == 1) {
				doctorsList();
			} else if (cons == 2) {
				exit();
			} else {
				System.out.println("Enter the wrong input");
				generalPhysician();
			}
		}
		else if ( temp >= 0 && temp<=97) {
			System.out.println("Cold fever...");
			bloodPressure();
			System.out.println("you need to admission Press 1:Admission \n 2.exit");
			int te = sc.nextInt();
			if (te == 1) {
				admission();
			} else if (te == 2) {
				exit();

			} else {
				System.out.println("Enter the valid input");
				generalPhysician();
			}
		} 
		else if ( temp >= 100) {
			System.out.println("fever...");
			bloodPressure();
			System.out.println("you need to admission \n1:Admission \n 2.exit");
			int te = sc.nextInt();
			if (te == 1) {
				admission();
			} else if (te == 2) {
				exit();

			} else {
				System.out.println("Enter the valid input");
				generalPhysician();
			}
		} 
		else {
			System.out.println("Enter valid input");
		}
		}
		catch(Exception e)
			{
				System.out.println(e);
			}
		}


	public void bloodPressure() {
		try {

			System.out.println("Check Blood Pressure");
			bp = sc.nextInt();
			if (bp >= 80 && bp < 120) {
				System.out.println("Your BP level is normal ");
				System.out.println("If you want continue press\n:1.Continue \n2.check Doctor for fever \n3.Exit");
				int con = sc.nextInt();
				if (con == 1) {
					doctorsList();
				} else if (con == 2) {
					feverDoctor();
				} else if (con == 2) {
					exit();
				} else {
					System.out.println("Enter the wrong input");
					generalPhysician();
				}

			} else if (bp >= 0 && bp < 80) {
				System.out.println("Your BP is very low\n so please consult doctor!");
				heartSpecalist();
			} else if(bp>=120 && bp<=160)
			{
				System.out.println("Your BP is very high ");
				System.out.println("Plz Admit in hospital ");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void feverDoctor() {
		System.out.println("You have fever So take tablet and take rest");
		System.out.println("If you want continue press:1.Continue \n2.Exit");
		try
		{
		int con = sc.nextInt();
		if (con == 1) {
			doctorsList();
		} else if (con == 2) {
			exit();
		} else if (con == 3) {
			exit();
		} else {
			System.out.println("Enter the wrong input");
			feverDoctor();
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void exit() {
		System.out.println("Thank you");
		System.out.println("To check your health regularly");

	}

	public void admission() {
		System.out.println("....PATIENT DETAILS....");
		//System.out.println("Id            :" + pid);
		System.out.println("Name         :" + Name);
		System.out.println("Age          :" + Age);
		System.out.println("Blood group  :" + Blood_Group);
		System.out.println("Blood pressure:" + bp);
		System.out.println("Temperature   :" + temp);
		System.out.println("You are ADmitted Successfully...");
		System.out.println();
		{
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(
						"jdbc:sqlserver://192.168.168.12:1433;databaseName=New_joinee_2022", "NewJoinee2022",
						"P@ssw0rd");
				PreparedStatement stmt = con.prepareStatement("insert into GAYATHRI_HOSPITAL values(?,?,?,?)");

			   	//stmt.setInt(1, pid);
				stmt.setString(1, Name);
				stmt.setInt(2, Age);
				stmt.setInt(3, bp);
				//stmt.setString(5, Blood_Group);
				stmt.setInt(4, temp);
				int s = stmt.executeUpdate();
				System.out.println("Stored successfully");

			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}
}
