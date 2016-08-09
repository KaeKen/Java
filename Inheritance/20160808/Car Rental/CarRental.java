
public class CarRental {
	private String rentersName;
	private int zipCode;
	private String sizeCarRented;
	private double dailyRentalFee;
	private double lengthRentalDays;
	private double tRentalFee;
	
	public CarRental(String rentersName, int zipCode, String sizeCarRented, double lengthRentalDays) {
		this.rentersName = rentersName;
		this.zipCode = zipCode;
		this.sizeCarRented = sizeCarRented;
		this.lengthRentalDays = lengthRentalDays;
		
		switch(sizeCarRented){
			case "economy": 
				dailyRentalFee = 29.99;
				break;
			case "midsize": 
				dailyRentalFee = 38.99;
				break;
			case "fullsize":
				dailyRentalFee = 43.50;
				break;
		}
		tRentalFee = lengthRentalDays * dailyRentalFee;
	}

	public void display(double extrafee){
		System.out.print(
				"\nRenter's name: " + rentersName +
				"\nZip code: " + zipCode +
				"\nType of rental: " + lengthRentalDays +
				"\nDaily rental rate: " + dailyRentalFee +
				"\nTotal rental fee: " + (tRentalFee + extrafee));
	}

	public void display() {
		display(0);
	}	
	
}
