package Files;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class EmployeeDetails {
	
	private static Scanner infile; 
	private static Formatter outfile;
	
	public static void main(String []args){
		
		try{
		 infile= new Scanner(new File("Employee.txt"));
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Error Creating File");
			System.exit(1);
		}
		
		try{
			outfile = new Formatter("EmployeeBonus.txt");
		}
		catch(SecurityException se){
			System.out.print("you do not have acces to this file");
			System.exit(1);
		}
		catch(FileNotFoundException fnfe){
			System.out.print("error in creating file");
			System.exit(1);
		}
		
		String firstName,Surname,gender,rank,type;
		double basic,bonus,hours;
		
		while(infile.hasNext()){
			
			firstName= infile.next();
			Surname= infile.next();
			gender=infile.next();
			rank=infile.next();
			type=infile.next(); 
			basic=Double.parseDouble(infile.next());
			
				hours=Double.parseDouble(infile.next());
			
			if(rank=="officer"){
				bonus= (0.2*basic);
			}
			else{
				bonus= (0.15*basic);
			}
			
			outfile.format("%s %s %s %f \n",firstName,Surname,gender,bonus+basic);
			
		}//while
		outfile.close();
	}
}
