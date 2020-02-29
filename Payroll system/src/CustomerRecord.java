import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;


public class CustomerRecord extends ArrayList{
	String employeeCode;
	String employeeName;
	int employeeLevel;
	int employeeRate;
	
	public CustomerRecord(String name, String code, int level, int rate) {
		employeeName= name;
		employeeCode = code;
		employeeLevel = level;
		employeeRate = rate;
	}
	
	public CustomerRecord(){
		
	}
	
	public void setSignInTime(String[] sInTime){
		int totalTime=0;
		for(int i=0;i<sInTime.length;i++){
			String time = sInTime[i];
			String hour = time.substring(0, time.indexOf(":"));
			String minute =time.substring(time.indexOf(":")+1);
			
			
			
			System.out.println(hour);
			System.out.println(minute);
		}
	}
	
	public void setSignOutTime(String[] sInTime){
		
	}
}