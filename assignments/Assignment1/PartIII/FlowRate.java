public class FlowRate {

	public static double calculateFlowRate(double radius, double length, double eta, double pressureChange, double dyanmicViscosity) {

		double flowRate;

		double pi = Math.PI;
		
		flowRate = pressureChange * pi * Math.pow(radius, 4) / (8 * eta * length);

		return flowRate * 1000;
	}
	
	public static void main(String[] args) {
		double radius = .0127;
		double length = 5;
		double eta = 8.9E-4;
		double pressureChange = 22000;
		double dyanmicViscosity = 8.9E-4;
		
		
		double flowRate = calculateFlowRate(radius, length, eta, pressureChange, dyanmicViscosity);
		System.out.println("\n\nThe flow rate in liters/sec is: " + flowRate + "litres/sec");

	}
}	