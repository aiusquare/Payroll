import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sound.sampled.ReverbType;

public class RecordList extends ArrayList{
	private static RecordList recList;

	private RecordList() {
		super();
	}
	
	public void registerEmployee(){
		Scanner input = new Scanner(System.in);
		CustomerRecord cusRecord = new CustomerRecord();
		
		System.out.println("Please give the employee name");
		cusRecord.employeeName = input.nextLine();
		
		System.out.println("Please give the employee code");
		cusRecord.employeeCode = input.nextLine();
		
		System.out.println("Please give the employee level");
		cusRecord.employeeLevel = input.nextInt();
		
		System.out.println("Please give the employee rate");
		cusRecord.employeeRate = input.nextInt();
		
		add(cusRecord);
		System.out.println("Record added");
	}
	
	public static RecordList getInstance(){
		/**
		 * This method check first for the existance of a file before creating the list
		 * object. If the file is already create then the object is going to be retreved from
		 * the file, else new object is going to be created and the method will return the object;
		 * 
		 */
		
		File file=new File("tmp.itm");
		File file2=file.getAbsoluteFile();
		if(file2.exists() && file2 != null){
			try {
				FileInputStream fis=new FileInputStream(file2);
				ObjectInputStream ois=new ObjectInputStream(fis);
				recList = (RecordList)ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{
			recList=new RecordList();
		}
		
		return recList;
	}
	
	public void saveList(RecordList list){
		try {
			FileOutputStream out=new FileOutputStream("tmp.itm");
			ObjectOutputStream oos=new ObjectOutputStream(out);
			oos.writeObject(list);
			oos.close();
			out.close();
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
	}
}