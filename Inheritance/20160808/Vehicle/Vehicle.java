
public class Vehicle {
	private int numWheels, avgMilesGal;

	public Vehicle(int numWheels, int avgMilesGal) {
		this.numWheels = numWheels;
		this.avgMilesGal = avgMilesGal;
	}
	
	public String toString(){
		return "\nNumber of wheels: " + numWheels +
				"\nAverage miles per gallon: " + avgMilesGal;
	}
	
}
