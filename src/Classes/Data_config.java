package Classes;

import java.util.Scanner;

public class Data_config {
	
	private final static String password = "admin";

	private static Scanner scan = new Scanner(System.in);
	

	//Menu Section
	private static int menu(int option) {
		
		System.out.println("\n===========================\nWelcome to JAB-WAY TECH LLC\n===========================\n");
		System.out.println("What do you want to do?\n"
				+ "1. Enter new computers\r\n"
				+ "2. Change information of a computer\n"
				+ "3. Display all computers by a specific brand\n"
				+ "4. Display all computers under a certain a price.\n"
				+ "5. Compare Items.\n"
				+ "6. Quit");
		
		System.out.print("Please enter your choice > ");
		option = scan.nextInt();
		
		return option;
	}//End menu()
	
	public static int getMenu() {
		int option = 0;
		return menu(option);
	}//End getMenu()
	
	private static int updateMenu(int option) {
		System.out.println();
		System.out.println("What information would you like to change?\n"
				+ "1. Brand\n"
				+ "2. Model\n"
				+ "3. SN\n"
				+ "4. Price\n"
				+ "5. Quit");
				
		
		System.out.print("Please enter your choice > ");
		option = scan.nextInt();
		
		return option;
	}//End Updatemenu()
	
	public static int getUpdateMenu() {
		int option = 0;
		return updateMenu(option);
	}//End getUpdateMenu()
	

	
	//Verifier Section
	private static boolean passVerifier(String pass) {
		
		int totalAttempts = 0;
		boolean flag = false;
		
		System.out.print("Please, enter the password? ");
		pass = scan.next();
		while (totalAttempts != 3) {
			
			if (pass.equals(password)) {
				System.out.println("Correct...!\n");
				flag = true;
				break;
			} 
			else {
				System.out.println("\nIncorrect, verify your password and try again!");
	            System.out.println("Attempts No.: " + (totalAttempts+1));
	            totalAttempts++;
	            System.out.print("Please, enter the password? ");
				pass = scan.next();
			}
			
		}if (totalAttempts == 3){
			System.out.println("Maximum number of attempts exceeded\n");
			System.out.print("Returning to Menu");
			sleep(1000);
			System.out.println("\n\n");
		}
		return flag;
	}//End securityVerifier()
	public static boolean getPass() {
		String pass = "";
		return passVerifier(pass);
	}//End getPass()
	

	public static void sleep(int time) {
		try {
			for (int i = 0; i < 3; i++) {
				Thread.sleep(time);
				System.out.print(".");
				}
		} catch (Exception e) {}
	}//End sleep()
	
	
	

}//End Class Data_config()
