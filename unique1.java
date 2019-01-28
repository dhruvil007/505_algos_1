import java.util.*;

public class unique1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++)
			input[i] = sc.nextInt();
		boolean possibleFlag = false;
		int solnLength = 0;
		int[] soln = new int[2];	// Solution index in 0, length in 1
		for(int start = 0; start < size; start++) {
			for(int end = start + 1; end < size; end++) {
				if(possibleFlag) {
					possibleFlag = false;
					break;
				}
				int newVal = input[end];
				for(int i = start; i < end; i++) {
					if(input[i] == newVal) {
						possibleFlag = true;
						if(end - start > solnLength) {
							solnLength = end - start;
							soln[0] = start;
							soln[1] = solnLength;
							break;
						}
					}
				}
			}
		}
		if(solnLength == 0)
			soln[1] = size;
		System.out.println(soln[0] + " " + soln[1]);
	}
}