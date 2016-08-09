import java.util.Scanner;

public class UseCarRental {
  public static void main(String[] args) {
	  Scanner inputString = new Scanner(System.in);
	  Scanner inputNum = new Scanner(System.in);
	  
	  String option, rentersName, sizeCar, typeCar;
	  int zipCode, rentalDays;
	  
	  System.out.print("Renter's name: ");
	  rentersName = inputString.nextLine();
	  System.out.print("Zip code: ");
	  zipCode = inputNum.nextInt();
	  System.out.print("Choose type of car: [standard, luxury]: ");
	  typeCar = inputString.nextLine();
	  System.out.print("Type of car [economy, midsize, fullsize]: ");
	  sizeCar = inputString.nextLine();
	  System.out.print("How many days?: ");
	  rentalDays = inputNum.nextInt();
	  
	  if(typeCar.equals("standard")){
		  CarRental standardcar = new CarRental(rentersName, zipCode, sizeCar, rentalDays);
		  standardcar.display();
	  }else if(typeCar.equals("luxury")){
		  LuxuryCarRental luxurycar = new LuxuryCarRental(rentersName, zipCode, sizeCar, rentalDays);
		  
		  System.out.print("Would you like to use a Chauffer? [Y/N]: ");
		  option = inputString.nextLine();
		  
		  if(option.equals("Y") || option.equals("y")){
			  luxurycar.display(200);
		  }else{
			  luxurycar.display();
		  }
	  }
	  
  }
}
