import java.io.*;
import java.util.Scanner;


public class MainClasss {
	public static void main(String[] args){
		String action="";
		RecordList recList = RecordList.getInstance();
		Scanner inputLine = new Scanner(System.in);
		
		System.out.println("Program starts");
		System.out.println("Please enter the action to be performed...");
		action = inputLine.nextLine();
		
		switch(action){
		case "r":
			System.out.println("New customer registration");
			while(!inputLine.nextLine().equalsIgnoreCase("save")){
				recList.registerEmployee();
			}
			
			recList.saveList(recList);
			System.out.println("record saved");
			break;
		case "a":
			System.out.println("Please enter the Employee code");
			String code = inputLine.nextLine();
			recList=RecordList.getInstance();
			
			for(int i = 0;i<recList.size();i++){
				CustomerRecord c =(CustomerRecord)recList.get(i);
				if(c.employeeCode.equalsIgnoreCase(code)){
					System.out.println("Employee name: " +c.employeeName);
					System.out.println("Employee salary rate: " + c.employeeRate);
				}
			}
			
			// make decision as to how the record is going to be retrieved
			break;
		}
	}
}  
