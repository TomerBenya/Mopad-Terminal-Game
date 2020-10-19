package edu.nyu.cs.tby208.mopad;

public class Mopad {
	
	//possible directions
	private String[] directions= {"North", "East" , "South", "West"};
	private String directionFacing = directions[2];
	private String direction = this.directionFacing;
	
	//starting location
	private int aveNum = 5;
	private int stNum = 10;
	
    //Direction of motion
	public boolean movingForward = true;
	
	private int gasTank = 100;
	
	//current location
	public int currentAveNum=this.aveNum;
    public int currentStNum=this.stNum;
	
	
	//getters and setters
	
	
	//parking moped
	public void park() {
		System.out.println("You have parked the mopad at " + currentStNum + "th St and " + currentAveNum + "th ave. Thanks for playing.");
	}
	
	//help
	public void help() {
		System.out.println("Enter one of the following commands to move the moped:");
		System.out.println("'go left', 'go right', 'straight on', 'back up', 'go to Petite Abeile'");
		System.out.println("Enter one of the following commands to check gas and fill up:");
		System.out.println("'how we doing?' to check gas level, 'fill 'er up' to get more gas");
		System.out.println("Enter one of the following commands to stop: ");
		System.out.println("'park' to quit the program");
	}
	
	//Gas management
	
	//get current gas tank state
	public void checkGas() {
		System.out.println("The gas tank is currently " + this.gasTank + "% full.");
	}
	
	//set tank back to 100%
	public void fillUp() {
		this.gasTank=100;
	}
	
	//decrease gas as mopad moves
	public int moveMoped() {
		this.gasTank = this.gasTank - 5;
		return this.gasTank;
		
	}
	
