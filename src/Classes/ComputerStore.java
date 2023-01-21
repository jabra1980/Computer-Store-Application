package Classes;

import java.util.Scanner;



public class ComputerStore {
	
	static Scanner scan = new Scanner(System.in);
	
	private int counter = 0;
	private int sizeStore = 0;
	private int noOfCreatePc = 0;
	private int noOfComputer = 0;
	
	// Declaration object & object-Array
	private static Computer[] inventory;


	//Capacity of the store
	public void sizeStore() {
		System.out.print("Enter the Store Capacity?");
		sizeStore = scan.nextInt();
		inventory = new Computer[sizeStore];
	}//End sizeStore()
	
	
	
	public void showMenu(){
		
		int str;
		System.out.println();
		
		do {
			System.out.println("Computer Store: " + (sizeStore - noOfCreatePc));
			Computer.findNumberOfCreatedComputers();

			str = Data_config.getMenu();
			
			switch (str) {
				case 1:
					addNewComputer();
					break;
				case 2:
					changeInformationPc();
					break;
				case 3:
					findComputersBy();
					break;
				case 4:
					findCheaperThan();
					break;
				case 5:
					compareItems();
					break;
				case 6:
					System.out.print("Thank you for using the Program");
					Data_config.sleep(1000);
					break;
		
				default:
					System.out.print("Error input...!\n returning to main menu");
					Data_config.sleep(1000);
					System.out.println("\n");
					break;
					
			}//End switch
			
		} while (str != 6);

	}//End showMenu()
	
	
	//Case 1
	private void addNewComputer() {
		
		//Entering the password
		if (Data_config.getPass() == true) {
			
			System.out.print("How many computer Would you like to add? ");
			noOfComputer = scan.nextInt();
			
			if(noOfComputer + noOfCreatePc <= sizeStore) {
            	
				for (int i = 0; i < noOfComputer; i++) {
					
					System.out.println("PC No." + (i+1));
					
					//New Brand
					System.out.print("Enter Computer's Brand? ");
					String brandName = scan.next();
					scan.nextLine();
					
					//New Model
					System.out.print("Enter Computer's Model? ");
					String modelName = scan.next();
					scan.nextLine();

					
					//New SN
					System.out.print("Enter Computer's SN? ");
					long serialNumber = scan.nextLong();
					
					//New Price
					System.out.print("Enter Computer's price? ");
					double priceValue = scan.nextDouble();

					//New Object
					Computer computer = new Computer(brandName, modelName, serialNumber, priceValue);
					
					//Adding to Object-array
					inventory[counter] = computer;
					
					//Printing Object Info
					System.out.println("\n====== Pc Info");
					System.out.println("Computer ID: " + (counter + 1) + " - " + inventory[counter].toString());
					
					counter++;
					noOfCreatePc++;

					System.out.println("Computer has been added successfully...!\n"
							+ "========================================\n");
					
				}//End for add new pc

            }else {
            	// giving notify to user that he exceeded number of Size Store
            	System.out.println("you have exceeded max number of Size Store");
				System.out.println("Computer Store Capacity left: " + (sizeStore - noOfCreatePc) + "\n");
			}//End else wrong password

		}//End if enter password
		
	}//End addNewComputer()
	
	
	
	//Case 2
	private void changeInformationPc() {
		int str, pcID = 0;
		System.out.println();
		if (Data_config.getPass() == true) {
			
			if(noOfCreatePc != 0) {
				System.out.println("Enter Computer ID? ");
				pcID = scan.nextInt();
				
				if (computerIDVerifier(pcID) == false) {
					System.out.println("Error...! This Computer ID does not exist");
				}else {
					System.out.println("Computer ID: " + (pcID) + " - " + inventory[pcID-1].toString());
				}

				do {
					str = Data_config.getUpdateMenu();
					System.out.println();
					
					switch (str) {
						case 1:
							updateBrand(pcID);
							break;
						case 2:
							updateModel(pcID);
							break;
						case 3:
							updateSn(pcID);
							break;
						case 4:
							updatePrice(pcID);
							break;
						case 5:
							System.out.print("returning to Main menu");
							Data_config.sleep(1000);
							System.out.println("\n");
							break;
								
						default:
							System.out.print("Error input...!\n returning to Update menu");
							Data_config.sleep(1000);
							System.out.println("\n");
							break;
					}//End Switch
					
					System.out.println("===============\nUpdated Pc Info\n===============");
					System.out.println("Computer ID: " + (pcID) + " - " + inventory[pcID-1].toString());
				} while (str != 5);
				
			}else {
				System.out.print("No data exists...!\n returning to Main menu");
				Data_config.sleep(1000);
			}
		}//End verify Password
		
	}//End changeInformationPc()
	
