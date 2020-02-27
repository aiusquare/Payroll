import java.io.Serializable;


public class CustomerRecord implements Serializable{
	String employeeCode;
	String employeeName;
	int employeeLevel;
	int employeeRate;
	int totalHoursWorked[];
	
	public CustomerRecord(String name, String code, int level, int rate) {
		employeeName= name;
		employeeCode = code;
		employeeLevel = level;
		employeeRate = rate;
	}
	
	public CustomerRecord(){
		
	}
}