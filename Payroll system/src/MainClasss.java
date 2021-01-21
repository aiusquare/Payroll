import java.io.*;
import java.util.Scanner;

public class MainClasss {
	public static void main(String[] args){
		String action="";
		RecordList recList = RecordList.getInstance();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader inputLine = new BufferedReader(isr);
		
		System.out.println("Program starts");
		System.out.println("Please enter the action to be performed...");
		try {
			action = inputLine.readLine();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		switch(action){
		case "r":
			System.out.println("New customer registration");
			String regCtrl = "";
			while(!regCtrl.equalsIgnoreCase("save")){
				recList.registerEmployee();
				System.out.println("Enter 'next' for next employee or save to end reg.");
				try {
					regCtrl=inputLine.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
				
			recList.saveList(recList);
			System.out.println("record saved");
			break;
		case "a":
			try {
				System.out.println("Please enter the Employee code");
				String code = inputLine.readLine();
				
				recList=RecordList.getInstance(); // re-initialize the object so that new changes will be effected
				for(int i = 0;i<recList.size();i++){
					CustomerRecord c =(CustomerRecord)recList.get(i);
					if(c.employeeCode.equalsIgnoreCase(code)){
						System.out.println("Employee name: " +c.employeeName);
						System.out.println("Employee salary rate: " + c.employeeRate);
						
						System.out.println("hours worked througth the week");
						String day = "";
						String[] days ={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
						String[] signInTime = new String[5];
						String[] signOutTime = new String[5];
						
						for(int j =0; j<signInTime.length;j++){
							System.out.println("sign in time on: "+ days[j]);
							signInTime[j] = inputLine.readLine();
							System.out.println("sign out time on: "+days[j]);
							signOutTime[j] = inputLine.readLine();
						}
						c.setSignInTime(signInTime);
						c.setSignOutTime(signOutTime);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
				//System.out.print(e.getMessage());
			}
			
			break;
		}
	}
}  
  
