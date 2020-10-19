package edu.nyu.cs.tby208.mopad;


import java.util.Scanner;


public class Test_Drive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String action = "";
		
		boolean keepGoing=true;
		
		//instantiating mopad
		Mopad mopad1 = new Mopad();
		
		System.out.println("Thanks for jumping on the moped. We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.  May I say your teeth look very clean.");	

		Scanner input = new Scanner(System.in);
		
		
		//main game loop
		
		
		
		while (keepGoing) {
			
			
			if (!mopad1.hasGas()) {
				System.out.println("You're out of gas!! you lose.");
				mopad1.park();
				break;
			}

			
			System.out.println("What would you like to do?  At any time, type \"help\" for assistance.  ");

			
			action = input.nextLine();
			
			if (mopad1.checkLocation() == false) {
				if (mopad1.currentAveNum >= City.maxAve) {
					mopad1.currentAveNum=City.maxAve;
				}
				if (mopad1.currentAveNum <= City.minAve) {
					mopad1.currentAveNum = City.minAve;
				}
				if (mopad1.currentStNum >= City.maxStreet) {
					mopad1.currentStNum=City.maxStreet;
				}
				if (mopad1.currentStNum <= City.minAve) {
					mopad1.currentStNum = City.minAve;
				}
				System.out.println("Please make a different move");
				continue;
			}
			//series of if statements to process user input
			else if (action.equals("go left")) {
				mopad1.goLeft();
			}
			
			
			else if (action.equals("go right")) {
				mopad1.goRight();
			}
			
			else if (action.equals("straight on")) {
					mopad1.straightOn();
			}
			
			else if (action.equals("back up")) {
						mopad1.backUp();			
			}
			
			else if (action.equals("how we doing?")) {
				mopad1.checkGas();
			}
			
			else if (action.equals("fill er up")) {
				mopad1.fillUp();
			}
			else if (action.equals("park")) {
				mopad1.park();
				keepGoing=false;
			}
			else if (action.equals("go to Petite Abeile")) {
				mopad1.goToPetite();
			}
			else if (action.equals("help")) {
				mopad1.help();
			}
			else {
				System.out.println("Error! Please enter 'help' for a list of acceptable commands.");
			}
			
		}
		
		
		
		
		
		
		
	}

}
