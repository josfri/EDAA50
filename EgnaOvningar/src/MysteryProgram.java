
	import java.util.Scanner;
	public class MysteryProgram {
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        int n = scan.nextInt();
	        double sum = 0;
	        int nbrPos = 0;
	        for (int i = 0; i < n; i++) {
	            double term = scan.nextDouble();
	            if (term > 0) {
	                sum += term; 
	                nbrPos++;
	           }
	       }
	       System.out.println(sum/nbrPos);
	    }
	}

