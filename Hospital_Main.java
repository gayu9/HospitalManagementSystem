package Hospital_Project;

public class Hospital_Main extends Details {
	public static void main(String[] args) {

		al.add("1.General Physician");
		al.add("2.HeartSpecialist");
		al.add("3.Exit");

		while (true) {
			int choise;
			System.out.println("Enter a Choice\n1.NewPatient\n2.OLD Patient Details\n3.Current_PatientList  \n");
			choise = sc.nextInt();

			switch (choise) {

			case 1: {
				System.out.println("Enter Name,Age,Bloodgroup");
				String Name1 = sc.next();
				int Age1 = sc.nextInt();
				String Blood_Group1 = sc.next();
				Details d = new Details();

				d.Details(Name1, Age1, Blood_Group1);
				items.add(d);
				Details dc = new Details();

				dc.doctorsList();
				break;
			}
			case 2: {
				System.out.println("Please Enter Your Patient ID");
				 patientid=sc.nextInt();
				Details d1 = new Details();
                d1.Old_PatientDetails();
			}
			case 3: {
				
				Details d2 = new Details();
                d2.TodayPatientList();
				break;
			}

			}

		}

	}

}
