
public class LuxuryCarRental extends CarRental{
	
	public LuxuryCarRental(String rentersName, int zipCode, String sizeCarRented, double lengthRentalDays) {
		super(rentersName, zipCode, sizeCarRented, lengthRentalDays);
	}

	@Override
	public void display(){
		super.display(79.95);
	}
	
	@Override
	public void display(double extraFee){
		super.display(79.95+extraFee);
	}
}