	//Sub Case 1
	private void updateBrand(int pcID) {
		
		System.out.println("Enter Brand? ");
		String newBrand = scan.next();
		inventory[pcID-1].setBrand(newBrand);
		
	}//End updateBrand()
	
	//Sub Case 2
	private void updateModel(int pcID) {
		
		System.out.println("Enter new Computer Model; ");
		String newModel = scan.next();
		inventory[pcID-1].setModel(newModel);
		
	}//End updateModel()
	
	//Sub Case 3
	private void updateSn(int pcID) {

		System.out.println("Enter new Computer SN? ");
		long newSn = scan.nextLong();
		inventory[pcID-1].setSN(newSn);
		
	}//End updateSn()
	
	//Sub Case 4
	private void updatePrice(int pcID) {
		
		System.out.println("Enter new Computer Price; ");
		double newPrice = scan.nextDouble();
		inventory[pcID-1].setPrice(newPrice);
		
	}//End updatePrice()

	
	
	//Case 3
	private void findComputersBy() {
		
		if(noOfCreatePc != 0) {
			System.out.println("Enter Computer Brand? ");
			String pcB = scan.next();
			
			if (computerBrandVerifier(pcB) == false) {
				System.out.println("Error...! This Computer brand does not exist");
				
			} else {
				System.out.println("==============\nComputers List\n==============");
				
				for (int i = 0; i < inventory.length; i++) {
					if (inventory[i].getBrand().equals(pcB)) {
						System.out.println("Computer ID: " + (i + 1) + " - " + inventory[i].toString());
					}//End if
				}//End For
			}//End else
		}else {
			System.out.print("No data exists...!\n returning to Main menu");
			Data_config.sleep(1000);
		}//End else

	}//End findComputersBy()
	
	
	
	//Case 4
	private void findCheaperThan() {
		
		if(noOfCreatePc != 0) {
			System.out.println("Enter Price? ");
			double pID = scan.nextDouble();
			
			if (pID == 0) {
				System.out.println("Error...! This Price should be not equal zero");
				
			}else {
				System.out.println("==============\nComputers List\n==============");
				
				for (int i = 0; i < inventory.length; i++) {
					if (inventory[i].getPrice() < pID) {
						System.out.println("Computer ID: " + (i + 1) + " - " + inventory[i].toString());
					}//End If
					
				}//End For
				
			}//End else
		}else {
			System.out.print("No data exists...!\n returning to Main menu");
			Data_config.sleep(1000);
		}//End else
	}//End findCheaperThan()

	
	
	//Case 5
	private void compareItems() {
		 
		if(noOfCreatePc != 0) {
			System.out.println("Enter First Computer ID? ");
			int firstPcID = scan.nextInt();
			
			System.out.println("Enter Second Computer ID? ");
			int secondPcID = scan.nextInt();
			
			if (computerIDVerifier(firstPcID) == false || computerIDVerifier(secondPcID) == false) {
				System.out.println("Error...! either First Computer ID or Second Computer ID are does not exist");
				
			}else {
				
				System.out.println("Computer ID: " + (firstPcID) + " - " + inventory[firstPcID-1].toString());
				
				System.out.println("Computer ID: " + (secondPcID) + " - " + inventory[secondPcID-1].toString());
					
				System.out.println("Result of comparing: " + inventory[firstPcID-1].equals(inventory[secondPcID-1]) + "\n");

			}//End else
		}else {
			System.out.print("No data exists...!\n returning to Main menu");
			Data_config.sleep(1000);
		}//End else
	}//End compareItems()
	

	
	//Verifier Section
	
	private static boolean computerIDVerifier(int cID) {
		
		boolean flag = false;
		
		for (int j = 0; j < inventory.length; j++) {
			
			if (j+1 == cID ) {
				flag = true;
			}else if (inventory[j] == null) {
				flag = false;
			}//End elseIF
			
		}//End For
		return flag;
	}//End computerIDVerifier()
	
	private static boolean computerBrandVerifier(String cBr) {
		
		boolean flag = false;
		
		for (int j = 0; j < inventory.length; j++) {
			
			if (inventory[j].getBrand().equals(cBr) ) {
				flag = true;
			}else if (inventory[j].getBrand() == null) {
				flag = false;
			}//End elseIf
			
		}//End For
		return flag;
	}//End computerBrandVerifier()
	
	

}//End Class ComputerStore()


