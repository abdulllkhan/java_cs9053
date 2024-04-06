
public class EstimatePi {

	
	public static int estimatePi() {
		
		int iterations = 0;
		double convergence = Math.pow(Math.PI, 2) / 6;
		double sum = 0.0;
		int n = 1;

		while(true){

			sum += (1 / Math.pow(n++, 2));
			iterations++;
			if(Math.abs(sum - convergence) < 0.0001) return iterations;

		}

		// return iterations;
		
	}
	
	public static void main(String[] args) {	

		int iterations = estimatePi();
		System.err.println("The  number of iterations required for convergence are: " + iterations);
		
	}
	
}
