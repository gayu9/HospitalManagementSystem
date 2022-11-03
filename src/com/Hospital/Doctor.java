package com.Hospital;

import java.beans.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Doctor {
	ArrayList<User_Data> items = new ArrayList<User_Data>();
	User_Data uc = new User_Data();
	Scanner sc = new Scanner(System.in);
	Scanner sn = new Scanner(System.in);
	int bp, temp;
	static Doctor dc = new Doctor();

	public static void main(String[] args) {
		dc.choose();
	}
	
	public void choose() {
		while (true) {

			try {
				int choise;
				System.out.println("Welcome To Hospital Management System");
				System.out.println("Enter a Choice\n1.New Patient\n2.OLD Patient Details\n3.View PatientList");
				choise = sc.nextInt();

				switch (choise) {

				case 1: {
					System.out.println("Enter Name");
					String Name1 = sc.next();
					System.out.println("Enter Age");
					int Age1 = sc.nextInt();
					System.out.println("Enter Bloodgroup");
					String Blood_Group1 = sc.next();
					User_Data ud = new User_Data();
					ud.details(Name1, Age1, Blood_Group1);
					items.add(ud);
					dc.doctorsList();
					break;
				}
				case 2: {
					Doctor d1 = new Doctor();

					d1.old_PatientDetails();
				}
				case 3: {

					todayPatientList();
					break;
				}

				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}

	}

	public void todayPatientList() {

		for (User_Data item : items) {
			System.out.println(item.getName());
			System.out.println(item.getAge());
			System.out.println(item.getBlood_Group());

		}

	}

	public void doctorsList() {

		try {
			System.out.println("1.General Physiciyan\n2.Heart Specalist\n3.Exit");
			int doct = sn.nextInt();
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
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void heartSpecalist() {
		System.out.println("Welcome to ..HEART SURGERY WARD..");
		System.out.println("Check your Heartbeat");
		try {
			int checkheart = sn.nextInt();
			if (checkheart >= 60 && checkheart <= 100) {
				System.out.println("Your heart beats is normal :" + checkheart + " bpm");
				System.out.println("If you want continue press:1.Continue \n2.Exit");
				int cont = sn.nextInt();
				if (cont == 1) {
					doctorsList();
				} else if (cont == 2) {
					exit();
				} else {
					System.out.println("Enter the wrong input");
					heartSpecalist();
				}

			} else if (checkheart >= 0 && checkheart <= 59 || checkheart >= 101) {
				System.out.println("Your Heart Beats is Low  so admit your self");
				System.out.println("1.Admission \n2.Exit");
				int ad = sn.nextInt();
				if (ad == 1) {
					admission();
				} else if (ad == 2) {
					exit();
				} else {
					System.out.println("Enter correct input");
					heartSpecalist();
				}

			} else if (checkheart >= 101) {
				System.out.println("Your Heart Beats is High  so admit your self");
				System.out.println("1.Admission \n2.Exit");
				int ad = sn.nextInt();
				if (ad == 1) {
					admission();
				} else if (ad == 2) {
					exit();
				} else {
					System.out.println("Enter correct input");
					heartSpecalist();
				}

			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public void generalPhysician() {

		System.out.println("Welcome to ..GENERAL PHYSICIAN WARD..");
		try {

			if (uc.getAge() >= 40 && uc.getAge() >= 100) {
				temperature();
				bloodPressure();
			} else {
				temperature();
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void temperature() {
		try {
			System.out.println("Check your temperature");
			temp = sn.nextInt();
			if (temp >= 97 && temp < 100) {
				System.out.println("You are Normal");
				System.out.println("If you want continue press:1.Continue \n2.Exit");
				int cons = sn.nextInt();
				if (cons == 1) {
					doctorsList();
				} else if (cons == 2) {
					exit();
				} else {
					System.out.println("Enter the wrong input");
					generalPhysician();
				}
			} else if (temp >= 0 && temp <= 97) {
				System.out.println("Cold fever...");
				bloodPressure();
				System.out.println("you need to admission Press 1:Admission \n 2.exit");
				int te = sn.nextInt();
				if (te == 1) {
					admission();
				} else if (te == 2) {
					exit();

				} else {
					System.out.println("Enter the valid input");
					generalPhysician();
				}
			} else if (temp >= 100) {
				System.out.println("fever...");
				bloodPressure();
				System.out.println("you need to admission \n1:Admission \n 2.exit");
				int te = sn.nextInt();
				if (te == 1) {
					admission();
				} else if (te == 2) {
					exit();

				} else {
					System.out.println("Enter the valid input");
					generalPhysician();
				}
			} else {
				System.out.println("Enter valid input");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void bloodPressure() {
		try {

			System.out.println("Check Blood Pressure");
			bp = sn.nextInt();
			if (bp >= 80 && bp < 120) {
				System.out.println("Your BP level is normal ");
				System.out.println("If you want continue press\n:1.Continue \n2.check Doctor for fever \n3.Exit");
				int con = sn.nextInt();
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
			} else if (bp >= 120 && bp <= 160) {
				System.out.println("Your BP is very high ");
				System.out.println("Plz Admit in hospital ");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void feverDoctor() {
		System.out.println("You have fever So take tablet and take rest");
		System.out.println("If you want continue press:1.Continue \n2.Exit");
		try {
			int con = sn.nextInt();
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
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void exit() {
		System.out.println("Thank you");
		System.out.println("To check your health regularly");

	}

	public void admission() {
		System.out.println("....PATIENT DETAILS....");
		System.out.println("Name         :" + items.get(items.size() - 1).getName());
		System.out.println("Age          :" + items.get(items.size() - 1).getAge());
		System.out.println("Blood group  :" + items.get(items.size() - 1).getBlood_Group());
		System.out.println("Blood pressure:" + bp);
		System.out.println("Temperature   :" + temp);
		System.out.println("You are ADmitted Successfully...");
		System.out.println();
		details_Stored();

	}

	public void details_Stored() {
		try {
			Properties p = new Properties();
			FileInputStream fs = new FileInputStream(
					"C:\\Users\\User\\eclipse-workspace\\myfolder\\Hospital_Management_System\\src\\dbdetails.properties");
			p.load(fs);

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("dbname"),
					p.getProperty("password"));

			PreparedStatement stmt = con.prepareStatement("insert into GAYATHRI_HOSPITAL values(?,?,?,?)");

			stmt.setString(1, items.get(0).getName());
			stmt.setInt(2, items.get(0).getAge());
			stmt.setInt(3, bp);
			stmt.setInt(4, temp);
			stmt.executeUpdate();
			System.out.println("Stored successfully");

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	public void old_PatientDetails() {

		try {
			Properties p = new Properties();
			FileInputStream fs = new FileInputStream(
					"C:\\Users\\User\\eclipse-workspace\\myfolder\\Hospital_Management_System\\src\\dbdetails.properties");
			p.load(fs);
			Connection con = DriverManager.getConnection(p.getProperty("dburl"), p.getProperty("dbname"),
					p.getProperty("password"));
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *    from GAYATHRI_HOSPITAL");
			System.out.println(".......OLD PATIENT DETAILS......");
			while (rs.next()) {
				int pid = rs.getInt("pid");
				String Name = rs.getString("Name");
				int Age = rs.getInt("Age");
				int bp = rs.getInt("bp");
				int temp = rs.getInt("temp");
				System.out.println(
						" Patient Id :" + pid + " \n " + "Patient Name is :" + Name + " \n " + "Patient Age Is :" + Age
								+ " \n " + "BP is : " + bp + "\n" + " Temprature is :" + temp + "\n");
			}

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}