	public boolean hasGas() {
		if (gasTank <=0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Switch direction
	public boolean changeDirection() {
		if (this.movingForward = true) {
			this.movingForward = false;
			}
		
		else {
			this.movingForward = true;
		}
		return this.movingForward;
	}
	
	//checking if mopad goes out of bounds
	
	public boolean checkAve (int currentAve) {
		
		if (currentAve > City.maxAve || currentAve < City.minAve) {
			
			return false;
		}
		else {
			
			return true;
		}

	}
	 
public boolean checkSt (int currentSt) {
		
		if (currentSt > City.maxStreet || currentSt < City.minStreet) {
			return false;
		}
		else {
			
			return true;
			}
		}
	
		public boolean checkLocation() {
			if ((currentAveNum == 8) && (currentStNum == 79)) {
				this.atMuseum();
			}
			
			else if ((currentAveNum == 1) && (currentStNum == 74)) {
				this.atMemorial();
			}
			
			else if ((currentAveNum == 6) && (currentStNum == 3)) {
				this.atCoffee();
			}
			
			else if ((currentAveNum == 4) && (currentStNum == 12)) {
				this.atStrand();
			}
			
			//print error when user goes out of bounds
			boolean streetCheck = checkSt(currentStNum);
			boolean aveCheck = checkAve(currentAveNum);
			

			
			if ((streetCheck == false) || (aveCheck == false)) {
				System.out.println("Invalid move! You can't leave manhattan.");
				//this.backUpWhenOutOfBounds();
				return false;	
			}
			else {

				return true;
			}
		}
	//check current location
		public void printResults() {
			boolean result = checkLocation();
			if (result = true) {
				System.out.println("Current location - Street: " + currentStNum +". Avenue: " + currentAveNum + "." + " Facing " + direction);
				
			}
		}
	
	//change current location as mopad moves
		public int addSt() {
			currentStNum = currentStNum + 1;
			return currentStNum;
		}
		
		//method to add avenue value
		public int addAve() {
			currentAveNum = currentAveNum + 1;
			return currentAveNum;
		}
		
		//method to subtract avenue value
		public int subtractAve() {
			currentAveNum = currentAveNum - 1;
			return currentAveNum;
		}
		
		//method to subtract street value
		public int subtractSt() {
			currentStNum = currentStNum - 1;
			return currentStNum;
		}
		

		
		
		// steering
		
		public void goLeft() {
			//moving forward and left facing south
			if (direction == directions[2]) {
				if (this.movingForward = false) {
					//switch to reverse if going backwards
					changeDirection();
				}
				//change direction to east
				direction = directions[1];
				subtractAve();
				moveMoped();
				printResults();
			}
			
			//forward and left facing east
			else if (direction == directions[1]) {
				if (this.movingForward = false) {
					//switch to reverse
					changeDirection();
				}
				//change direction to north
				direction = directions[0];
				addSt();
				moveMoped();
				printResults();
			}
			
			//forward and left facing north
			else if (direction == directions[0]) {
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to west
				direction = directions[3];
				addAve();
				moveMoped();
				printResults();
			}
			
			//forward and left facing west
			else if (direction == directions[3]) {
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to south
				direction = directions[2];
				subtractSt();
				moveMoped();
				printResults();
			}
		}
		
		//method to go right
		public void goRight() {
			//facing south
			if (direction == directions[2]) {
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to west
				direction = directions[3];
				addAve();
				moveMoped();
				printResults();
			}
			
			//facing west
			else if (direction == directions[3]) {
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to west
				direction = directions[0];
				subtractSt();
				moveMoped();
				printResults();
			}
			
			//facing north
			else if (direction == directions[0]) {
				//if car is moving in reverse, turn around to turn
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to east
				direction = directions[1];
				subtractAve();
				moveMoped();
				printResults();
			}
			
			//facing east
			else if (direction == directions[1]) {
				if (this.movingForward = false) {
					//switch car to reverse
					changeDirection();
				}
				//change direction to west
				direction = directions[2];
				addSt();
				moveMoped();
				printResults();
			}
		}
		
		public void backUp() {
			//moving south and backwards
			
			if (direction == directions[2]) {
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				addSt();
				moveMoped();
				printResults();
				}
			
			
			
			//moving north and backwards
			else if (direction == directions[0]) {
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				subtractSt();
				moveMoped();
				printResults();
			}
			
			//moving west and backwards
			else if (direction == directions[3]) { 
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				subtractAve();
				moveMoped();
				printResults();
			}
			
			//moving east and backwards
			else if (direction == directions[1]) {
				if (this.movingForward = true) {
					//reverse
					changeDirection();
				}
				addAve();
				moveMoped();
				printResults();
			}
			
		}
		

		public void straightOn() {
			//moving south and forward
			if (direction == directions[2]) {
				if (this.movingForward = false) {
					changeDirection();
				}
				subtractSt();
				moveMoped();
				printResults();
			}
			
			//moving north and forward
			else if (direction == directions[0]) {
				if (this.movingForward = false) {
					changeDirection();
				}
				addSt();
				moveMoped();
				printResults();
			}
			
			//moving west and forward
			else if (direction == directions[3]) {
				if (this.movingForward = false) {
					changeDirection();
				}
				addAve();
				moveMoped();
				printResults();
			}
			
			//moving east and forward
			else if(direction == directions[1]) {
				if (this.movingForward = false) {
					changeDirection();
				}
				subtractAve();
				moveMoped();
				printResults();
			}
		
	}
		
		public void backUpWhenOutOfBounds() {
			//moving south and backwards
			if (direction == directions[2]) {
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				addSt();
				moveMoped();
				
				}
			
			
			
			//moving north and backwards
			else if (direction == directions[0]) {
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				subtractSt();
				moveMoped();
		
			}
			
			//moving west and backwards
			else if (direction == directions[3]) { 
				if (this.movingForward = true) {
					//switch car to reverse
					changeDirection();
				}
				subtractAve();
				moveMoped();
			
			}
			
			//moving east and backwards
			else if (direction == directions[1]) {
				if (this.movingForward = true) {
					//reverse
					changeDirection();
				}
				addAve();
				moveMoped();
				
			}
			if (this.movingForward = false) {
				this.straightOn();
			}
			
			
		}
		
		
		//method to send moped to petite
		public void goToPetite() {
			while ((currentStNum != 17) || (currentAveNum != 6)) { 
					petiteStreet();
					petiteAve();
			}
			
			if ((currentStNum == 17) && (currentAveNum == 6)) {
				System.out.println("Now at 17th St. and 6th Ave.  We have reached the Petite Abeille.  Enjoy your moules-frites.");
		}
		}
		
		//method to figure out which direction moped should go in relation to Petite's location
		//changes avenue
		public void petiteAve() {
			while (currentAveNum < 6) {
				for (int i = currentAveNum; i < 6; i++) {
					direction = directions[3];
					this.movingForward = true;
					straightOn();
					//System.out.println("Current location: " + currentStNum + "th Street and " + currentAveNum + "th Ave...Heading " + direction);
				}
			}
			
			while (currentAveNum > 6) {
				for (int i = currentAveNum; i < 6; i--) {
				direction = directions[1];
				this.movingForward = true;
				backUp();
				//System.out.println("Current location: " + currentStNum + "th Street and " + currentAveNum + "th Ave...Heading " + direction);
				}
			}
		}
		
		//method to figure out which direction moped should go in relation to Petite's location
			//changes street
		public void petiteStreet() {
			while (currentStNum < 17) {
				for (int i = currentStNum; i < 17; i++) {
					direction = directions[0];
				this.movingForward = true;
				straightOn();
				//System.out.println("Now at " + currentStNum + "th Street and " + currentAveNum + "th Ave...Heading " + direction);
				}
			}
			
			while (currentStNum > 17) {
				for (int i = currentStNum; i < 17; i--) {
					direction = directions[2];
				this.movingForward = true;
				backUp();
				//System.out.println("Now at " + currentStNum + "th Street and " + currentAveNum + "th Ave...Heading " + direction);
				}
			}
		}
		//Natural History Museum
		public void atMuseum() {
			System.out.println("You are outside of the American Museum of Natural History.");
	}
	
	//Memorial Sloan Ketterin
	public void atMemorial() {
			System.out.println("You are outside of the Memorial Sloan Kettering.");
	}
	
	//Coffee shop
	public void atCoffee() {
			System.out.println("You are outside of the Fayda Coffee Tea Cookies Cake. Grab yourself a treat!");
	}
	
	//the Strand
	public void atStrand() {
			System.out.println("Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?");
	}
		
		
}
