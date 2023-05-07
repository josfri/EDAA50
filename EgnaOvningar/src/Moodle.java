import java.util.Arrays;

public class Moodle {

	public static void main(String[] args) {

		int[] v = {3,2,6,7,0,88,1,5}; // exempel för att se om det funkar

		int[] temp = new int[v.length]; // temporär vektor att sortera i

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < v.length; i++) { // ser till att v[0] blir rätt
			if (v[i] < min) {
				min = v[i];
			}
		}

		for (int k = 0; k < v.length; k++) { // ger ett värde på varje lucka i vektorn temp

			int maxTal = Integer.MIN_VALUE;
			int maxPlats = 0;

			for (int i = 0; i < v.length; i++) { //

				if (v[i] > maxTal) {
					maxTal = v[i];
					maxPlats = i;
				}

			}

			v[maxPlats] = min;

			temp[v.length - 1 - k] = maxTal;
			//
		}

		for (int j = 0; j < v.length; j++) {
			v[j] = temp[j];
		}
		System.out.print(Arrays.toString(v));
		
		int [] u = new int[5];
		System.out.print(Arrays.toString(u));
		
	}

}
