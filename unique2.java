import java.util.*;
import java.util.TreeMap;
import java.util.SortedMap;

public class unique2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++)
			input[i] = sc.nextInt();
		boolean possibleFlag = false;
		int solnLength = 0;
		TreeMap<Integer, String> possibleSolnMap = new TreeMap<>();
		int[] soln = new int[2];	// Solution index in 0, length in 1
		for(int start = 0; start < size; start++) {
			possibleSolnMap.put(input[start], "val");
			for(int end = start + 1; end < size; end++) {
				int newVal = input[end];
				if(possibleSolnMap.containsKey(newVal)) {
					possibleFlag = true;
					if(end - start > solnLength) {
						solnLength = possibleSolnMap.size();
						soln[0] = start;
						soln[1] = solnLength;
					}
					possibleSolnMap.clear();
					break;
				} else {
					possibleSolnMap.put(newVal, "val");
					if (start == 0 && end == size - 1) {
						solnLength = size;
						soln[1] = solnLength;
					}
				}
			}
		}
		if(solnLength == 0)
			soln[1] = size;
		System.out.println(soln[0] + " " + soln[1]);
	}
}