public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		
		for(int k = 0; k < arr.length; k++){
			int count = 0;
			for(int j = k+1; j < arr.length; j++){
				if(arr[k] == arr[j])
					count++;
			}
			if (count == 0)
				System.out.println("No duplicates with value " + arr[k] + " beyond Index " + k);
			if (count == 1)
				System.out.println("There is only 1 more occurrence of value " + arr[k] + " starting at Index " + k);
			if (count > 1)
				System.out.println("There are " + count + " more occurrences of value " + arr[k] + " starting at Index " + k);
		}
	}
}